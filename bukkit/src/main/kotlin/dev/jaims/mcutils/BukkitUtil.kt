package dev.jaims.mcutils

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * A simple chat colorization method.
 * @return The properly colored string. If a [player] is provided, that player will be used in PlaceholderAPI's
 * placeholders.
 */
fun String.colorize(player: Player? = null): String {
    var result = ChatColor.translateAlternateColorCodes('&', this)
    if (player != null) result = PlaceholderAPI.setPlaceholders(player, result)
    return result
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
 * Sends [this] player a [message] that is colorized!
 * @param player - a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(message: String, player: Player? = null) {
    this.sendMessage(message.colorize(player))
}

/**
 * Send multiple messsages at once
 * @param messages the list of messages to send
 */
fun CommandSender.send(messages: MutableList<String>) {
    for (m in messages) {
        send(m)
    }
}

/**
 * Send a message to a list of command senders
 * @param message the message to send to all the players
 */
fun MutableList<Player>.send(message: String) {
    for (cs in this) {
        cs.send(message)
    }
}

/**
 * Send a list of messages
 * @param messages the list of messages to send
 */
fun MutableList<Player>.send(messages: MutableList<String>) {
    for (m in messages) {
        send(m)
    }
}

/**
 * @param location the location to check against
 * @param radius the radius to be in
 * @return if the player is within a certain amount of blocks of a location
 */
fun Player.inRadiusOfLocation(location: Location, radius: Int): Boolean {
    return this.location.y > location.y - radius &&
            this.location.y < location.y + radius &&
            this.location.x > location.x - radius &&
            this.location.x < location.y + radius &&
            this.location.z > location.z - radius &&
            this.location.z < location.z + radius
}


