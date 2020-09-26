package dev.jaims.mcutils.bukkit.event

import dev.jaims.mcutils.bukkit.sync
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask

/**
 * A listener extension that lets me easily call the onEvent method
 */
interface ListenerExt<T : Event> : Listener {
    fun onEvent(event: T)
}

/**
 * Wait for an event to occur, then unregiter (or a timeout)
 * The timeout is specified with [timeoutTicks] and if it is reached, the [timeoutAction] will happen
 * You can set [ignoreCancelled] and [priority], however both have normal defaults and can usually be left
 * The event will only occur if [predicate] returns true, and when it does occur, the [action] will be run.
 */
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

/**
 * Listen for an event as long as [this] plugin is Enabled. The [predicate] is optional. It can be nice for quick events, but it also default to true
 * to allow for customization.
 * You can also set [ignoreCancelled] and [priority]
 * When this is detected, if the [predicate] is matched, the [action] is run
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : Event> Plugin.listenForEvent(
    ignoreCancelled: Boolean = false,
    priority: EventPriority = EventPriority.NORMAL,
    crossinline predicate: (T) -> Boolean = { true },
    crossinline action: (T) -> Unit
) {

    val listener = object : ListenerExt<T> {
        override fun onEvent(event: T) {
            if (!predicate(event)) return
            action(event)
        }
    }

    server.pluginManager.registerEvent(
        T::class.java,
        listener,
        priority,
        { l, e -> (l as ListenerExt<T>).onEvent(e as T) },
        this,
        ignoreCancelled
    )

}

