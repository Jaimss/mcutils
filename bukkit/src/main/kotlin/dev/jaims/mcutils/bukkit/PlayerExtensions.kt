package dev.jaims.mcutils.bukkit

import org.bukkit.Location
import org.bukkit.command.CommandSender
import org.bukkit.entity.Damageable
import org.bukkit.entity.Player

/**
 * Sends a message to a player or a commandsender.
 *
 * @param message the message to send the player
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(message: String, player: Player? = null) {
    this.sendMessage(message.colorize(player))
}

/**
 * Send multiple messsages at once to a commandsender or player
 *
 * @param messages the list of messages to send
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun CommandSender.send(messages: MutableList<String>, player: Player? = null) {
    for (m in messages) {
        send(m, player)
    }
}

/**
 * Send a message to a list of command senders
 *
 * @param message the message to send to all the players
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun MutableList<Player>.send(message: String, player: Player? = null) {
    for (cs in this) {
        cs.send(message, player)
    }
}

/**
 * Send a list of messages to a list of players
 *
 * @param messages the list of messages to send
 * @param player a player to use for PlaceholderAPI's placeholders
 */
fun MutableList<Player>.send(messages: MutableList<String>, player: Player? = null) {
    for (m in messages) {
        send(m, player)
    }
}

/**
 * Check if a player is within a certain radius of an [org.bukkit.Location]
 *
 * @param location the location to check against
 * @param radius the radius to be in
 * @return true if the player is in the radius, false if not
 */
fun Player.inRadiusOfLocation(location: Location, radius: Int): Boolean {
    return location.y > location.y - radius &&
            location.y < location.y + radius &&
            location.x > location.x - radius &&
            location.x < location.y + radius &&
            location.z > location.z - radius &&
            location.z < location.z + radius
}

/**
 * Kill a [Damageable] entity
 */
fun Damageable.kill() {
    health = 0.0
}

/**
 * Heal a [Damageable] entity.
 * Default for [newHealth] is 20
 */
fun Damageable.heal(newHealth: Double = 20.0) {
    health = newHealth
}

/**
 * Feed a [Player]
 * Default for [newFood] is 20
 */
fun Player.feed(newFood: Int = 20) {
    foodLevel = newFood
}
