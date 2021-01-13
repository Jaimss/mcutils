var pages = [{'name': 'log', 'index': '0', 'disabled': true, 'searchKey': 'log'},
    {
        'name': 'fun Plugin.log(message: Any?, severity: Severity)',
        'level': 1,
        'index': '0.0',
        'description': 'dev.jaims.mcutils.bungee.log',
        'location': 'project/dev.jaims.mcutils.bungee/log.html',
        'searchKey': 'log'
    },
    {
        'name': 'fun Plugin.log(message: Any?, severity: Severity)',
        'level': 1,
        'index': '0.1',
        'description': 'dev.jaims.mcutils.bukkit.log',
        'location': 'project/dev.jaims.mcutils.bukkit/log.html',
        'searchKey': 'log'
    },
    {
        'name': 'fun Entity.inRadiusOfLocation(location: Location, radius: Int): Boolean',
        'index': '1',
        'description': 'dev.jaims.mcutils.bukkit.inRadiusOfLocation',
        'location': 'project/dev.jaims.mcutils.bukkit/in-radius-of-location.html',
        'searchKey': 'inRadiusOfLocation'
    },
    {
        'name': 'fun Damageable.kill(): Damageable',
        'index': '2',
        'description': 'dev.jaims.mcutils.bukkit.kill',
        'location': 'project/dev.jaims.mcutils.bukkit/kill.html',
        'searchKey': 'kill'
    },
    {
        'name': 'fun Damageable.heal(newHealth: Double): Damageable',
        'index': '3',
        'description': 'dev.jaims.mcutils.bukkit.heal',
        'location': 'project/dev.jaims.mcutils.bukkit/heal.html',
        'searchKey': 'heal'
    },
    {
        'name': 'fun Player.feed(newFood: Int): Player',
        'index': '4',
        'description': 'dev.jaims.mcutils.bukkit.feed',
        'location': 'project/dev.jaims.mcutils.bukkit/feed.html',
        'searchKey': 'feed'
    },
    {
        'name': 'fun async(plugin: Plugin, delayTicks: Long, repeatingTicks: Long, block: () -> Unit): BukkitTask',
        'index': '5',
        'description': 'dev.jaims.mcutils.bukkit.async',
        'location': 'project/dev.jaims.mcutils.bukkit/async.html',
        'searchKey': 'async'
    },
    {
        'name': 'fun sync(plugin: Plugin, delayTicks: Long, repeatingTicks: Long, block: () -> Unit): BukkitTask',
        'index': '6',
        'description': 'dev.jaims.mcutils.bukkit.sync',
        'location': 'project/dev.jaims.mcutils.bukkit/sync.html',
        'searchKey': 'sync'
    },
    {
        'name': 'fun Command.registerPluginYml(plugin: Plugin): Command',
        'index': '7',
        'description': 'dev.jaims.mcutils.bukkit.command.registerPluginYml',
        'location': 'project/dev.jaims.mcutils.bukkit.command/register-plugin-yml.html',
        'searchKey': 'registerPluginYml'
    },
    {
        'name': 'inline fun <T : CommandSender> Plugin.handleCommand(commandName: String, description: String, usage: String, aliases: List<String>, permission: String?, crossinline noPermissionmessage: (CommandSender) -> Unit, crossinline senderInvalidType: (CommandSender) -> Unit, crossinline body: (T, Array<Out String>) -> Unit)',
        'index': '8',
        'description': 'dev.jaims.mcutils.bukkit.command.handleCommand',
        'location': 'project/dev.jaims.mcutils.bukkit.command/handle-command.html',
        'searchKey': 'handleCommand'
    },
    {
        'name': 'fun UUID.getName(): String?',
        'index': '9',
        'description': 'dev.jaims.mcutils.common.getName',
        'location': 'project/dev.jaims.mcutils.common/get-name.html',
        'searchKey': 'getName'
    },
    {
        'name': 'class ItemBuilder(material: Material,amount: Int,damage: Int,name: String?,lore: MutableList<String>,enchantments: MutableMap<Enchantment, Int>,glow: Boolean,unbreakable: Boolean,itemflags: MutableList<ItemFlag>) : Supplier',
        'index': '10',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/index.html',
        'searchKey': 'ItemBuilder'
    },
    {
        'name': 'interface ListenerExt<T : Event>  : Listener',
        'index': '11',
        'description': 'dev.jaims.mcutils.bukkit.event.ListenerExt',
        'location': 'project/dev.jaims.mcutils.bukkit.event/-listener-ext/index.html',
        'searchKey': 'ListenerExt'
    },
    {
        'name': 'inline fun <T : Event> Plugin.waitForEvent(timeoutTicks: Long, ignoreCancelled: Boolean, priority: EventPriority, crossinline action: (T) -> Unit, crossinline predicate: (T) -> Boolean, crossinline timeoutAction: () -> Unit)',
        'index': '12',
        'description': 'dev.jaims.mcutils.bukkit.event.waitForEvent',
        'location': 'project/dev.jaims.mcutils.bukkit.event/wait-for-event.html',
        'searchKey': 'waitForEvent'
    },
    {
        'name': 'abstract fun onEvent(event: T)',
        'index': '13',
        'description': 'dev.jaims.mcutils.bukkit.event.ListenerExt.onEvent',
        'location': 'project/dev.jaims.mcutils.bukkit.event/-listener-ext/on-event.html',
        'searchKey': 'onEvent'
    },
    {
        'name': 'fun Int.toTimeFormatted(): Map<Times, Int>',
        'index': '14',
        'description': 'dev.jaims.mcutils.common.toTimeFormatted',
        'location': 'project/dev.jaims.mcutils.common/to-time-formatted.html',
        'searchKey': 'toTimeFormatted'
    },
    {
        'name': 'fun String.getUUID(): UUID?',
        'index': '15',
        'description': 'dev.jaims.mcutils.common.getUUID',
        'location': 'project/dev.jaims.mcutils.common/get-u-u-i-d.html',
        'searchKey': 'getUUID'
    },
    {
        'name': 'fun Int.toRomanNumeral(): String',
        'index': '16',
        'description': 'dev.jaims.mcutils.common.toRomanNumeral',
        'location': 'project/dev.jaims.mcutils.common/to-roman-numeral.html',
        'searchKey': 'toRomanNumeral'
    },
    {
        'name': 'fun setDamage(newdamage: Int): ItemBuilder',
        'index': '17',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.setDamage',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/set-damage.html',
        'searchKey': 'setDamage'
    },
    {
        'name': 'inline fun <T : Event> Plugin.listenForEvent(ignoreCancelled: Boolean, priority: EventPriority, crossinline predicate: (T) -> Boolean, crossinline action: (T) -> Unit)',
        'index': '18',
        'description': 'dev.jaims.mcutils.bukkit.event.listenForEvent',
        'location': 'project/dev.jaims.mcutils.bukkit.event/listen-for-event.html',
        'searchKey': 'listenForEvent'
    },
    {
        'name': 'inline fun ItemStack.meta(meta: ItemMeta.() -> Unit)',
        'index': '19',
        'description': 'dev.jaims.mcutils.bukkit.item.meta',
        'location': 'project/dev.jaims.mcutils.bukkit.item/meta.html',
        'searchKey': 'meta'
    },
    {
        'name': 'fun <init>(material: Material, amount: Int, damage: Int, name: String?, lore: MutableList<String>, enchantments: MutableMap<Enchantment, Int>, glow: Boolean, unbreakable: Boolean, itemflags: MutableList<ItemFlag>)',
        'index': '20',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.<init>',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/-init-.html',
        'searchKey': '<init>'
    },
    {
        'name': 'fun setGlow(newglow: Boolean): ItemBuilder',
        'index': '21',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.setGlow',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/set-glow.html',
        'searchKey': 'setGlow'
    },
    {
        'name': 'fun addEnchantments(newenchantments: Map<Enchantment, Int>): ItemBuilder',
        'index': '22',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.addEnchantments',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/add-enchantments.html',
        'searchKey': 'addEnchantments'
    },
    {
        'name': 'enum InputType : Enum',
        'index': '23',
        'description': 'dev.jaims.mcutils.common.InputType',
        'location': 'project/dev.jaims.mcutils.common/-input-type/index.html',
        'searchKey': 'InputType'
    },
    {
        'name': 'open override fun get(): ItemStack',
        'index': '24',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.get',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/get.html',
        'searchKey': 'get'
    },
    {
        'name': 'fun String.getInputType(): InputType',
        'index': '25',
        'description': 'dev.jaims.mcutils.common.getInputType',
        'location': 'project/dev.jaims.mcutils.common/get-input-type.html',
        'searchKey': 'getInputType'
    },
    {
        'name': 'fun addItemFlag(newitemflag: ItemFlag): ItemBuilder',
        'index': '26',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.addItemFlag',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/add-item-flag.html',
        'searchKey': 'addItemFlag'
    },
    {
        'name': 'fun Date.getSecondsDifference(date: Date): Int',
        'index': '27',
        'description': 'dev.jaims.mcutils.common.getSecondsDifference',
        'location': 'project/dev.jaims.mcutils.common/get-seconds-difference.html',
        'searchKey': 'getSecondsDifference'
    },
    {
        'name': 'fun setName(newname: String): ItemBuilder',
        'index': '28',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.setName',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/set-name.html',
        'searchKey': 'setName'
    },
    {
        'name': 'fun setAmount(newamt: Int): ItemBuilder',
        'index': '29',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.setAmount',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/set-amount.html',
        'searchKey': 'setAmount'
    },
    {
        'name': 'NAME()',
        'index': '30',
        'description': 'dev.jaims.mcutils.common.InputType.NAME',
        'location': 'project/dev.jaims.mcutils.common/-input-type/-n-a-m-e/index.html',
        'searchKey': 'NAME'
    },
    {
        'name': 'UUID()',
        'index': '31',
        'description': 'dev.jaims.mcutils.common.InputType.UUID',
        'location': 'project/dev.jaims.mcutils.common/-input-type/-u-u-i-d/index.html',
        'searchKey': 'UUID'
    },
    {
        'name': 'enum Times : Enum',
        'index': '32',
        'description': 'dev.jaims.mcutils.common.Times',
        'location': 'project/dev.jaims.mcutils.common/-times/index.html',
        'searchKey': 'Times'
    },
    {
        'name': 'SHORTUUID()',
        'index': '33',
        'description': 'dev.jaims.mcutils.common.InputType.SHORTUUID',
        'location': 'project/dev.jaims.mcutils.common/-input-type/-s-h-o-r-t-u-u-i-d/index.html',
        'searchKey': 'SHORTUUID'
    },
    {
        'name': 'fun addItemFlags(newitemflags: List<ItemFlag>): ItemBuilder',
        'index': '34',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.addItemFlags',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/add-item-flags.html',
        'searchKey': 'addItemFlags'
    },
    {
        'name': 'fun setUnbreakable(newunbreakable: Boolean): ItemBuilder',
        'index': '35',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.setUnbreakable',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/set-unbreakable.html',
        'searchKey': 'setUnbreakable'
    },
    {
        'name': 'fun addEnchantment(newenchantment: Enchantment, level: Int): ItemBuilder',
        'index': '36',
        'description': 'dev.jaims.mcutils.bukkit.item.ItemBuilder.addEnchantment',
        'location': 'project/dev.jaims.mcutils.bukkit.item/-item-builder/add-enchantment.html',
        'searchKey': 'addEnchantment'
    },
    {
        'name': 'DAYS("days")',
        'index': '37',
        'description': 'dev.jaims.mcutils.common.Times.DAYS',
        'location': 'project/dev.jaims.mcutils.common/-times/-d-a-y-s/index.html',
        'searchKey': 'DAYS'
    },
    {
        'name': 'YEARS("years")',
        'index': '38',
        'description': 'dev.jaims.mcutils.common.Times.YEARS',
        'location': 'project/dev.jaims.mcutils.common/-times/-y-e-a-r-s/index.html',
        'searchKey': 'YEARS'
    },
    {
        'name': 'open override fun toString(): String',
        'index': '39',
        'description': 'dev.jaims.mcutils.common.Times.toString',
        'location': 'project/dev.jaims.mcutils.common/-times/to-string.html',
        'searchKey': 'toString'
    },
    {
        'name': 'HOURS("hours")',
        'index': '40',
        'description': 'dev.jaims.mcutils.common.Times.HOURS',
        'location': 'project/dev.jaims.mcutils.common/-times/-h-o-u-r-s/index.html',
        'searchKey': 'HOURS'
    },
    {
        'name': 'MINUTES("minutes")',
        'index': '41',
        'description': 'dev.jaims.mcutils.common.Times.MINUTES',
        'location': 'project/dev.jaims.mcutils.common/-times/-m-i-n-u-t-e-s/index.html',
        'searchKey': 'MINUTES'
    },
    {
        'name': 'WEEKS("weeks")',
        'index': '42',
        'description': 'dev.jaims.mcutils.common.Times.WEEKS',
        'location': 'project/dev.jaims.mcutils.common/-times/-w-e-e-k-s/index.html',
        'searchKey': 'WEEKS'
    },
    {
        'name': 'MONTHS("months")',
        'index': '43',
        'description': 'dev.jaims.mcutils.common.Times.MONTHS',
        'location': 'project/dev.jaims.mcutils.common/-times/-m-o-n-t-h-s/index.html',
        'searchKey': 'MONTHS'
    },
    {
        'name': 'SECONDS("seconds")',
        'index': '44',
        'description': 'dev.jaims.mcutils.common.Times.SECONDS',
        'location': 'project/dev.jaims.mcutils.common/-times/-s-e-c-o-n-d-s/index.html',
        'searchKey': 'SECONDS'
    }]
