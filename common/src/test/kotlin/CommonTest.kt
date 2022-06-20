import dev.jaims.mcutils.common.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CommonTest {

    @Test
    fun romanNumeralTest() {
        assertEquals("X", 10.toRomanNumeral())
    }

    @Test
    fun timeFormattedTest() {
        assertEquals(
            mapOf(
                Times.YEARS to 0,
                Times.MONTHS to 0,
                Times.WEEKS to 0,
                Times.DAYS to 0,
                Times.HOURS to 0,
                Times.MINUTES to 0,
                Times.SECONDS to 10
            ),
            10.toTimeFormatted()
        )
        assertEquals(
            mapOf(
                Times.YEARS to 0,
                Times.MONTHS to 0,
                Times.WEEKS to 0,
                Times.DAYS to 0,
                Times.HOURS to 1,
                Times.MINUTES to 0,
                Times.SECONDS to 10
            ),
            3610.toTimeFormatted()
        )
    }

    @Test
    fun getInputTypeTest() {
        assertEquals(
            InputType.UUID,
            "ca606d09-dced-4241-94a6-eaa7d4525d9f".getInputType()
        )
        assertEquals(
            InputType.SHORTUUID,
            "ca606d09dced424194a6eaa7d4525d9f".getInputType()
        )
        assertEquals(
            InputType.NAME,
            "Jaimss".getInputType()
        )
    }

    @Test
    fun toPasteTest() {
        println("One Line".toPastebin())
        println("Multi Line\nNext".toPastebin())
    }
}