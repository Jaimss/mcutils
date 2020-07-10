import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
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
fun Player.send(message: String, player: Player?=null) {
    this.sendMessage(message.colorize(player))
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
            1 to "I")
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