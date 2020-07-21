package dev.jaims.mcutils

import java.util.*

/**
 * Turn an int into a Roman Numeral String
 *
 * @return the correct roman numeral string
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
 * Get the difference in time (seconds) between two [java.util.Date]
 *
 * @param date the old date
 * @return the seconds difference between two dates.
 */
fun Date.getSecondsDifference(date: Date): Int {
    return ((this.time - date.time) / 1000).toInt()
}

/**
 * Get the different hours, minutes, seconds, etc. from a Integer in seconds
 *
 * @return a map of times and ints where time is the [Times] and [Int] is the amount of that time
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
 * @return what type of [InputType] a certain string is
 */
fun String.getInputType(): InputType {
    if (matches("[A-Za-z0-9]{8}[-][A-Za-z0-9]{4}[-][A-Za-z0-9]{4}[-][A-Za-z0-9]{4}[-][A-Za-z0-9]{12}".toRegex()))
        return InputType.UUID
    if (matches("[A-Za-z0-9]{32}".toRegex())) return InputType.SHORTUUID
    return InputType.NAME
}

/**
 * A simple enum class for input types
 * Useful when getting user inputs to see if it is a UUID or a username
 */
enum class InputType {

    UUID,
    SHORTUUID,
    NAME;
}

/**
 * @param placeholder is the name that you can use in placeholders for lang filesa. its also just a lowercase version
 * of the name
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