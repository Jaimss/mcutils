package dev.jaims.mcutils.bukkit.event

import dev.jaims.mcutils.bukkit.send
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

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
    runBlocking(Dispatchers.Default) {
        // a listener for the event
        val listener = object : ListenerExt<T> {
            override fun onEvent(event: T) {
                if (!predicate(event)) return
                action(event)
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

fun example(plugin: JavaPlugin, sender: Player) {
    plugin.waitForEvent<AsyncPlayerChatEvent>(
        timeoutMillis = 20 * 60,
        action = {
            it.player.send("Thanks for responding!")
        },
        predicate = {
            sender.uniqueId == it.player.uniqueId
        }
    )
}