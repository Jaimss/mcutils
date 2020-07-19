package dev.jaims.utils

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
 * Sends [this] player a [message] that is colorized!
 * @param player - a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(message: String, player: Player? = null) {
    this.sendMessage(message.colorize(player))
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
 * Turn an int into a Roman Numeral String
 * @return the correct roman numeral string for [this]
 */
fun Int.toRomanNumeral(): String {
    val map = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var remainder = this
    var output = ""

    for ((int, str) in map) {
        while (remainder / int > 0) {
            remainder -= int
            output += str
        }
    }
    return output
}

/**
 * Get the different hours, minutes, seconds, etc. from a Integer in seconds
 * @return a map of the proper time units
 */
fun Int.toTimeFormatted(): Map<Times, Int> {
    var remainder = this
    val years = 31536000 / remainder
    remainder -= years * 31536000
    val months = 2592000 / remainder
    remainder -= months * 2592000
    val weeks = remainder / 604800
    remainder -= weeks * 604800
    val days = remainder / 86400
    remainder -= days * 86400
    val hours = remainder / 3600
    remainder -= hours * 3600
    val minutes = remainder / 60
    remainder -= minutes * 60
    val seconds = remainder
    return mapOf(
        Times.YEARS to years,
        Times.MONTHS to months,
        Times.WEEKS to weeks,
        Times.DAYS to days,
        Times.HOURS to hours,
        Times.MINUTES to minutes,
        Times.SECONDS to seconds
    )
}

/**
 * A simple enum for the names of different time specs.
 */
enum class Times(val placeholder: String) {
    YEARS("years"),
    MONTHS("months"),
    WEEKS("weeks"),
    DAYS("days"),
    HOURS("hours"),
    MINUTES("minutes"),
    SECONDS("seconds");

    override fun toString(): String {
        return placeholder
    }
}


