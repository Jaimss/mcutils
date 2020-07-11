package dev.jaims.utils

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import java.util.function.Supplier

/**
 * @param material - The only required parameter. This will be the items material
 * @param amount - the amount of the item
 * @param damage - the damage on the item
 * @param name - the name of the item
 * @param lore - the lore of the item
 * @param enchantments - the enchantments on the item
 * @param glow - should the item have a glow or not
 * @param unbreakable - should the item be breakable
 * @param itemflags - the item flags on the item
 */
@Suppress("unused")
class ItemBuilder(
    private var material: Material,
    private var amount: Int = 1,
    private var damage: Int = 0,
    private var name: String? = null,
    private var lore: MutableList<String> = mutableListOf(),
    private var enchantments: MutableMap<Enchantment, Int> = mutableMapOf(),
    private var glow: Boolean = false,
    private var unbreakable: Boolean = false,
    private var itemflags: MutableList<ItemFlag> = mutableListOf()
) : Supplier<ItemStack> {

    /**
     * @return the [ItemStack] with your specified settings and information
     */
    override fun get(): ItemStack {
        val item = ItemStack(material, amount)
        val meta = item.itemMeta ?: return item

        if (meta is Damageable) meta.damage = damage
        if (name != null) meta.setDisplayName(name)
        for (e in enchantments) meta.addEnchant(e.key, e.value, true)
        // need to find a better way to do this so it doesn't affect your enchantments
        if (glow) {
            meta.addEnchant(Enchantment.OXYGEN, 1, true)
            this.itemflags.add(ItemFlag.HIDE_ENCHANTS)
        }
        if (unbreakable) meta.isUnbreakable = true
        for (f in itemflags) meta.addItemFlags(f)

        meta.lore = lore
        item.itemMeta = meta
        return item
    }

    /**
     * Set [amount] to [newamt] for the itemstack.
     * @return an ItemBuilder
     */
    fun setAmount(newamt: Int) = apply { amount = newamt }

    /**
     * Set [damage] to [newdamage] for the itemstack.
     * @return an ItemBuilder
     */
    fun setDamage(newdamage: Int) = apply { damage = newdamage }

    /**
     * Set [name] to [newname] for the itemstack
     * @return an ItemBuilder
     */
    fun setName(newname: String) = apply { name = newname }

    /**
     * Add all of [newlores] to the current [lore]
     * @return an ItemBuilder
     */
    fun addLore(newlores: List<String>) = apply { for (l in newlores) lore.add(l) }

    /**
     * Add a singular [newlore] to [lore]
     * @return an ItemBuilder
     */
    fun addLore(newlore: String) = apply { lore.add(newlore) }

    /**
     * Add a map of [newenchantments]s to the current [enchantments]
     * @return an ItemBuilder
     */
    fun addEnchantments(newenchantments: Map<Enchantment, Int>) =
        apply { for (e in newenchantments) enchantments.putIfAbsent(e.key, e.value) }

    /**
     * Add a single [newenchantment] to the current [enchantments]
     * Optionally set a level for the enchantment!
     * @return an ItemBuilder
     */
    fun addEnchantment(newenchantment: Enchantment, level: Int = 1) =
        apply { enchantments.putIfAbsent(newenchantment, level) }

    /**
     * Set the item to glow. True will make it glow, false will make it now glow.
     * @return an ItemBuilder
     */
    fun setGlow(newglow: Boolean) = apply { glow = newglow }

    /**
     * Set if the item should be unbreakable or not
     * @return an ItemBuilder
     */
    fun setUnbreakable(newunbreakable: Boolean) = apply { unbreakable = newunbreakable }

    /**
     * Add a list of [newitemflags] to the current [itemflags]
     * @return an ItemBuilder
     */
    fun addItemFlags(newitemflags: List<ItemFlag>) = apply { for (f in newitemflags) itemflags.add(f) }

    /**
     * Add a singular [newitemflag] to the current [itemflags]
     * @return an ItemBuilder
     */
    fun addItemFlag(newitemflag: ItemFlag) = apply { itemflags.add(newitemflag) }

}