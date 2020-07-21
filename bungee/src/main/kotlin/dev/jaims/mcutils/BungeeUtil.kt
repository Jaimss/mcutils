package dev.jaims.mcutils

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.api.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * Turn a string into a colored string.
 *
 * @return a colorized string
 */
fun String.colorize(): String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

/**
 * A way to log messages to your plugins console much easier.
 *
 * @param message - The message that you want to log to your plugins console.
 * @param severity - The severity of the message. Can be used for warnings & errors in console.
 */
fun Plugin.log(message: String, severity: Severity = Severity.REPORT) {
    when (severity) {
        Severity.REPORT -> this.logger.info(message.colorize())
        Severity.ERROR -> this.logger.severe(message.colorize())
        Severity.WARNING -> this.logger.warning(message.colorize())
    }
}

/**
 * Send a message to someone
 *
 * @param message the message to send
 */
fun CommandSender.send(message: String) {
    sendMessage(*TextComponent.fromLegacyText(message.colorize()))
}

/**
 * Send multiple messsages at once
 *
 * @param messages the list of messages to send
 */
fun CommandSender.send(messages: MutableList<String>) {
    for (m in messages) {
        send(m)
    }
}

/**
 * Send a message to a list of command senders
 *
 * @param message the message to send
 */
fun MutableList<ProxiedPlayer>.send(message: String) {
    for (cs in this) {
        cs.send(message)
    }
}

/**
 * Send a list of messages
 *
 * @param messages the list of messages to send
 */
fun MutableList<ProxiedPlayer>.send(messages: MutableList<String>) {
    for (m in messages) {
        send(m)
    }
}

/**
 * Register a command
 *
 * @param command the command class to register
 */
fun Plugin.register(command: Command) {
    proxy.pluginManager.registerCommand(this, command)
}

/**
 * Register a listener
 *
 * @param listener the listener class to register
 */
fun Plugin.register(listener: Listener) {
    proxy.pluginManager.registerListener(this, listener)
}