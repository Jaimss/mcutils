package dev.jaims.mcutils.bukkit.util

import dev.jaims.mcutils.bukkit.KotlinPlugin
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitTask

/**
 * Executes the given [block] via the [plugin] asynchronous.
 */
fun async(plugin: KotlinPlugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, block: () -> Unit): BukkitTask
{
    return when (repeatingTicks > 0)
    {
        true -> plugin.server.scheduler.runTaskTimerAsynchronously(plugin, block, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLaterAsynchronously(plugin, block, delayTicks)
    }
}

/**
 * Executes the given [block] via the [plugin] synchronized with the server tick.
 */
fun sync(plugin: KotlinPlugin, delayTicks: Long = 0L, repeatingTicks: Long = 0L, block: () -> Unit): BukkitTask
{
    return when (repeatingTicks > 0)
    {
        true -> plugin.server.scheduler.runTaskTimer(plugin, block, delayTicks, repeatingTicks)
        false -> plugin.server.scheduler.runTaskLater(plugin, block, delayTicks)
    }
}