package dev.jaims.mcutils

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import java.util.regex.Pattern
import javax.print.attribute.standard.Severity

/**
 * A chat colorization util that supports hex.
 * Loosely based off of https://gist.github.com/iGabyTM/7415263c2209653ede82457c289de697
 *
 * @param player the player to use for color codes
 */
fun String.colorize(player: Player? = null): String {
    val pattern = Pattern.compile(
            "<(#[a-f0-9]{6}|aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow)>",
            Pattern.CASE_INSENSITIVE
    )

    val matcher = pattern.matcher(this)
    while (matcher.find()) {
        try {
            val color = net.md_5.bungee.api.ChatColor.of(matcher.group(1))
            if (color != null) this.replace(matcher.group(), color.toString())
        } catch (ignored: IllegalArgumentException) {
        }
    }
    val final = when (player == null) {
        true -> this
        false -> PlaceholderAPI.setPlaceholders(player, this)
    }
    return ChatColor.translateAlternateColorCodes('&', final)

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

/**
 * Register a new command
 *
 * @param commandExecutor the command executor
 * @param name the name of the command
 */
fun Plugin.register(commandExecutor: CommandExecutor, name: String) {
    this.server.getPluginCommand(name)?.setExecutor(commandExecutor)
            ?: log("There was an error registering the $name command.", Severity.WARNING)
}

/**
 * Register a new listener
 *
 * @param listener the listener class
 */
fun Plugin.register(listener: Listener) {
    server.pluginManager.registerEvents(listener, this)
}


