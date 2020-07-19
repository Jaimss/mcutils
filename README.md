# Jaims' Utils
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
- Latest Version: `2.0`
- Platform:
    - `bungee` for Bungeecord Development
    - `bukkit` for Bukkit Development
###### Gradle (build.gradle)
```gradle
repositories {
    mavenCentral() // coming soon
}
dependencies {
    implementation 'dev.jaims.jaimsutils:{platform}:{version}'
}
```
###### Maven (pom.xml)
```xml
<dependencies>
    <dependency>
        <groupId>dev.jaims.jaimsutils</groupId>
        <artifactId>{platform}</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>
```

#### Examples
For Usage Examples, please see the [wiki](https://github.com/Jaimss/Jaims-Utils/wiki).

#### Bugs / Feature Requests
If you would like to report a bug, or request a feature, please open an [issue](https://github.com/Jaimss/Jaims-Utils/issues).

#### Contributing
If you would like to contribute, you can open a [pull request](https://github.com/Jaimss/Jaims-Utils/pulls). If you would like to discuss first, please make an [issue](https://github.com/Jaimss/Jaims-Utils/issues).
