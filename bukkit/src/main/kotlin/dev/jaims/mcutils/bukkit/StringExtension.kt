package dev.jaims.mcutils.bukkit

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.util.regex.Pattern

/**
 * A chat colorization util that supports hex and PlaceholderAPI placeholders for a [player] if one is provided.
 * Loosely based off of https://gist.github.com/iGabyTM/7415263c2209653ede82457c289de697
 */
fun String.colorize(player: Player? = null): String {
    val pattern = Pattern.compile(
        "<(#[a-f0-9]{6}|aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow)>",
        Pattern.CASE_INSENSITIVE
    )

    var mutString = this
    val matcher = pattern.matcher(mutString)
    while (matcher.find()) {
        try {
            val color = net.md_5.bungee.api.ChatColor.of(matcher.group().replace("<", "").replace(">", ""))
            if (color != null) mutString = mutString.replace(matcher.group(), color.toString())
        } catch (ignored: IllegalArgumentException) {
        }
    }
    mutString = when (player == null) {
        true -> mutString
        false -> PlaceholderAPI.setPlaceholders(player, mutString)
    }
    return ChatColor.translateAlternateColorCodes('&', mutString)

}

/**
 * Colorize a list of strings
 */
fun List<String>.colorize(player: Player? = null): List<String> = map { it.colorize(player) }

