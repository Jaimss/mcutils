package dev.jaims.mcutils.tests

import dev.jaims.mcutils.bukkit.util.colorize
import net.md_5.bungee.api.ChatColor
import org.junit.Test
import kotlin.test.assertEquals

class BukkitTests
{

    @Test
    fun chatColorizeTest()
    {
        assertEquals(
            "${ChatColor.of("#abc123")}My Message ${ChatColor.of("#ffaa00")}Color",
            "<#abc123>My Message <#ffaa00>Color".colorize()
        )
    }

}