/**
 * Taken from https://github.com/Shynixn/MCCoroutine
 * Added to this utils package because it seemed useful, but credit where credit is due.
 */
package dev.jaims.mcutils.bukkit

import org.bukkit.plugin.Plugin

/**
 * Executes the given [f] via the [plugin] asynchronous.
 */
fun async(plugin: Plugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, f: () -> Unit) {
    when (repeatingTicks > 0) {
        true -> plugin.server.scheduler.runTaskTimerAsynchronously(plugin, f, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLaterAsynchronously(plugin, f, delayTicks)
    }
}

/**
 * Executes the given [f] via the [plugin] synchronized with the server tick.
 */
fun sync(plugin: Plugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, f: () -> Unit) {
    when (repeatingTicks > 0) {
        true -> plugin.server.scheduler.runTaskTimer(plugin, f, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLater(plugin, f, delayTicks)
    }
}