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
 *
 * @param player the player to use for PlaceholderAPI's placeholders. If null, it will be ignored and placeholders
 * will not work
 * @return The new string with placeholders and colors.
 */
fun String.colorize(player: Player? = null): String {
    var result = ChatColor.translateAlternateColorCodes('&', this)
    if (player != null) result = PlaceholderAPI.setPlaceholders(player, result)
    return result
}

/**
 * A way to log messages to your plugins console much easier.
 *
 * @param message The message that you want to log to your plugins console.
 * @param severity The [javax.print.attribute.standard.Severity] of the message. Can be used for warnings & errors
 * in console.
 */
fun Plugin.log(message: String, severity: Severity = Severity.REPORT) {
    when (severity) {
        Severity.REPORT -> this.logger.info(message.colorize())
        Severity.ERROR -> this.logger.severe(message.colorize())
        Severity.WARNING -> this.logger.warning(message.colorize())
    }
}

/**
 * Sends a message to a player or a commandsender.
 *
 * @param message the message to send the player
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(message: String, player: Player? = null) {
    this.sendMessage(message.colorize(player))
}

/**
 * Send multiple messsages at once to a commandsender or player
 *
 * @param messages the list of messages to send
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(messages: MutableList<String>, player: Player? = null) {
    for (m in messages) {
        send(m, player)
    }
}

/**
 * Send a message to a list of command senders
 *
 * @param message the message to send to all the players
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun MutableList<Player>.send(message: String, player: Player? = null) {
    for (cs in this) {
        cs.send(message, player)
    }
}

/**
 * Send a list of messages to a list of players
 *
 * @param messages the list of messages to send
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun MutableList<Player>.send(messages: MutableList<String>, player: Player? = null) {
    for (m in messages) {
        send(m, player)
    }
}

/**
 * Check if a player is within a certain radius of an [org.bukkit.Location]
 *
 * @param location the location to check against
 * @param radius the radius to be in
 * @return true if the player is in the radius, false if not
 */
fun Player.inRadiusOfLocation(location: Location, radius: Int): Boolean {
    return this.location.y > location.y - radius &&
            this.location.y < location.y + radius &&
            this.location.x > location.x - radius &&
            this.location.x < location.y + radius &&
            this.location.z > location.z - radius &&
            this.location.z < location.z + radius
}


