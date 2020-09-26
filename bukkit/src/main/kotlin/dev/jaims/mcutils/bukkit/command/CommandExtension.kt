package dev.jaims.mcutils.bukkit.command

import dev.jaims.mcutils.bukkit.register
import dev.jaims.mcutils.bukkit.send
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

/**
 * Handle a simple command very easily; Registers the method
 * Uses [Plugin.register], which will give a nice warning message if the command is not in the plugin.yml
 * [T] is the type of [CommandSender] you want. A full list can be found at https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html
 */
inline fun <reified T : CommandSender> Plugin.handleCommand(
    commandName: String,
    crossinline senderInvalidType: (sender: CommandSender) -> Unit = { it.send("&cYou must be a ${T::class.java.simpleName} to run this command.!") },
    crossinline body: (sender: T, args: Array<out String>) -> Unit
) {
    CommandExecutor { sender, _, _, args ->
        if (sender !is T) {
            senderInvalidType(sender)
            return@CommandExecutor false
        }
        body(sender, args)
        true
    }.also { register(it, commandName) }
}

