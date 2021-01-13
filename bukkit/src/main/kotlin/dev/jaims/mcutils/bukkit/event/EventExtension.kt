package dev.jaims.mcutils.bukkit.event

import dev.jaims.mcutils.bukkit.KotlinPlugin
import dev.jaims.mcutils.bukkit.util.sync
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.scheduler.BukkitTask

/**
 * A listener extension that lets me easily call the onEvent method
 */
interface ListenerExt<T : Event> : Listener
{
    fun onEvent(event: T)
}

/**
 * Wait for an event to occur, then unregister it on a timeout or when the event occurs once. Useful for listening to chat
 * messages for example.
 *
 * @param timeoutTicks the time to wait for in ticks
 * @param ignoreCancelled should it ignore cancelled
 * @param priority the priority of the listener
 * @param action the action to run when the even occurs
 * @param predicate the check that the event must meet
 * @param timeoutAction the action if you timout
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : Event> KotlinPlugin.waitForEvent(
    timeoutTicks: Long = -1,
    ignoreCancelled: Boolean = false,
    priority: EventPriority = EventPriority.NORMAL,
    crossinline predicate: (T) -> Boolean = { true },
    crossinline timeoutAction: () -> Unit = {},
    crossinline action: (T) -> Unit,
)
{
    var task: BukkitTask? = null

    // a listener for the event
    val listener = object : ListenerExt<T>
    {
        override fun onEvent(event: T)
        {
            if (!predicate(event)) return
            action(event)
            task?.cancel()
        }
    }
    // register the event itself
    server.pluginManager.registerEvent(
        T::class.java,
        listener,
        priority,
        { l, e -> (l as ListenerExt<T>).onEvent(e as T); HandlerList.unregisterAll(l) },
        this@waitForEvent,
        ignoreCancelled
    )

    // if they want a timeout, start a timeout
    if (timeoutTicks > 0)
    {
        task = sync(this, delayTicks = timeoutTicks) { HandlerList.unregisterAll(listener); timeoutAction() }
    }
}