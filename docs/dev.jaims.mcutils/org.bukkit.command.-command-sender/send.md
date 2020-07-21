---
title: send - mcutils
---

[mcutils](../../index.html) / [dev.jaims.mcutils](../index.html) / [org.bukkit.command.CommandSender](index.html) / [send](./send.html)

# send

`fun CommandSender.send(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, player: Player? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends a message to a player or a commandsender.

### Parameters

`message` - the message to send the player

`player` - a player to use for PlaceholderAPI's placeholders`fun CommandSender.send(messages: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, player: Player? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Send multiple messsages at once to a commandsender or player

### Parameters

`messages` - the list of messages to send

`player` - a player to use for PlaceholderAPI's placeholders