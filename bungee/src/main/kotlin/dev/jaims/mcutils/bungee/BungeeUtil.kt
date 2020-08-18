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

    var final = this
    val matcher = pattern.matcher(final)
    while (matcher.find()) {
        try {
            val hex = matcher.group().replace("<", "").replace(">", "")
            val color = ChatColor.of(hex)
            if (color != null) final = final.replace(matcher.group(), color.toString())
        } catch (ignored: IllegalArgumentException) {
            println("ERROR")
        }
    }

    return ChatColor.translateAlternateColorCodes('&', final)
}