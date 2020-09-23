package dev.jaims.mcutils.bukkit

import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * A way to log messages to your plugins console much easier. The [message] you provide will be given a toString call.
 * The [severity] you provide is how it will appear in console.
 */
fun Plugin.log(message: Any?, severity: Severity = Severity.REPORT) {
    when (severity) {
        Severity.ERROR -> this.logger.severe(message.toString().colorize())
        Severity.WARNING -> this.logger.warning(message.toString().colorize())
        else -> this.logger.info(message.toString().colorize())
    }
}

/**
 * Register a new command
 *
 * @param commandExecutor the command executor
 * @param name the name of the command
 */
fun Plugin.register(commandExecutor: CommandExecutor, name: String) {
    this.server.getPluginCommand(name)?.setExecutor(commandExecutor)
            ?: log("There was an error registering the $name command. Make sure it is in the plugin.yml!",
                    Severity.WARNING)
}

/**
 * Register a new listener
 *
 * @param listener the listener class
 */
fun Plugin.register(vararg listener: Listener, plugin: Plugin = this) {
    for (l in listener) {
        server.pluginManager.registerEvents(l, plugin)
    }
}