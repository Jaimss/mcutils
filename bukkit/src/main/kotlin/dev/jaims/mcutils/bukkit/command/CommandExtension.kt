package dev.jaims.mcutils.bukkit.command

import dev.jaims.mcutils.bukkit.log
import dev.jaims.mcutils.bukkit.send
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginIdentifiableCommand
import org.bukkit.plugin.Plugin
import javax.print.attribute.standard.Severity

/**
 * Handle a simple command very easily; Registers the method
 * [T] is the type of [CommandSender] you want. A full list can be found at https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html
 * Registers itself to the plugin.yml, so no need to worry about that!
 */
inline fun <reified T : CommandSender> Plugin.handleCommand(
    commandName: String,
    description: String = "",
    usage: String = "&c/${commandName}",
    aliases: List<String> = listOf(),
    permission: String? = null,
    crossinline noPermissionmessage: (sender: CommandSender) -> Unit = { it.send("&cYou do not have permission!") },
    crossinline senderInvalidType: (sender: CommandSender) -> Unit = { it.send("&cYou must be a ${T::class.java.simpleName.toLowerCase()} to run this command!") },
    crossinline body: (sender: T, args: Array<out String>) -> Unit
) {
    object : Command(commandName, description, usage, aliases) {
        override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
            if (sender !is T) {
                senderInvalidType(sender)
                return false
            }
            if (permission != null && !sender.hasPermission(permission)) {
                noPermissionmessage(sender)
                return false
            }
            body(sender, args)
            return true
        }
    }.registerPluginYml(this)
}

/**
 * Based off of MF-CMD (to register each command without the plugin.yml)
 */
fun Command.registerPluginYml(plugin: Plugin): Command {
    try {
        val getCmdMap = Bukkit.getServer()::class.java.getDeclaredMethod("getCommandMap")
        getCmdMap.isAccessible = true
        val commandMap = getCmdMap.invoke(Bukkit.getServer()) as CommandMap

        val oldcmd = commandMap.getCommand(name)
        if (oldcmd is PluginIdentifiableCommand && oldcmd.plugin == plugin) {
            oldcmd.unregister(commandMap)
        }

        commandMap.register(plugin.name, this)
    } catch (e: NoSuchMethodError) {
        plugin.log(
            "The `getCommandMap` method was not found, so the ${this.name} command couldn't be registered! Please let James know at https://discord.jaims.dev",
            Severity.ERROR
        )
    }

    return this
}



