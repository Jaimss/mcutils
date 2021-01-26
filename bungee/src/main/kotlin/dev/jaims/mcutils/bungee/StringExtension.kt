package dev.jaims.mcutils.bungee

import net.md_5.bungee.api.ChatColor
import java.util.regex.Pattern

/**
 * Turn a string into a colored string.
 *
 * @return a colorized string
 */
fun String.colorize(): String {
    val pattern = Pattern.compile(
        "<(#[a-f0-9]{6}|aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow)>",
        Pattern.CASE_INSENSITIVE
    )

    var mutString = this
    val matcher = pattern.matcher(mutString)
    while (matcher.find()) {
        try {
            val hex = matcher.group().replace("<", "").replace(">", "")
            val color = ChatColor.of(hex)
            if (color != null) mutString = mutString.replace(matcher.group(), color.toString())
        } catch (ignored: IllegalArgumentException) {
        }
    }


    return ChatColor.translateAlternateColorCodes('&', mutString)
}

fun List<String>.colorize(): List<String> = map { it.colorize() }