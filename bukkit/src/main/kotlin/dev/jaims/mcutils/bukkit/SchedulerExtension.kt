/**
 * Taken from https://github.com/Shynixn/MCCoroutine
 * Added to this utils package because it seemed useful, but credit where credit is due.
 */
package dev.jaims.mcutils.bukkit

import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask

/**
 * Executes the given [block] via the [plugin] asynchronous.
 */
fun async(plugin: Plugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, block: () -> Unit): BukkitTask {
    return when (repeatingTicks > 0) {
        true -> plugin.server.scheduler.runTaskTimerAsynchronously(plugin, block, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLaterAsynchronously(plugin, block, delayTicks)
    }
}

/**
 * Executes the given [block] via the [plugin] synchronized with the server tick.
 */
fun sync(plugin: Plugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, block: () -> Unit): BukkitTask {
    return when (repeatingTicks > 0) {
        true -> plugin.server.scheduler.runTaskTimer(plugin, block, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLater(plugin, block, delayTicks)
    }
}