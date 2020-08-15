package dev.jaims.mcutils.bukkit

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import java.util.regex.Pattern

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