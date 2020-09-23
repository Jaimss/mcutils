package dev.jaims.mcutils.bukkit.event

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

interface ListenerExt<T : Event> : Listener {
    fun onEvent(event: T)
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Event> Plugin.waitForEvent(
    timeoutMillis: Long = -1,
    ignoreCancelled: Boolean = false,
    priority: EventPriority = EventPriority.NORMAL,
    crossinline action: (T) -> Unit,
    crossinline predicate: (T) -> Boolean = { true },
    crossinline timeoutAction: () -> Unit = {}
) {
    GlobalScope.launch {
        // a listener for the event
        val listener = object : ListenerExt<T> {
            override fun onEvent(event: T) {
                if (!predicate(event)) return
                action(event).also { cancel() }
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
        if (timeoutMillis > 0) {
            delay(timeoutMillis)
            HandlerList.unregisterAll(listener)
            timeoutAction()
        }
    }

}
