package dev.jaims.mcutils.bukkit.util

import dev.jaims.mcutils.bukkit.KotlinPlugin
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import javax.print.attribute.standard.Severity

/**
 * A regular expression for hex chat.
 */
val pattern = "<(#[a-f0-9]{6}|aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow)>".toRegex()

/**
 * A chat colorization util that supports hex and PlaceholderAPI placeholders for a [player] if one is provided.
 */
fun String.colorize(player: Player? = null): String {
    val message = replace(pattern) {
        val hexCode = it.value.replace("<", "").replace(">", "")
        val color = net.md_5.bungee.api.ChatColor.of(hexCode)
        return@replace color.toString()
    }
    return ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, message))
}

/**
 * Colorize a list of strings
 */
fun List<String>.colorize(player: Player? = null): List<String> = map { it.colorize(player) }

fun String.log(severity: Severity = Severity.REPORT) {
    val plugin = JavaPlugin.getPlugin(KotlinPlugin::class.java)
    when (severity) {
        Severity.ERROR -> plugin.logger.severe(this.colorize())
        Severity.WARNING -> plugin.logger.warning(this.colorize())
        else -> plugin.logger.info(this.colorize())
    }
}