---
title: ItemBuilder - mcutils
---

[mcutils](../../index.html) / [dev.jaims.mcutils](../index.html) / [ItemBuilder](./index.html)

# ItemBuilder

`class ItemBuilder : Supplier<ItemStack>`

### Parameters

`material` - The only required parameter. This will be the items material

`amount` - the amount of the item

`damage` - the damage on the item

`name` - the name of the item

`lore` - the lore of the item

`enchantments` - the enchantments on the item

`glow` - should the item have a glow or not

`unbreakable` - should the item be breakable

`itemflags` - the item flags on the item

### Constructors

| [&lt;init&gt;](-init-.html) | `ItemBuilder(material: Material, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, damage: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, lore: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = mutableListOf(), enchantments: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<Enchantment, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`> = mutableMapOf(), glow: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, unbreakable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, itemflags: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<ItemFlag> = mutableListOf())` |

### Functions

| [addEnchantment](add-enchantment.html) | Add a single enchantment to an item`fun addEnchantment(newenchantment: Enchantment, level: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1): `[`ItemBuilder`](./index.html) |
| [addEnchantments](add-enchantments.html) | Add a map of enchantments to the item`fun addEnchantments(newenchantments: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<Enchantment, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`ItemBuilder`](./index.html) |
| [addItemFlag](add-item-flag.html) | Add a single item flag to an item`fun addItemFlag(newitemflag: ItemFlag): `[`ItemBuilder`](./index.html) |
| [addItemFlags](add-item-flags.html) | Add a list of item flags to an item`fun addItemFlags(newitemflags: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<ItemFlag>): `[`ItemBuilder`](./index.html) |
| [addLore](add-lore.html) | Add a list of lores to an item`fun addLore(newlores: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`ItemBuilder`](./index.html)<br>Add a single line lore to the item`fun addLore(newlore: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder`](./index.html) |
| [get](get.html) | `fun get(): ItemStack` |
| [setAmount](set-amount.html) | Set a new amount for the item`fun setAmount(newamt: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder`](./index.html) |
| [setDamage](set-damage.html) | Set the damage for the item`fun setDamage(newdamage: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ItemBuilder`](./index.html) |
| [setGlow](set-glow.html) | Set the item to glow or not`fun setGlow(newglow: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`ItemBuilder`](./index.html) |
| [setName](set-name.html) | Set the name for the item`fun setName(newname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ItemBuilder`](./index.html) |
| [setUnbreakable](set-unbreakable.html) | Set if the item should be unbreakable or not`fun setUnbreakable(newunbreakable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`ItemBuilder`](./index.html) |

