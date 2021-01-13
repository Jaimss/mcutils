import dev.jaims.mcutils.bungee.colorize
import net.md_5.bungee.api.ChatColor
import kotlin.test.Test
import kotlin.test.assertEquals

class BungeeTests
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