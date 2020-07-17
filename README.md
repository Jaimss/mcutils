# Jaims' Utils
Utilities package for Minecraft Development.

### Language Support
As far as I know, after including this in your plugin, you *should* be able to use the features in both Kotlin and Java, ***however***, I will only provide support for Kotlin related issues.

### Features
The two main features of this project are
- [`The Item Builder`](https://github.com/Jaimss/Jaims-Utils/blob/master/utils/src/main/kotlin/ItemBuilder.kt)
- [`The General Utils for Bukkit`](https://github.com/Jaimss/Jaims-Utils/blob/master/utils/src/main/kotlin/GeneralUtil.kt)

##### The ItemBuilder
The ItemBuilder is a feature intended to make it as easy as possible to make custom Items in your plugin.
###### Example:
```kotlin
ItemBuilder(Material.DIAMOND_SWORD) // create a diamond sword item
        .addEnchantment(Enchantment.DAMAGE_ALL, 4) // will add Sharpness 4 to the item
        .addEnchantment(Enchantment.FIRE_ASPECT) // will add fire aspect 1
        .setName("Jaims' Sword") // will set the Item Name
        .addLore("Don't Use!") // this is a single line lore
        .addLore(listOf(
                "Or Else!",
                "He will be mad!"
        )) // add a multi line lore
        .get() // returns the ItemStack with all the features from above
```

##### The General Utils for Bukkit
The General Utils feature is intended to make basic things like sending players messages, colorizing your messages, logging messages to console, and more an easy action that doesn't require extra work.
###### Examples:
```kotlin
"&3This &bis &9a &6message".colorize() // will turn the message into a colored message using the color codes given
player.send("&aYour name is %player_name%", player) // will send a player a message and set the placeholder
player.send("&3Hey, welcome to our server!") // send a colored message
plugin.log("&dThis is a log message!") // sends a log to console
plugin.log("This is an error!", Severity.ERROR) // sends an error message to console
```
There are also a few fun things that can be useful at times:
```kotlin
val level = 10 // a random level for the player if you have a level system maybe
player.send("&aYour level is &2${level.toRomanNumeral()}") // lets you turn ints to roman numerals
```
