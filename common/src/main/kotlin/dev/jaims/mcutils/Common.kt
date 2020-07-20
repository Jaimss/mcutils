package dev.jaims.mcutils

/**
 * Turn an int into a Roman Numeral String
 * @return the correct roman numeral string for [this]
 */
fun Int.toRomanNumeral(): String {
    val map = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var remainder = this
    var output = ""

    for ((int, str) in map) {
        while (remainder / int > 0) {
            remainder -= int
            output += str
        }
    }
    return output
}

/**
 * @return the seconds difference between two dates.
 */
fun Date.getSecondsDifference(date: Date): Int {
    return ((this.time - date.time) / 1000).toInt()
}

/**
 * Get the different hours, minutes, seconds, etc. from a Integer in seconds
 * @return a map of the proper time units
 */
fun Int.toTimeFormatted(): Map<Times, Int> {
    var remainder = this
    val years = remainder / 31536000
    remainder -= years * 31536000
    val months = remainder / 2592000
    remainder -= months * 2592000
    val weeks = remainder / 604800
    remainder -= weeks * 604800
    val days = remainder / 86400
    remainder -= days * 86400
    val hours = remainder / 3600
    remainder -= hours * 3600
    val minutes = remainder / 60
    remainder -= minutes * 60
    val seconds = remainder
    return mapOf(
        Times.YEARS to years,
        Times.MONTHS to months,
        Times.WEEKS to weeks,
        Times.DAYS to days,
        Times.HOURS to hours,
        Times.MINUTES to minutes,
        Times.SECONDS to seconds
    )
}

/**
 * A simple enum for the names of different time specs.
 */
enum class Times(val placeholder: String) {
    YEARS("years"),
    MONTHS("months"),
    WEEKS("weeks"),
    DAYS("days"),
    HOURS("hours"),
    MINUTES("minutes"),
    SECONDS("seconds");

    override fun toString(): String {
        return placeholder
    }
}