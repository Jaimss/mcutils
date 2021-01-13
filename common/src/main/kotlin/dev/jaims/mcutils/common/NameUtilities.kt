package dev.jaims.mcutils.common

import org.json.JSONObject
import java.util.*

/**
 * Get the UUID of a Name
 *
 * @return the [UUID]
 */
fun String.getUUID(): UUID?
{
    val url = "https://playerdb.co/api/player/minecraft/$this"
    val json = khttp.get(url).jsonObject
    return if (!json.getBoolean("success")) null
    else
    {
        val playerObj: JSONObject = json.getJSONObject("data").getJSONObject("player")
        UUID.fromString(playerObj.getString("id"))
    }
}

/**
 * Get the Name of a uuid
 *
 * @return the name [String]
 */
fun UUID.getName(): String?
{
    val url = "https://playerdb.co/api/player/minecraft/$this"
    val json = khttp.get(url).jsonObject
    return if (!json.getBoolean("success")) null
    else
    {
        val playerObj: JSONObject = json.getJSONObject("data").getJSONObject("player")
        playerObj.getString("username")
    }
}