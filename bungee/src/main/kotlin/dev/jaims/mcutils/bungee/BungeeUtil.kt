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

    val matcher = pattern.matcher(this)
    while (matcher.find()) {
        try {
            val color = ChatColor.of(matcher.group(1))
            if (color != null) this.replace(matcher.group(), color.toString())
        } catch (ignored: IllegalArgumentException) {
        }
    }

    return ChatColor.translateAlternateColorCodes('&', this)
}