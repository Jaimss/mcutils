package dev.jaims.jaimsutils

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * @return a colorized string
 */
fun String.colorize(): String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

/**
 * A way to log messages to your plugins console much easier.
 * @param message - The message that you want to log to your plugins console.
 * @param severity - The [Severity] of the message. Can be used for warnings & errors in console.
 * This is an extension function of [org.bukkit.plugin.Plugin]
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
 */
fun CommandSender.send(message: String) {
    sendMessage(*TextComponent.fromLegacyText(message.colorize()))
}