package dev.jaims.mcutils.bukkit.cooldown

import dev.jaims.mcutils.bukkit.async
import dev.jaims.mcutils.bukkit.sync
import org.bukkit.plugin.java.JavaPlugin

/**
 * A class to handle cooldowns.
 *
 * @param plugin the Plugin to run the task which will execute [action]
 * @param durationSeconds the duration in seconds of the cooldown
 * @param sync whether to run the [action] in sync or async
 * @param action the action to run after the duration has expired. You can leave this blank if you like. Will be ran sync if [sync] is true. If no action is specified, no task will be queued.
 */
class Cooldown(
    plugin: JavaPlugin,
    private val durationSeconds: Int,
    private val sync: Boolean = true,
    private val action: () -> Unit = {}
) {

    // the start time of the cooldown
    private val startTime = System.currentTimeMillis()

    // run the action if it needs to be run
    init {
        if (action != {}) {
            when (sync) {
                true -> sync(plugin, durationSeconds * 20L, block = action)
                false -> async(plugin, durationSeconds * 20L, block = action)
            }
        }
    }

    /**
     * @return true if the time elapsed is less than or equal to the duraiton.
     */
    val isActive: Boolean = ((System.currentTimeMillis() - startTime) / 1000) <= durationSeconds

}