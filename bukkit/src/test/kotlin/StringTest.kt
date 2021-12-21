import dev.jaims.mcutils.bukkit.func.colorize
import net.md_5.bungee.api.ChatColor
import kotlin.test.Test
import kotlin.test.assertEquals

class StringTest {

    @Test
    fun colorization() {
        val message = "<#abc123>This is a &3message. <#ffaa00>Yeet"
        val colored = "${ChatColor.of("#abc123")}This is a ${ChatColor.DARK_AQUA}message. ${ChatColor.of("#ffaa00")}Yeet"
        assertEquals(colored, message.colorize())
    }

}