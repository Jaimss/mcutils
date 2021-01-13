package dev.jaims.mcutils.bungee

import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent

/**
 * Send a message to someone
 *
 * @param message the message to send
 */
fun CommandSender.send(message: String)
{
    sendMessage(*TextComponent.fromLegacyText(message.colorize()))
}

/**
 * Send multiple messsages at once
 *
 * @param messages the list of messages to send
 */
fun CommandSender.send(messages: MutableList<String>)
{
    for (m in messages)
    {
        send(m)
    }
}

/**
 * Send a message to a list of command senders
 *
 * @param message the message to send
 */
fun <T : CommandSender> MutableList<T>.send(message: String)
{
    for (cs in this)
    {
        cs.send(message)
    }
}

/**
 * Send a list of messages
 *
 * @param messages the list of messages to send
 */
fun <T : CommandSender> MutableList<T>.send(messages: MutableList<String>)
{
    for (m in messages)
    {
        send(m)
    }
}