# McTiersBridge

Mctiersbridge is a Minecraft plugin that fetches tier info from  the official [mctiers tierlist](https://mctiers.com/ranking/overall) backend and implements [PAPI](https://github.com/PlaceholderAPI/PlaceholderAPI) to register placeholders based on tier info of the player. Also comes equipped with a developer API.

## Small documentation
```kotlin
// Adding the project - build.gradle
repositories {
    maven {
        name "ceymikeydev"
        url "https://repo.ceymikey.dev/releases"
    }
}

dependencies {
    implementation "dev.ceymikey:mctiersbridge-api:1.0.2"
}
```

## Placeholders
Raw example:
`%TierBridge_vanilla%` - Returns the vanilla tier of the player without player parameter.

- `%TierBridge_vanilla_{player}%` - Returns the vanilla tier of the player.
- `%TierBridge_overall_{player}%` - Returns the overall rank of the player.
- `%TierBridge_region_{player}%` - Returns the region of the player.
- `%TierBridge_points_{player}%` - Returns the overall points of the player.

## Available types
- `vanilla` - Vanilla tier
- `sword` - Sword tier
- `pot` - Pot tier
- `uhc` - uhc tier
- `smp` - smp tier
- 'nethop' - NetheriteOP tier
- `overall` - Overall rank
- `region` - Region
- `points` - Overall points

## Compatibility
✅ = Compatible

🔴 = Not compatible

🟠 = Unknown


| Server software                                           | Version | Supported |
|-----------------------------------------------------------|---------|-----------|
| [Papermc](https://github.com/PaperMC/Paper)               | 1.16-   | 🔴        |
|                                                           | 1.16+   | ✅         |
|                                                           | 1.17+   | ✅         |
|                                                           | 1.19+   | ✅         |
|                                                           | 1.20+   | ✅         |
|                                                           | 1.21+   | ✅         |
| [Pufferfish](https://github.com/pufferfish-gg/Pufferfish) | Any     | 🟠        |
| Proxies                                                   | Any     | 🔴        |
| Anything else?                                            | Any     | 🟠        |

[//]: # (| Server proxies                                       | Version | Supported |)

[//]: # (|------------------------------------------------------|---------|-----------|)

[//]: # (| [Velocity]&#40;https://github.com/PaperMC/Velocity&#41;      | Any     | 🔴        |)

[//]: # (| [Waterfall]&#40;https://github.com/PaperMC/Waterfall&#41;    | Any     | 🔴        |)

[//]: # (| [Bungeecord]&#40;https://github.com/SpigotMC/BungeeCord&#41; | Any     | 🔴        |)
