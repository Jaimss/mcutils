package dev.jaims.mcutils.bukkit.item

import org.bukkit.Material
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
inline fun ItemStack.modifyMeta(meta: ItemMeta.() -> Unit) {
    itemMeta.apply(meta)
}

/**
 * The string lore for an Item Separate lines with `\n` Not colorized by default.
 */
var ItemMeta.loreString: String
    get() = lore?.joinToString("\n") ?: ""
    set(value) {
        lore?.addAll(value.split("\n"))
    }


/**
 * The name for an item. Will not be colorized automatically
 */
var ItemMeta.name: String
    get() = displayName
    set(value) = setDisplayName(value)

