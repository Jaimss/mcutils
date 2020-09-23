package dev.jaims.mcutils.bukkit.event

import dev.jaims.mcutils.bukkit.sync
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask

interface ListenerExt<T : Event> : Listener {
    fun onEvent(event: T)
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Event> Plugin.waitForEvent(
    timeoutTicks: Long = -1,
    ignoreCancelled: Boolean = false,
    priority: EventPriority = EventPriority.NORMAL,
    crossinline action: (T) -> Unit,
    crossinline predicate: (T) -> Boolean = { true },
    crossinline timeoutAction: () -> Unit = {}
) {
    var task: BukkitTask? = null

    // a listener for the event
    val listener = object : ListenerExt<T> {
        override fun onEvent(event: T) {
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
    if (timeoutTicks > 0) {
        task = sync(this, delayTicks = timeoutTicks) { HandlerList.unregisterAll(listener); timeoutAction() }
    }

}
