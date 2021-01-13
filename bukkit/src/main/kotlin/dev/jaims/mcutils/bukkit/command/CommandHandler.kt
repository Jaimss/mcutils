package dev.jaims.mcutils.bukkit.command

import dev.jaims.mcutils.bukkit.KotlinPlugin
import dev.jaims.mcutils.bukkit.util.log
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import javax.print.attribute.standard.Severity

interface CommandHandler : CommandExecutor, TabExecutor
{

    /**
     * The method to execute a command.
     *
     * @param sender the sender of the command
     * @param args the arguments
     * @param props some [CommandProperties]
     */
    fun execute(sender: CommandSender, args: List<String>, props: CommandProperties)

    // the plugin instance
    val plugin: KotlinPlugin

    // a usage for the command
    val usage: String

    // a description of what the command does
    val description: String

    // the name of the command
    val commandName: String

    /**
     * override the default `onCommand`. it will call the new [execute] method
     */
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean
    {
        // send args as alist
        val newArgs = args.toMutableList()

        // determine if its silent
        // if ALERT_TARGET = false, they dont want to alert the target, so silent is true
        // if the args contains "-s", they dont want to alert, so silent is true and we remove "-s"
        var silent = false
        if (newArgs.remove("-s")) silent = true
        if (newArgs.remove("--silent")) silent = true

        // confirmation
        var isConfirmation = false
        if (newArgs.remove("-c")) isConfirmation = true
        if (newArgs.remove("--confirm")) isConfirmation = true

        // execute and return true cause we handle all messages
        execute(sender, newArgs, CommandProperties(silent, isConfirmation))
        return true
    }

    /**
     * A method to register a [CommandHandler]
     */
    fun register(plugin: KotlinPlugin)
    {
        val cmd = plugin.getCommand(commandName) ?: run {
            "Command with name $commandName is not in the plugin.yml!".log(Severity.ERROR)
            return
        }
        cmd.setExecutor(this)
    }

    /**
     * Tab complete isn't required, so it defaults to nothing, but it is available.
     */
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>
    {
        return mutableListOf()
    }

}

/**
 * A command properties class that lets us pass things to the [CommandHandler] execute method.
 */
data class CommandProperties(
    val silent: Boolean,
    val isConfirmation: Boolean,
)