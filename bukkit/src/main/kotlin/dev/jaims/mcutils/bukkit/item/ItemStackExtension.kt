package dev.jaims.mcutils.bukkit.item

import dev.jaims.mcutils.bukkit.func.colorize
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
 * create an [ItemStack] from a [material] with [features]
 */
inline fun createItem(material: Material, features: ItemStack.() -> Unit): ItemStack {
    return ItemStack(material).apply(features)
}

/**
 * create an [ItemStack] from a copy of another [itemStack] with [features]
 */
inline fun createItem(itemStack: ItemStack, features: ItemStack.() -> Unit): ItemStack {
    return ItemStack(itemStack).apply(features)
}

/**
 * Modify the item meta of a [ItemStack]
 */
inline fun ItemStack.meta(meta: ItemMeta.() -> Unit) {
    itemMeta = itemMeta?.apply(meta)
}

/**
 * The name for an item.
 */
var ItemMeta.name: String
    get() = displayName.colorize()
    set(value) = setDisplayName(value.colorize())

/**
 * If the item should have a glow or not
 * Adds or removes the [ItemFlag.HIDE_ENCHANTS] as well as [Enchantment.RESPIRATION]
 */
var ItemMeta.glow: Boolean
    get() = hasEnchant(Enchantment.RESPIRATION) && hasItemFlag(ItemFlag.HIDE_ENCHANTS)
    set(value) {
        if (value) {
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            addEnchant(Enchantment.RESPIRATION, 1, false)
        } else {
            removeItemFlags(ItemFlag.HIDE_ENCHANTS)
            removeEnchant(Enchantment.RESPIRATION)
        }
    }

/**
 * Should the item be unbreakable or not
 * Adds or removes [ItemFlag.HIDE_UNBREAKABLE] and uses [ItemMeta.setUnbreakable]
 */
var ItemMeta.unbreakable: Boolean
    get() = hasItemFlag(ItemFlag.HIDE_UNBREAKABLE) && isUnbreakable
    set(value) {
        if (value) {
            isUnbreakable = true
            addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        } else {
            isUnbreakable = false
            removeItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }
    }