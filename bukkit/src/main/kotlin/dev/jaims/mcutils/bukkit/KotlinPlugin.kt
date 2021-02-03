package dev.jaims.mcutils.bukkit

import dev.jaims.mcutils.bukkit.command.CommandHandler
import dev.jaims.mcutils.bukkit.util.log
import me.bristermitten.pdm.PluginDependencyManager
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import kotlin.system.measureTimeMillis

abstract class KotlinPlugin : JavaPlugin() {

    companion object {
        /**
         * The [Environment] of the server.
         */
        @JvmStatic
        val ENVIRONMENT: Environment = try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            Environment.PAPER
        } catch (e: ClassNotFoundException) {
            try {
                Class.forName("org.spigotmc.SpigotConfig");
                Environment.SPIGOT
            } catch (e1: ClassNotFoundException) {
                Environment.CRAFTBUKKIT
            }
        }
    }

    /**
     * true if the server is running paper.
     */
    val isPaper: Boolean = ENVIRONMENT == Environment.PAPER

    /**
     * We override onEnable to call all of our register methods and then our enable code.
     */
    override fun onEnable() {
        val millis = measureTimeMillis {
            PluginDependencyManager.of(this).loadAllDependencies().join()
            "&aEnabling ${description.name} (v${description.version})...".log()

            // register managers first
            registerManagers()
            registerCommands()
            registerListeners()

            // call our enable code
            enable()
        }
        "&a${description.name} (v${description.version}) enabled in &e$millis &ams!".log()
    }

    /**
     * Code to run in the onEnable block.
     */
    abstract fun enable()

    override fun onDisable() {
        val millis = measureTimeMillis {
            "&cDisabling ${description.name} (v${description.version})...".log()

            // call the disable method
            disable()
        }
        "&c${description.name} (v${description.version}) disabled in &e$millis &cms.".log()
    }

    /**
     * Disable logic.
     */
    abstract fun disable()

    /**
     * Code to register all managers/api things.
     */
    abstract fun registerManagers()

    /**
     * Code the register all the plugins listeners.
     */
    abstract fun registerListeners()

    /**
     * Code to register commands.
     */
    abstract fun registerCommands()

    /**
     * Register a variable amount of listeners.
     */
    protected fun register(vararg listener: Listener) = listener.forEach { server.pluginManager.registerEvents(it, this) }

    /**
     * Register a variable amount of [CommandHandler]s
     */
    protected fun register(vararg command: CommandHandler) = command.forEach { it.register(this) }
}