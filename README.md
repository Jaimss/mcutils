# Jaims' Utils [![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Jaimss/mcutils/blob/master/LICENSE)
A collection of Minecraft utilities for Bukkit/Bungeecord Plugin Development - so you don't need to create that Utils class every time ;)


#### Language Support
This project uses Kotlin. The majority of these features make use of Kotlin's [extension functions](https://kotlinlang.org/docs/reference/extensions.html).
This allows for you to use features like `Player#send("&3message")` and it will automatically color the message for you, however this does have some downsides.
From my experience, Java does not accept Kotlin's extension functions as valid methods, so if you are using Java for your plugins, many of these features still will not work.
Things like the `ItemBuilder`, however, still do work.
**I strongly suggest giving Kotlin a try!**

#### Bungeecord v Bukkit
This project was made with both Bungeecord and Bukkit in mind. 
When making a Bukkit plugin, you can include the Bukkit module as a dependency, and when making a Bungeecord plugin, you can include the Bungeecord dependency.

#### Including Jaims' Utils
[![Stable Release](https://img.shields.io/github/v/release/jaimss/mcutils?color=brightgreen&label=stable)](https://github.com/Jaimss/mcutils/releases) [![Latest Release](https://img.shields.io/github/v/release/jaimss/mcutils?color=ffaa00&include_prereleases&label=latest)](https://github.com/Jaimss/mcutils/releases)
- Platform:
    - `bungee` for Bungeecord Development
    - `bukkit` for Bukkit Development

One easy way to include this in your project is to use [jitpack](https://jitpack.io/#Jaimss/mcutils). You can simply navigate to the **releases** tab and select the latest from above.

Alternatively you can download the latest [package](https://github.com/Jaimss/mcutils/packages) or the latest [release](https://github.com/Jaimss/mcutils/releases/latest) and install it to your maven local repository with the following command `./gradlew publishToMavenLocal`. Then you can add it as a dependency like below:
###### Gradle (build.gradle)
```gradle
repositories {
    mavenLocal()
}
dependencies {
    implementation 'dev.jaims.mcutils:{platform}:{version}'
}
```
###### Maven (pom.xml)
```xml
<dependencies>
    <dependency>
        <groupId>dev.jaims.mcutils</groupId>
        <artifactId>{platform}</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>
```

#### Examples
For Usage Examples, please see the [wiki](https://github.com/Jaimss/Jaims-Utils/wiki). *(Coming Soon)*

#### Bugs / Feature Requests
If you would like to report a bug, or request a feature, please open an [issue](https://github.com/Jaimss/Jaims-Utils/issues).

#### Contributing
If you would like to contribute, you can open a [pull request](https://github.com/Jaimss/Jaims-Utils/pulls). If you would like to discuss first, please make an [issue](https://github.com/Jaimss/Jaims-Utils/issues).
