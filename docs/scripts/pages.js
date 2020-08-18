var pages = [{'name': 'colorize', 'index': '0', 'disabled': true, 'searchKey':'colorize' },
{'name': 'fun String.colorize(): String', 'level': 1, 'index': '0.0', 'description':'dev.jaims.mcutils.bungee.colorize', 'location':'project/dev.jaims.mcutils.bungee/colorize.html', 'searchKey':'colorize'},
{'name': 'fun String.colorize(player: Player?): String', 'level': 1, 'index': '0.1', 'description':'dev.jaims.mcutils.bukkit.colorize', 'location':'project/dev.jaims.mcutils.bukkit/colorize.html', 'searchKey':'colorize'},
{'name': 'fun sync(plugin: Plugin, delayTicks: Long, repeatingTicks: Long, f: () -> Unit)', 'index': '1', 'description':'dev.jaims.mcutils.bukkit.sync', 'location':'project/dev.jaims.mcutils.bukkit/sync.html', 'searchKey':'sync'},
{'name': 'log', 'index': '2', 'disabled': true, 'searchKey':'log' },
{'name': 'fun Plugin.log(message: Any?, severity: Severity)', 'level': 1, 'index': '2.0', 'description':'dev.jaims.mcutils.bungee.log', 'location':'project/dev.jaims.mcutils.bungee/log.html', 'searchKey':'log'},
{'name': 'fun Plugin.log(message: Any?, severity: Severity)', 'level': 1, 'index': '2.1', 'description':'dev.jaims.mcutils.bukkit.log', 'location':'project/dev.jaims.mcutils.bukkit/log.html', 'searchKey':'log'},
{'name': 'fun Damageable.heal()', 'index': '3', 'description':'dev.jaims.mcutils.bukkit.heal', 'location':'project/dev.jaims.mcutils.bukkit/heal.html', 'searchKey':'heal'},
{'name': 'fun async(plugin: Plugin, delayTicks: Long, repeatingTicks: Long, f: () -> Unit)', 'index': '4', 'description':'dev.jaims.mcutils.bukkit.async', 'location':'project/dev.jaims.mcutils.bukkit/async.html', 'searchKey':'async'},
{'name': 'fun Player.inRadiusOfLocation(location: Location, radius: Int): Boolean', 'index': '5', 'description':'dev.jaims.mcutils.bukkit.inRadiusOfLocation', 'location':'project/dev.jaims.mcutils.bukkit/in-radius-of-location.html', 'searchKey':'inRadiusOfLocation'},
{'name': 'fun Damageable.kill()', 'index': '6', 'description':'dev.jaims.mcutils.bukkit.kill', 'location':'project/dev.jaims.mcutils.bukkit/kill.html', 'searchKey':'kill'},
{'name': 'fun UUID.getName(): String?', 'index': '7', 'description':'dev.jaims.mcutils.common.getName', 'location':'project/dev.jaims.mcutils.common/get-name.html', 'searchKey':'getName'},
{'name': 'fun Player.feed()', 'index': '8', 'description':'dev.jaims.mcutils.bukkit.feed', 'location':'project/dev.jaims.mcutils.bukkit/feed.html', 'searchKey':'feed'},
{'name': 'fun String.getInputType(): InputType', 'index': '9', 'description':'dev.jaims.mcutils.common.getInputType', 'location':'project/dev.jaims.mcutils.common/get-input-type.html', 'searchKey':'getInputType'},
{'name': 'fun Int.toTimeFormatted(): Map<Times, Int>', 'index': '10', 'description':'dev.jaims.mcutils.common.toTimeFormatted', 'location':'project/dev.jaims.mcutils.common/to-time-formatted.html', 'searchKey':'toTimeFormatted'},
{'name': 'fun Int.toRomanNumeral(): String', 'index': '11', 'description':'dev.jaims.mcutils.common.toRomanNumeral', 'location':'project/dev.jaims.mcutils.common/to-roman-numeral.html', 'searchKey':'toRomanNumeral'},
{'name': 'fun Date.getSecondsDifference(date: Date): Int', 'index': '12', 'description':'dev.jaims.mcutils.common.getSecondsDifference', 'location':'project/dev.jaims.mcutils.common/get-seconds-difference.html', 'searchKey':'getSecondsDifference'},
{'name': 'fun String.getUUID(): UUID?', 'index': '13', 'description':'dev.jaims.mcutils.common.getUUID', 'location':'project/dev.jaims.mcutils.common/get-u-u-i-d.html', 'searchKey':'getUUID'},
{'name': 'enum InputType : Enum', 'index': '14', 'description':'dev.jaims.mcutils.common.InputType', 'location':'project/dev.jaims.mcutils.common/-input-type/index.html', 'searchKey':'InputType'},
{'name': 'class ItemBuilder(material: Material,amount: Int,damage: Int,name: String?,lore: MutableList<String>,enchantments: MutableMap<Enchantment, Int>,glow: Boolean,unbreakable: Boolean,itemflags: MutableList<ItemFlag>) : Supplier', 'index': '15', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/index.html', 'searchKey':'ItemBuilder'},
{'name': 'enum Times : Enum', 'index': '16', 'description':'dev.jaims.mcutils.common.Times', 'location':'project/dev.jaims.mcutils.common/-times/index.html', 'searchKey':'Times'},
{'name': 'fun setDamage(newdamage: Int): ItemBuilder', 'index': '17', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.setDamage', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/set-damage.html', 'searchKey':'setDamage'},
{'name': 'fun setName(newname: String): ItemBuilder', 'index': '18', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.setName', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/set-name.html', 'searchKey':'setName'},
{'name': 'fun addItemFlag(newitemflag: ItemFlag): ItemBuilder', 'index': '19', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.addItemFlag', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/add-item-flag.html', 'searchKey':'addItemFlag'},
{'name': 'fun addEnchantments(newenchantments: Map<Enchantment, Int>): ItemBuilder', 'index': '20', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.addEnchantments', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/add-enchantments.html', 'searchKey':'addEnchantments'},
{'name': 'SHORTUUID()', 'index': '21', 'description':'dev.jaims.mcutils.common.InputType.SHORTUUID', 'location':'project/dev.jaims.mcutils.common/-input-type/-s-h-o-r-t-u-u-i-d/index.html', 'searchKey':'SHORTUUID'},
{'name': 'open override fun toString(): String', 'index': '22', 'description':'dev.jaims.mcutils.common.Times.toString', 'location':'project/dev.jaims.mcutils.common/-times/to-string.html', 'searchKey':'toString'},
{'name': 'YEARS("years")', 'index': '23', 'description':'dev.jaims.mcutils.common.Times.YEARS', 'location':'project/dev.jaims.mcutils.common/-times/-y-e-a-r-s/index.html', 'searchKey':'YEARS'},
{'name': 'UUID()', 'index': '24', 'description':'dev.jaims.mcutils.common.InputType.UUID', 'location':'project/dev.jaims.mcutils.common/-input-type/-u-u-i-d/index.html', 'searchKey':'UUID'},
{'name': 'fun setAmount(newamt: Int): ItemBuilder', 'index': '25', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.setAmount', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/set-amount.html', 'searchKey':'setAmount'},
{'name': 'fun <init>(material: Material, amount: Int, damage: Int, name: String?, lore: MutableList<String>, enchantments: MutableMap<Enchantment, Int>, glow: Boolean, unbreakable: Boolean, itemflags: MutableList<ItemFlag>)', 'index': '26', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.<init>', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/-init-.html', 'searchKey':'<init>'},
{'name': 'open override fun get(): ItemStack', 'index': '27', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.get', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/get.html', 'searchKey':'get'},
{'name': 'MONTHS("months")', 'index': '28', 'description':'dev.jaims.mcutils.common.Times.MONTHS', 'location':'project/dev.jaims.mcutils.common/-times/-m-o-n-t-h-s/index.html', 'searchKey':'MONTHS'},
{'name': 'DAYS("days")', 'index': '29', 'description':'dev.jaims.mcutils.common.Times.DAYS', 'location':'project/dev.jaims.mcutils.common/-times/-d-a-y-s/index.html', 'searchKey':'DAYS'},
{'name': 'fun setGlow(newglow: Boolean): ItemBuilder', 'index': '30', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.setGlow', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/set-glow.html', 'searchKey':'setGlow'},
{'name': 'fun addEnchantment(newenchantment: Enchantment, level: Int): ItemBuilder', 'index': '31', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.addEnchantment', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/add-enchantment.html', 'searchKey':'addEnchantment'},
{'name': 'fun setUnbreakable(newunbreakable: Boolean): ItemBuilder', 'index': '32', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.setUnbreakable', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/set-unbreakable.html', 'searchKey':'setUnbreakable'},
{'name': 'fun addItemFlags(newitemflags: List<ItemFlag>): ItemBuilder', 'index': '33', 'description':'dev.jaims.mcutils.bukkit.ItemBuilder.addItemFlags', 'location':'project/dev.jaims.mcutils.bukkit/-item-builder/add-item-flags.html', 'searchKey':'addItemFlags'},
{'name': 'SECONDS("seconds")', 'index': '34', 'description':'dev.jaims.mcutils.common.Times.SECONDS', 'location':'project/dev.jaims.mcutils.common/-times/-s-e-c-o-n-d-s/index.html', 'searchKey':'SECONDS'},
{'name': 'HOURS("hours")', 'index': '35', 'description':'dev.jaims.mcutils.common.Times.HOURS', 'location':'project/dev.jaims.mcutils.common/-times/-h-o-u-r-s/index.html', 'searchKey':'HOURS'},
{'name': 'MINUTES("minutes")', 'index': '36', 'description':'dev.jaims.mcutils.common.Times.MINUTES', 'location':'project/dev.jaims.mcutils.common/-times/-m-i-n-u-t-e-s/index.html', 'searchKey':'MINUTES'},
{'name': 'WEEKS("weeks")', 'index': '37', 'description':'dev.jaims.mcutils.common.Times.WEEKS', 'location':'project/dev.jaims.mcutils.common/-times/-w-e-e-k-s/index.html', 'searchKey':'WEEKS'},
{'name': 'NAME()', 'index': '38', 'description':'dev.jaims.mcutils.common.InputType.NAME', 'location':'project/dev.jaims.mcutils.common/-input-type/-n-a-m-e/index.html', 'searchKey':'NAME'}]
