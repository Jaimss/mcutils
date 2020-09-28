package dev.jaims.mcutils.bungee

import net.md_5.bungee.api.plugin.Command
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * A way to log messages to your plugins console much easier.
 *
 * @param message - The message that you want to log to your plugins console.
 * @param severity - The severity of the message. Can be used for warnings & errors in console.
 */
fun Plugin.log(message: Any?, severity: Severity = Severity.REPORT) {
    when (severity) {
        Severity.REPORT -> this.logger.info(message.toString().colorize())
        Severity.ERROR -> this.logger.severe(message.toString().colorize())
        Severity.WARNING -> this.logger.warning(message.toString().colorize())
    }
}

/**
 * Register a command
 *
 * @param command the command class to register
 */
fun Plugin.register(vararg command: Command) {
    command.forEach {
        proxy.pluginManager.registerCommand(this, it)
    }
}

/**
 * Register a listener
 *
 * @param listener the listener class to register
 */
fun Plugin.register(vararg listener: Listener) {
    listener.forEach {
        proxy.pluginManager.registerListener(this, it)
    }
}