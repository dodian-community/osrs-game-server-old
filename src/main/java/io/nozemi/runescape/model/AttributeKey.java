package io.nozemi.runescape.model;


/**
 * Created by Bart on 8/13/2015.
 */
public enum AttributeKey {
	
	/**
	 * Key indicating if this player is having debugging enabled.
	 */
	DEBUG,
	
	/**
	 * Key indicating if this player is trying to log out.
	 */
	LOGOUT,
	
	/**
	 * Key used to indicate we're hopping instead of plain logging out. Object contained is a WorldHop packet.
	 */
	WORLDHOP_LOGOUTMSG,
	
	// A weakreference to an entity
	TARGET,
	CLANWARS_TARGET,
	
	// ID of the last region we were in
	LAST_REGION,
	
	/**
	 * 8x8 areas
	 */
	LAST_CHUNK,
	
	// If for example - item on item, this is the slot of item 1
	ITEM_SLOT,
	
	// If we're doing item on item, this is the slot of the 2nd item
	ALT_ITEM_SLOT,
	
	// Item instance
	FROM_ITEM,
	
	// Item instance
	TO_ITEM,
	
	BUTTON_SLOT,
	
	CHILD_ID,
	
	/**
	 * Key used to indicate which action (1..10) was used when button pressing.
	 */
	BUTTON_ACTION,
	
	// Item ID of the Item we're interacting with
	ITEM_ID,
	
	// Item ID of the secondary item we're interacting with
	ALT_ITEM_ID,
	
	/*
	 * Key used to indicate that the vengeance spell is active
	 */
	VENGEANCE_ACTIVE,
	
	/*
	 *Key used to store PK points
	 */
	PK_POINTS,
	
	/**
	 * Key used to indicate which ground item we are trying to take.
	 */
	INTERACTED_GROUNDITEM,
	
	/**
	 * Key used to indicate which map object we are interacting with.
	 */
	INTERACTION_OBJECT,
	
	/**
	 * Key used to indicate which map object we interacted with, before it was overwritten by Jak's odd system.
	 */
	ORIGINAL_INTERACTION_OBJECT,
	
	/**
	 * Key used to indicate which npc we are interacting with.
	 */
	INTERACTION_NPC,
	
	/**
	 * Key used to indicate which option we're using on the object
	 */
	INTERACTION_OPTION,

	/**
	 * A key used to represent the make X quantity.
	 */
	MAKE_X_AMT,
    
	/**
	 * Key used to have a 0..100 value which holds the current prayer incremental status to have sub-tick increments.
	 */
	PRAYERINCREMENT,
	
	/**
	 * Tick/cycle number - prayer doesn't drain the 1st tick of being active. Allows flicking
	 */
	PRAYER_ON_TICK,
	
	/**
	 * The entity which last attacked us.
	 */
	LAST_DAMAGER,
	SKULL_ENTRIES_TRACKER,
	
	/**
	 * The last person we attacked. Required for the PvP world PJ mechanic.
	 * - NOTE: this different from the TARGET attribute, as TARGET is cancelled/removed in various situations or when you change targets.
	 */
	LAST_TARGET,
	
	/**
	 * Time (MS) when a player was last attacked. This is when an attack is initated (animation) NOT when damage apprers.
	 * Used in checking for in/out of combat.
	 */
	LAST_WAS_ATTACKED_TIME,
	
	/**
	 * The last time we attacked some other entity
	 */
	LAST_ATTACK_TIME,
	
	/**
	 * Key used to indicate which shop we currently are viewing.
	 */
	SHOP,
	
	/**
	 * Key used to keep track of how far in the gnome course we are.
	 */
	GNOME_COURSE_STATE("gnomecourse", AttribType.INTEGER),
	SEERS_ROOFTOP_COURSE_STATE("seerscourse", AttribType.INTEGER),
	BARBARIAN_COURSE_STATE("barbcourse", AttribType.INTEGER),
	WILDY_COURSE_STATE("wildycourse", AttribType.INTEGER),
	
	/**
	 * Key used to keep track of alchemy warning
	 */
	ALCHEMY_WARNING("alchemywarning", AttribType.INTEGER),
	
	/**
	 * Key used in callisto combat which keeps track of when to use the healing when he gets hit.
	 */
	CALLISTO_DMG_HEAL,
	
	/**
	 * Key used in the callisto combat script
	 */
	CALLISTO_ROAR,
	
	/**
	 * Key used in combat hit callback scripts to indicate how much damage the last hit dealt.
	 */
	LAST_HIT_DMG,
	
	/**
	 * The ID of our trading partner or the player we invited to trade with.
	 */
	TRADING_PARTNER,
	DUEL_PARTNER,
	REQUESTED_TRADE_PARTNER,
	REQUESTED_DUEL_PARTNER,
	
	/**
	 * The ID of the user we're inviting to a challenge.
	 */
	CLANWAR_PARTNER,
	
	/**
	 * ID of the user's channel we are in right now.
	 */
	CLAN_CHANNEL("clanchat", AttribType.INTEGER),

	/**
	 * A key used to cache the ID of the raid party the player is in.
	 */
	RAID_PARTY,
	
	/**
	 * Current offer of trading inventory. I don't feel like documenting, check references.
	 */
	TRADING_OFFER,
	DUEL_OFFER,
	// A container that doesn't need the loser to be online for access.
	DUEL_WINNINGS,
	DUEL_LOSS_CONTAINER,
	
	/**
	 * Key that indicates if the current trading screen has been accepted by this player (boolean).
	 */
	TRADE_ACCEPTED,
	DUEL_ACCEPTED,
	
	/**
	 * Key used to indicate that the second screen is currently open and the first has been agreed on.
	 */
	CLANWAR_SECOND_SCREEN,
	
	/**
	 * Key holding the last transmitted refresh container.
	 */
	LAST_TRADE_REFRESH,
	
	/**
	 * A tuple linking player db-ID : player instance
	 * By having the instance, we don't have to stress the engine by doing playerForId. However, if that
	 * instance is offline, we can fallback to playerById.
	 * The ID of a player that owns this very NPC spawn. Think of barrows brothers, or animated armours.
	 */
	OWNING_PLAYER,
	
	/**
	 * Tracks the instance which 'owns' an entity - such as the Kraken boss owns its minions.
	 */
	BOSS_OWNER,
	
	/**
	 * Key to check if already have a animated armour set spawned
	 */
	
	ARMOUR_SET,
	
	/**
	 * Key used in fishing to indicate which tiles an npc may use. Type: Array<Tile>.
	 */
	POSSIBLE_FISH_TILES,
	
	/**
	 * Keeps track of <Mapobj>Hunter traps</Mapobj> so that on logout we can turn the object into a ground item and unbind them from the player.
	 */
	BOXTRAPS_LIST,
	
	RING_OF_RECOIL_CHARGES("rol_charges", AttribType.INTEGER),
	
	SLAYER_TASK_SPREE("slayerspree", AttribType.INTEGER),
	
	WILDERNESS_SLAYER_TASK_ACTIVE("slayer;wilderness_task_active", AttribType.BOOLEAN),
	
	/**
	 * The entity which froze use.
	 */
	FROZEN_BY,
	
	// Which chest leads to the tombs
	FINAL_BARROWS_BRO_COFFINID("barrowsBroCoffinToChest", AttribType.INTEGER),
	
	// Current brother spawned
	barrowsBroSpawned,
	
	// If JSS is enabled
	JSS_USE,
	
	// If we should stop showing the wilderness warning
	WILDERNESS_WARNING,
	
	/**
	 * If we need to refresh the shop stock this cycle for this player.
	 */
	SHOP_DIRTY,
	/**
	 * Do not send any other player/npc information in GPI.
	 */
	NO_GPI,
	
	/**
	 * Key to handle the players energy %.
	 */
	RUN_ENERGY("runenergy", AttribType.DOUBLE),
	
	/**
	 * Key to handle stamina potions.
	 */
	STAMINA_POTION("staminapotion", AttribType.INTEGER),
	
	/**
	 * Key to handle killer
	 */
	KILLER,
	
	/**
	 * Key to handle quick prayer flag
	 */
	QUICK_PRAYERS_ACTIVE,
	
	/**
	 * Key to handle quick prayer configurations
	 */
	QUICK_PRAYER_CONFIGURATIONS,
	/**
	 * Last time (ms) an invalid PIN was entered. Stops allowing people to autotype ::pin 0001-9999 to bruteforce pins.
	 */
	INVALID_PIN_ENTER_TIME,
	
	/**
	 * Number of players killed in the process of murdering.
	 */
	KILLSTREAK("killstreak", AttribType.INTEGER),
	
	/**
	 * When we last used a quick setup. Anti-rag feature
	 */
	LAST_TIME_SPAWNSETUP_USED("lastSpawnSetupTime", AttribType.STRING),
	
	/**
	 * Shows right click opts for mod to quick-do actions like mute etc
	 */
	MODOPS,
	/**
	 * If the attack option is visible.
	 */
	ATTACK_OP,
	/**
	 * If the duel arena challenge option is visible.
	 */
	CHALLENGE_OP,
	/**
	 * If the Player is in the high risk area
	 */
	NON_PLUS1_AREA,
	/**
	 * Just to inform users.
	 */
	IN_ANTIRAG_ZONE,
	/**
	 * Very important for PvP death. Tracks most damage, used in giving loot and farming detection.
	 */
	MOST_DAM_TRACKER,
	/**
	 * Ores given to the nigga to escape jail
	 */
	JAIL_ORES_MINED("jailOresMined", AttribType.INTEGER),
	
	// If we are jailed.
	JAILED("jailed", AttribType.INTEGER),
	
	// Required total of ores to mine before you can escape jail. So you can specify per offense.
	JAIL_ORES_TO_ESCAPE("jail_ores_to_escape", AttribType.INTEGER),
	
	/**
	 * Used for sending the wild level info at correct coordinate
	 */
	INWILD,

	/**
	 * Direction we'll move next after current spear action ends.
	 */
	SPEAR_MOVES,
	
	/**
	 * Flag that combat should end after we use special attack. Unique to the Dragon spear special.
	 */
	ENDCB_POSTSPEC,
	
	/**
	 * TODO use config once identified
	 */
	TARGET_OBELISKS,
	
	/**
	 * If, when we are being force-moved, we ignore being frozen - unique to the dragon spear
	 */
	IGNORE_FREEZE_MOVE,
	/**
	 * If we are currently participating in a duel.
	 */
	IN_STAKE,
	/**
	 * If we are currently participating in a clan war.
	 */
	IN_CLAN_WAR,
	
	// Our saved duel settings config. Not stored as a varp.
	SAVED_DUEL_SETTINGS("saved_duel_settings", AttribType.INTEGER),
	
	// Our previous duel settings. Not stored as a varp.
	PREVIOUS_DUEL_SETTINGS("previous_duel_settings", AttribType.INTEGER),
	
	// How many stakes we've lost
	STAKES_LOST("stakes_lost", AttribType.INTEGER),
	
	// Won stake count.
	STAKES_WON("stakes_won", AttribType.INTEGER),
	
	/**
	 * Boolean key indicating if the account was freshly made (used for intoductory dialogue).
	 */
	NEW_ACCOUNT,
	
	/**
	 * Highest shutdown player ever achieved. Doesn't get replaced unless it's superceded.
	 */
	KILLSTREAK_RECORD("ksrec", AttribType.INTEGER),
	
	/**
	 * The highest shutdown this player has ever achieved. Does not get cleared upon death and is permanent until it's superceded.
	 */
	SHUTDOWN_RECORD("sdrec", AttribType.INTEGER),
	
	/**
	 * When you reset your K/D, its added to this var to track all kills forever.
	 */
	ALLTIME_KILLS("alltime_kills", AttribType.INTEGER),
	/**
	 * When you reset your K/D, its added to this var to track all deaths forever.
	 */
	ALLTIME_DEATHS("alltime_deaths", AttribType.INTEGER),
	
	// It can take from time to run somewhere on the eco server, so let's put them back where they were before getting jailed :)
	LOC_BEFORE_JAIL,
	
	/**
	 * Flag if a double death occured during a stake.
	 */
	STAKING_DOUBLE_DEATH,
	
	/**
	 * Flag if double death has been checked be the first person to die (down to PID)
	 */
	ARENA_DEATH_TICK,
	
	/**
	 * The type of duel to be had, e.g. whip/dds or tent/dds or normal.
	 */
	DUEL_EXTRA_TYPE_SELECTION,
	
	/**
	 * Current Pet enum type associated with this spawned pet.
	 */
	PET_TYPE,
	
	/**
	 * Player key used to link a pet to a player. If set, it will be an Npc that follows this player.
	 */
	ACTIVE_PET,
	
	/**
	 * The Item ID of our active pet, saved over logout, so we can respawn it on login.
	 */
	ACTIVE_PET_ITEM_ID("active_pet_item_id", AttribType.INTEGER),
	
	/**
	 * Key used to store how many iron ores before our ring melts.
	 */
	RING_OF_FORGING_CHARGES("ring_of_forging_charges", AttribType.INTEGER),
	
	/**
	 * Key used to store how far we are into the Mage Arena minigame.
	 */
	MAGE_ARENA_PHASE("mage_arena_phase", AttribType.INTEGER),
	
	/**
	 * Key used in scorpia's combat script to define whether the minions had been spawned.
	 */
	SCORPIA_GUARDIANS_SPAWNED,
	
	/**
	 * Key to handle stamina potions.
	 */
	ANTIFIRE_POTION("antifire_potion", AttribType.INTEGER),
	
	/**
	 * Keys used to store items given to the Cook during the Cooks Assistant quest.
	 */
	GIVEN_EGG,
	GIVEN_POT_OF_FLOUR,
	GIVEN_BUCKET_OF_MILK,
	
	/**
	 * Key used to determine if we have grain inside the hopper.
	 */
	GRAIN_IN_HOPPER,
	
	/**
	 * Key used to determine if we have grain inside the hopper.
	 */
	GRANDEXCHANGE_MODE,
	
	/**
	 * Key used to store the amount and type of pies Romily Weaklax requested.
	 */
	ROMILY_TYPE_OF_PIE("type_of_pie", AttribType.INTEGER),
	ROMILY_AMOUNT_OF_PIES("amount_of_pie", AttribType.INTEGER),
	
	TEMP_TWOFACTOR_KEY,
	
	// Lost void items count, so a player can re-claim it at a shop.
	PERDU_VARBIT1("lostproperty_voiditems", AttribType.INTEGER),
	PERDU_VARBIT2("perdu_varbit2", AttribType.INTEGER),
	PERDU_VARBIT3("perdu_varbit3", AttribType.INTEGER),
	PERDU_VARBIT4("perdu_varbit4", AttribType.INTEGER),
	
	// NPC killcounts shown on the slayer log of the Slayer gem.
	KC_CRAWL_HAND("npckc1", AttribType.INTEGER),
	KC_CAVE_BUG("npckc2", AttribType.INTEGER),
	KC_CAVE_CRAWLER("npckc3", AttribType.INTEGER),
	KC_BANSHEE("npckc4", AttribType.INTEGER),
	KC_CAVE_SLIME("npckc5", AttribType.INTEGER),
	KC_ROCKSLUG("npckc6", AttribType.INTEGER),
	KC_DESERT_LIZARD("npckc7", AttribType.INTEGER),
	KC_COCKATRICE("npckc8", AttribType.INTEGER),
	KC_PYREFRIEND("npckc9", AttribType.INTEGER),
	KC_MOGRE("npckc10", AttribType.INTEGER),
	KC_HARPIE_BUG("npckc11", AttribType.INTEGER),
	KC_WALL_BEAST("npckc12", AttribType.INTEGER),
	KC_KILLERWATT("npckc13", AttribType.INTEGER),
	KC_MOLANISK("npckc14", AttribType.INTEGER),
	KC_BASILISK("npckc15", AttribType.INTEGER),
	KC_SEASNAKE("npckc16", AttribType.INTEGER),
	KC_TERRORDOG("npckc17", AttribType.INTEGER),
	KC_FEVER_SPIDER("npckc18", AttribType.INTEGER),
	KC_INFERNAL_MAGE("npckc19", AttribType.INTEGER),
	KC_BRINERAT("npckc20", AttribType.INTEGER),
	KC_BLOODVELD("npckc21", AttribType.INTEGER),
	KC_JELLY("npckc22", AttribType.INTEGER),
	KC_TUROTH("npckc23", AttribType.INTEGER),
	KC_ZYGOMITE("npckc24", AttribType.INTEGER),
	KC_CAVEHORROR("npckc25", AttribType.INTEGER),
	KC_ABERRANT_SPECTRE("npckc26", AttribType.INTEGER),
	KC_SPIRITUAL_RANGER("npckc27", AttribType.INTEGER),
	KC_DUSTDEVIL("npckc_dustdevil", AttribType.INTEGER),
	KC_SPIRITUAL_WARRIOR("npckc28", AttribType.INTEGER),
	KC_KURASK("npckc29", AttribType.INTEGER),
	KC_SKELETAL_WYVERN("npckc30", AttribType.INTEGER),
	KC_GARGOYLE("npckc31", AttribType.INTEGER),
	KC_NECHRYAEL("npckc32", AttribType.INTEGER),
	KC_SPIRITUAL_MAGE("npckc33", AttribType.INTEGER),
	KC_ABYSSALDEMON("npckc34", AttribType.INTEGER),
	KC_CAVEKRAKEN("npckc35", AttribType.INTEGER),
	KC_DARKBEAST("npckc36", AttribType.INTEGER),
	KC_SMOKEDEVIL("npckc37", AttribType.INTEGER),
	
	BARROWS_CHESTS_OPENED("barrowsChests", AttribType.INTEGER),
	
	KC_ABYSSALSIRE("npc_boss_kc1", AttribType.INTEGER),
	KC_CALLISTO("npc_boss_kc2", AttribType.INTEGER),
	KC_CERBERUS("npc_boss_kc3", AttribType.INTEGER),
	KC_CHAOSELE("npc_boss_kc4", AttribType.INTEGER),
	KC_ZILYANA("npc_boss_kc5", AttribType.INTEGER),
	KC_CORPBEAST("npc_boss_kc6", AttribType.INTEGER),
	KC_CRAZY_ARCH("npc_boss_kc7", AttribType.INTEGER),
	KC_PRIME("npc_boss_kc8", AttribType.INTEGER),
	KC_REX("npc_boss_kc9", AttribType.INTEGER),
	KC_SUPREME("npc_boss_kc10", AttribType.INTEGER),
	KC_GRAARDOR("npc_boss_kc11", AttribType.INTEGER),
	KC_GIANTMOLE("npc_boss_kc12", AttribType.INTEGER),
	KC_KRIL_TSUT("npc_boss_kc13", AttribType.INTEGER),
	KC_KQ("npc_boss_kc14", AttribType.INTEGER),
	KC_KBD("npc_boss_kc15", AttribType.INTEGER),
	KC_KRAKEN("npc_boss_kc16", AttribType.INTEGER),
	KC_KREEARRA("npc_boss_kc17", AttribType.INTEGER),
	KC_PENANCEQUEEM("npc_boss_kc18", AttribType.INTEGER),
	KC_SCORPIA("npc_boss_kc19", AttribType.INTEGER),
	KC_THERMY("npc_boss_kc20", AttribType.INTEGER),
	KC_JAD("npc_boss_kc21", AttribType.INTEGER),
	KC_VENENATIS("npc_boss_kc22", AttribType.INTEGER),
	KC_VETION("npc_boss_kc23", AttribType.INTEGER),
	KC_ZULRAH("npc_boss_kc24", AttribType.INTEGER),
	KC_CHAOS_FANATIC("npc_boss_kc25", AttribType.INTEGER),
	KC_TZKAL_ZUK("npc_boss_kc26", AttribType.INTEGER),
	
	QA_BOOK_PAGE("information_book_page", AttribType.INTEGER),
	
	// Varbit usage for 9 different types of herb stored in our sack.
	HERBSACK1("HERBSACK1", AttribType.INTEGER),
	HERBSACK2("HERBSACK2", AttribType.INTEGER),
	HERBSACK3("HERBSACK3", AttribType.INTEGER),
	
	//Yell channel preference save field
	YELL_CHANNEL_DISABLED("chat;yell_channel_disabled", AttribType.BOOLEAN),
	
	// Marker for where we died.
	GRAVESTONE,
	
	// Attribute used by doors/gates to record what cycles they were opened/closed on.
	DOOR_USES,
	
	// The interface and child id of a spell when used on an entity. For interactions.
	INTERACTED_WIDGET_INFO,
	
	/**
	 * Key used to store Demonic Gorilla hits
	 */
	DEMONIC_GORILLA_MELEE,
	DEMONIC_GORILLA_RANGE,
	DEMONIC_GORILLA_MAGE,
	
	/**
	 * Key used to store Demonic Gorilla protection boolean
	 */
	DEMONIC_GORILLA_PRAY_MELEE,
	DEMONIC_GORILLA_PRAY_RANGE,
	DEMONIC_GORILLA_PRAY_MAGE,
	
	/**
	 * Key used to store how many times the Demonic Gorilla has attacked
	 */
	DEMONIC_GORILLA_TIMES_HIT,
	
	/**
	 * Key used to store if we've talked to Brian O' Richard or not
	 */
	
	BRIAN_O_RICHARD_DIALOGUE("brian_o_richard_dialogue", AttribType.INTEGER),
	
	/**
	 * Player key used determine if our players has an active armour set
	 */
	ACTIVE_ARMOUR_SET,
	
	/**
	 * Key used to store voting points
	 */
	VOTING_POINTS("voting_points", AttribType.INTEGER),
	
	/**
	 * The key used to represent loyalty points.
	 */
	LOYALTY_POINTS("loyalty_points", AttribType.INTEGER),
	
	/**
	 * Key to handle time spent inside the Warriors Guild Cyclops room.
	 */
	WARRIORS_GUILD_CYCLOPS_ROOM("wguild_time", AttribType.INTEGER),
	
	/**
	 * Key to handle which defenders are currently being dropped.
	 */
	WARRIORS_GUILD_CYCLOPS_ROOM_DEFENDER("wguild_defender", AttribType.INTEGER),
	FARMSTATE_CAMELOT("farm_cam", AttribType.INTEGER),
	FARMSTATE_ARDOUGNE("farm_ardy", AttribType.INTEGER),
	FARMSTATE_FALADOR("farm_fally", AttribType.INTEGER),
	FARMSTATE_CANIFIS("farm_canifis", AttribType.INTEGER),
	FARMSTATE_ZEAH("farm_zeah", AttribType.INTEGER),
	
	/**
	 * A bitpacked value for hunting info on mapobjects
	 * Bit 1 = being pathed towards by an Npc or player. Interacted with. Don't expire during this.
	 * Bits 2-4 = loot type, such as grey/black/red chinchompa.
	 */
	HUNTER_INFO,
	
	// How much BM we last died with. Used to combat raggers/no risk suicide accounts.
	LASTDEATH_VALUE,
	
	// Tile we died at.
	LAST_DEATH_TILE,
	
	// Tracks bird traps connected to us.
	BIRDSNARE_LIST,
	
	/**
	 * Key used to store amount of compost we can collect
	 */
	COMPOST_BIN("compost_bin", AttribType.INTEGER),
	
	/**
	 * Key used to store the last teleport used.
	 */
	PREVIOUS_TELEPORT,
	
	/**
	 * The key to use as the String we last used as preset (name)
	 */
	LAST_PRESET,
	
	/**
	 * The maximum distance that an entity can travel before they travel
	 * back to their spawn location.
	 */
	MAX_DISTANCE_FROM_SPAWN,
	
	/**
	 * The key that determines if the cerberus attack specific to
	 * summoned souls is available or not.
	 */
	CERBERUS_SUMMONED_SOUL_ATTACK_UNAVAILABLE,
	
	/**
	 * The key that determines whether or not Cerberus's attack for
	 * rotating the attack style is available.
	 */
	CERBERUS_COMBAT_STYLE_ROTATION_ACTIVE,
	
	/**
	 * The time in milliseconds of the last rotation
	 */
	CERBERUS_LAST_ROTATION,
	
	/**
	 * A reference to the last used combat style
	 */
	LAST_COMBAT_STYLE,
	
	/**
	 * The key representing the time in milliseconds that the perks were searched
	 */
	FLETCHING_PERK_SEARCH_TIME("fletching_perk_search_time", AttribType.LONG),
	
	/**
	 * The amount of times the search has been used in the key time
	 */
	FLETCHING_PERK_SEARCH_AMOUNT("fletching_perk_search_amount", AttribType.INTEGER),
	
	// the perk used to toggle the ROL effect from the cape
	DEFENCE_PERK_TOGGLE("defence_perk_toggle", AttribType.INTEGER),
	
	// the perk that symbolizes the spellbook swap
	MAGIC_PERK("magic_perk_spellbook", AttribType.LONG),
	
	// A varbit for settings not defined in the cache definition.
	GENERAL_VARBIT1("general_varbit1", AttribType.INTEGER),
	
	// the key representing pest control points for the pest control minigame
	PEST_CONTROL_POINTS("pest_control_points", AttribType.INTEGER),
	
	// represents the points obtained whilst within the pest control minigame.
	TEMPORARY_PEST_CONTROL_POINTS,
	
	// when a player is not in the group shipped off they are given a priority
	// of 1 where as the default is 0.
	PEST_CONTROL_LANDER_PRIORITY,
	
	// the pest control reward that this player has selected
	// to purchase, if any.
	PEST_CONTROL_REWARD_SELECTED,
	
	// For gwd - tracking how long ago certain players attached us.
	LAST_ATTACKED_MAP,
	
	// A map linking minions together used in group respawning.
	MINION_LIST,
	
	// last engine cycle we changed agro targets in gwd.
	LAST_AGRO_SWITCH,
	
	// The value of the face-entity mask.
	LAST_FACE_ENTITY_IDX,
	
	// Value of the last face tile mask
	LAST_FACE_TILE,
	
	// How many cycles remain for this venom task. NOT game cycle. One venom cycle = 20 game ticks
	VENOM_TICKS("venom_ticks", AttribType.INTEGER),
	
	// the state that the lunar spell tan leather is in.
	LUNAR_TAN_LEATHER_STATE("lunar_tan_leather", AttribType.INTEGER),
	
	// Skotizo is currently in his, 'jumping' state.
	SKOTIZO_JUMP_STATE,
	
	//Determines if this is a reanimated NPC spawned through the Arceuus spellbook
	IS_REANIMATED_MONSTER,
	
	//Determines if our player has already spawned a reanimated NPC
	HAS_REANIMATED_MONSTER,
	
	// A temporary ItemContainer to hold Price Guide interface items.
	PRICE_GUIDE_CONTAINER,
	
	/**
	 * The time in MS a stake was started. Used for an anti-DDoS measure in arena.
	 */
	STAKE_START,
	
	/**
	 * Indicates what option has been chosen when prompted with a warning before staking.
	 */
	DUEL_ANTISCAM_WARRNING_STAGE,
	
	/**
	 * Amount of Wintertodt points collected. Does not save.
	 */
	WINTERTODT_POINTS,
	
	/**
	 * Determines if we've spoken to Ignisia inside Wintertodt.
	 */
	TALKED_TO_IGNISIA("tlkd_to_ignisai", AttribType.INTEGER),
	
	/**
	 * Determines if our player has already received a Looting bag
	 */
	RECEIVED_LOOTING_BAG_WARNING("looting_bag_warning", AttribType.INTEGER),
	
	// The total amount of blood money (w2) risked including our +1 when entering the wilderness. Anti-rag mechanic.
	RISKED_WEALTH,
	// Wealth total of untradables that you keep under 20 wild, >= 20 you lose em!
	RISKED_WEALTH_UNTRADBLES_PROTECTED_UNDER20,
	
	/**
	 * Which wave our player is currently on for the Tzhaar Fight Caves
	 * Value=0 default, not in caves. -1=pre-start, pre wave 1. Value 1-63 represent waves.
	 */
	TZHAAR_FIGHT_CAVES_WAVE("tzhaar_wave", AttribType.INTEGER),
	
	/**
	 * Saves the logout warning
	 */
	TZHAAR_LOGOUT_WARNING,
	
	/**
	 * Determines if our player is currently playing the Tzhaar Fight Caves minigame
	 */
	TZHAAR_MINIGAME,
	
	/**
	 * The save field for checking if a player has sacrificed a cape to the TzHaar.
	 */
	INFERNAL_SACRIFICE("infernal_sacrificed", AttribType.BOOLEAN),
	
	/**
	 * The save field for checking if the player has access to the infernal city.
	 */
	INFERNAL_ACCESS("infernal_access", AttribType.BOOLEAN),
	
	/**
	 * Determines if Tztok Jad has spawned his healers or not
	 */
	JAD_SPAWNED_HEALERS,
	
	/**
	 * Represents the controller of the specified inferno npc
	 */
	INFERNO_CONTROLLER,
	
	/**
	 * This is autistic naming but we hardcode for the first sending of the
	 * ranger + mager mobs on the final wave since we don't definitively know the interval on osrs.
	 */
	INFERNO_FINAL_BOSS_MAGE_RANGE_SPAWN,
	
	/**
	 * Is Barrelchest in his jump state?
	 */
	
	BARRELCHEST_JUMP_STATE,
	
	/**
	 * A save key to track our skull cycles remaining.
	 */
	SKULL_CYCLES("skull_cycles", AttribType.INTEGER),
	
	/*
	* Used for hunter. The exact instances of MapObjs change, however the attributes
	* are retained (copied from source to destination) for new mapobj instances, so we'll
	* use this an an identifier.
	*/
	MAPOBJ_UUID,
	
	/**
	 * A flag for vetion indicating if he has spawned his pets yet.
	 */
	VETION_HELLHOUND_SPAWNED,
	VETION_REBORN_ACTIVE,
	
	/**
	 * Amount of times the player has slain the Wintertodt.
	 */
	WINTERTODT_COUNT("wintertodt", AttribType.INTEGER),
	
	/**
	 * Best-ever highscore achieved at a Wintertodt game.
	 */
	WINTERTODT_HIGHSCORE("wintertodt_hs", AttribType.INTEGER),
	
	/**
	 * Total number of points accumulated throughout all games
	 */
	WINTERTODT_TOTAL("wintertodt_pts", AttribType.INTEGER),
	
	/**
	 * Handle our increased combat stats
	 */
	INCREASED_ACCURACY,
	INCREASED_DEFENCE,
	
	/**
	 * Saves all our previous clan chat settings
	 */
	CLAN_NAME("clan_name", AttribType.STRING),
	CLAN_ENTER("enter_settings", AttribType.INTEGER),
	CLAN_TALK("clan_talk", AttribType.INTEGER),
	CLAN_KICK("clan_kick", AttribType.INTEGER),
	
	HUNTER_CURRENT("hunter_current", AttribType.INTEGER),
	HUNTER_RECORD("hunter_record", AttribType.INTEGER),
	ROGUE_CURRENT("rogue_current", AttribType.INTEGER),
	ROGUE_RECORD("rogue_record", AttribType.INTEGER),
	BOUNTIES("bounties", AttribType.INTEGER),
	BOUNTY_HUNTER_PENALTIES("bh_penalties", AttribType.INTEGER),
	BOUNTY_HUNTER_TOGGLED_OFF("bh_toggle", AttribType.BOOLEAN),
	BOUNTY_HUNTER_POINTS("bh;points", AttribType.INTEGER),
	BOUNTY_HUNTER_TARGET_SKIPS("bh;target_skips", AttribType.INTEGER),
	BOUNTY_HUNTER_TARGET_TELEPORT_UNLOCKED("bh;teleport_target_unlocked", AttribType.BOOLEAN),
	BOUNTY_HUNTER_TARGET_NAME,
	BOUNTY_HUNTER_TARGET,
	BOUNTY_HUNTER_LAST_SKIPPED_TARGET,
	BOUNTY_HUNTER_OUTSIDE,
	
	/**
	 * Save's the NPC's spawned in the for the Abyssal Sire
	 */
	ABYSSAL_SIRE_TENTACLES,
	ABYSSAL_SIRE_RESPIRATORY_SYSTEMS,
	
	/**
	 * Handles Abyssal Sire's combat state
	 */
	ABYSSAL_SIRE_STATE,
	
	/**
	 * Handles Abyssal Sire's combat phase
	 */
	ABYSSAL_SIRE_PHASE,
	
	/**
	 * Handles if Abyssal Sire is currently spawning a minion
	 */
	ABYSSAL_SIRE_SPAWNING_MINION,
	
	/**
	 * Handles if Abyssal Sire is currently spawning poisonous fumes
	 */
	ABYSSAL_SIRE_SPAWNING_FUMES,
	
	/**
	 * Key used to store the Abyssal Sire owning the NPC
	 */
	OWNING_ABYSSAL_SIRE,
	
	/**
	 * Key used to store Abyssal Sire's challenging player
	 */
	ABYSSAL_SIRE_CHALLENGING_PLAYER,
	
	/**
	 * Key used to store Abyssal Sire's spawns NPCs
	 */
	ABYSSAL_SIRE_SPAWNS,
	
	/**
	 * Key used to store which Abyssal Sire the spawn belongs too
	 */
	ABYSSAL_SIRE_SPAWN_OWNER,
	
	CRYSTAL_SEED_TO_BOW_ENCHANTS("crystal_seed_to_bow_count", AttribType.INTEGER),
	CRYSTAL_SEED_TO_SHIELD_ENCHANTS("crystal_seed_to_shield_count", AttribType.INTEGER),
	CRYSTAL_SEED_TO_HALBERD_ENCHANTS("crystal_seed_to_halberd_count", AttribType.INTEGER),
	
	// Key used to know where we'll be travelling from. Depending on this source point, the ship fares change.
	CHARTER_SHIP_SOURCE_POINT,
	
	/**
	 * Key used in NPC poisoning since they have no varps. Players do *not* use this.
	 */
	POISON_TICKS,
	
	/**
	 * Key used to store clue scroll container
	 */
	TREASURE_TRAIL_REWARD,
	
	/**
	 * Key used to store the players Halloween progress
	 */
	HALLOWEEN_EVENT_2016("hween_event_2016", AttribType.INTEGER),
	HALLOWEEN_RIDDLE_ONE("hween_riddle_one", AttribType.BOOLEAN),
	HALLOWEEN_RIDDLE_TWO("hween_riddle_two", AttribType.BOOLEAN),
	HALLOWEEN_RIDDLE_THREE("hween_riddle_three", AttribType.BOOLEAN),
	HALLOWEEN_RIDDLE_FOUR("hween_riddle_four", AttribType.BOOLEAN),
	HALLOWEEN_RIDDLE_FIVE("hween_riddle_five", AttribType.BOOLEAN),
	HALLOWEEN_RIDDLE_SIX("hween_riddle_six", AttribType.BOOLEAN),
	
	// Temp attrib used by admins to create areas on the fly to be used in DMM safezones
	ADMIN_TEMPATTRIB_SAFEAREA,
	
	// Holds a container 10 items (fully stackable) big with your most value items to be lost from your bank on death.
	DEADMAN_INFO,
	
	/**
	 * Container holding the players cluescroll reward
	 */
	CLUE_SCROLL_REWARD,
	
	/**
	 * Container holding the players cluescroll reward
	 */
	TREASURE_TRAIL_PUZZLE,
	
	/**
	 * Key to store how many clue scrolls our player has completed
	 */
	EASY_CLUE_SCROLL("easy_clue", AttribType.INTEGER),
	MEDIUM_CLUE_SCROLL("med_clue", AttribType.INTEGER),
	HARD_CLUE_SCROLL("hrd_clue", AttribType.INTEGER),
	ELITE_CLUE_SCROLL("elite_clue", AttribType.INTEGER),
	MASTER_CLUE_SCROLL("mstr_clue", AttribType.INTEGER),
	
	/**
	 * The last Hit object done to the player. Used on death to determine a message to broadcast for
	 * Hardcore Ironman players.
	 */
	LAST_HIT,
	
	/**
	 * If the warning has been set to not appear.
	 */
	PLANK_MAKE_WARNING,
	
	// Last time we boosted our prayer
	PRAYERCAPE_BOOST,
	
	/**
	 * The direction (can be diagonal) which we are facing after our next move this game cycle has been established and set in Player Updating.
	 * This direction is then sent when a new entity is added to our local list :)
	 */
	FACING_DIRECTION,
	
	/**
	 * Attribute to ensure our player has taken the time to understand what the minigame is.
	 */
	STARTED_BLOODY_SURVIVAL_MINIGAME("strtd_blud_srvivl", AttribType.BOOLEAN),
	
	/**
	 * Attribute keys for Carol's favorite toy (Christmas 2016)
	 */
	CAROLS_CHRISTMAS("crls_christmas", AttribType.INTEGER),
	CAROLS_TOY("crls_toy", AttribType.INTEGER),
	CAROLS_TOY_COLOR("crls_toy_clr", AttribType.INTEGER),
	CAROLS_REQUIRED_TOY("crls_rqrd_toy", AttribType.INTEGER),
	
	/**
	 * Key which is used to store whether or not other player is currently watching a cutscene.
	 */
	CUTSCENE_IN_PROGESS,
	
	/**
	 * Key used to store how many sites we've voted for in the past 24 hours (clears on a persistent timer from first reward)
	 */
	VOTE_REWARDS_CLAIMED_TODAY,
	
	/**
	 * Key used to store how many sites our player has voted in total.
	 */
	TOTAL_VOTES_CLAIMED,
	
	/**
	 * Stores an instance of DoubleDoorLink used to remember various MapObj variable values.
	 */
	DOUBLE_DOOR_LINK,
	
	/**
	 * Attribute key which stores the contents of players small -> giant pouches
	 */
	SMALL_POUCH("small_pouch", AttribType.INTEGER),
	MEDIUM_POUCH("medium_pouch", AttribType.INTEGER),
	LARGE_POUCH("large_pouch", AttribType.INTEGER),
	GIANT_POUCH("giant_pouch", AttribType.INTEGER),
	
	/**
	 * Attribute key used to determine what type of essence is inside our players small -> giant pouches
	 */
	STORED_IN_SMALL_POUCH("strd_in_sml", AttribType.INTEGER),
	STORED_IN_MEDIUM_POUCH("strd_in_md", AttribType.INTEGER),
	STORED_IN_LARGE_POUCH("strd_in_lrg", AttribType.INTEGER),
	STORED_IN_GIANT_POUCH("strd_in_gnt", AttribType.INTEGER),
	
	/**
	 * Attribute key used to determine if our player wants to keep vials or not
	 */
	GIVE_EMPTY_POTION_VIALS("remove_potions", AttribType.BOOLEAN),
	
	/**
	 * Tier of protection currently active. Tier corresponds to X bloodmoney risked.
	 */
	RISK_PROT_TIER("risk_prot_tier", AttribType.INTEGER),
	
	/**
	 * Epoch time (system millis / 1000) of when the last "daily bonus" was awarded.
	 */
	LAST_BONUS_EPOCH("dailybonus_epoch", AttribType.INTEGER),
	
	/**
	 * A map containing player.id : game cycle # when you began attacking someone. Used to stop rushing, such as using special 16 ticks after initiating combat.
	 */
	PVP_WILDY_AGGRESSION_TRACKER,
	
	GEMBAG_SAPPHIRE,
	GEMBAG_EMERALD,
	GEMBAG_RUBY,
	GEMBAG_DIAMOND,
	GEMBAG_DRAGONSTONE,
	
	/**
	 * Flag when player option 6 for "gifting prayers" is active.
	 */
	GIFT_PRAYERS_PLAYER_OP,
	
	/**
	 * Tracks whether a player has an active cannon or not.
	 */
	DWARF_MULTI_CANNON,
	
	/**
	 * Tracks whether a player is in the world map.
	 */
	WORLD_MAP,
	
	/**
	 * Determines if TzKal-Zuk has spawned his healers or not
	 */
	TZKAL_ZUK_SPAWNED_HEALERS,
	
	/**
	 * Determines if TzKal-Zuk has spawned the jad or not.
	 */
	TZKAL_SPAWNED_JAD,
	
	/**
	 * Checks if the player is in an inferno game.
	 */
	INFERNO_SESSION,
	
	/**
	 * For certain bosses, they ignore the facing to their target, so for that reason we
	 * add this flag to their map.
	 */
	IGNORE_TARGET_FACING,
	
	/**
	 * Run time field for inferno.
	 */
	INFERNO_RUNTIME("inferno;runtime", AttribType.LONG),
	
	/**
	 * The save field if the player decides to log out
	 */
	INFERNO_SAVED_WAVE("inferno;saved_wave", AttribType.INTEGER),
	
	/**
	 * The logout warning if a player attempts a log out during inferno.
	 */
	INFERNO_LOGOUT_WARNING,
	
	/**
	 * THIS SHOULD BE TEMPORARY. THIS IS JUST A COMBAT ATTR TO MAKE IT SO PLAYERS CANNOT
	 * PROTECTE AGAINST THE NPC'S ATTACK SINCE I CAN'T FIGURE OUT JAK'S PROT CODE ATM.
	 */
	UNPROTECTABLE_ATTACKS,
	
	/**
	 * Players previous map
	 */
	PREVIOUS_MAP,
	
	REGION_CHANGING,
	
	ALWAYS_HIT,
	
	HEIGHT_CHANGING,
	
	/**
	 * Represents the exchange session the player is holding with Sigmund.
	 */
	SIGMUND_EXCHANGE_SESSION,
	
	/**
	 * A save key used for the 2017 PVP world halloween event.
	 */
	HALLOWEEN_SOULS_COLLECTED("halloween;souls_collected", AttribType.INTEGER),
	
	/**
	 * A hack designed to solve an issue in BH.
	 */
	SCANNING_BOUNTYHUNTER,
	
	/**
	 * A string used to track the last 10 killed players.
	 */
	KILLED_PLAYERS("killed_players", AttribType.STRING),
	
	
	/**
	 * Handles if Abyssal Sire is currently healing
	 */
	ABYSSAL_SIRE_SPAWNING_HEALING,
	
	/**
	 * The save field used for tracking the player's progression on various achievement diary tasks.
	 */
	ACHIEVEMENT_TASK_TRACKER("achievement_tracker", AttribType.STRING),
	ACHIEVEMENT_PROGRESSION_MAP,
	ACHIEVEMENT_DIARIES_COMPLETED,
	
	/**
	 * Keeps info in one place for pk-bot related attribs.
	 */
	BOT_INFO,
	
	/**
	 * A key used to cache the search results the player received whilst using the Bestiary
	 * drop table tool.
	 */
	BESTIARY_RESULTS,
	
	/**
	 * A key used for referencing with the bestiary lookup interface.
	 * We set a stage value depending on what info they're looking at so we can accurately manage
	 * interacting.
	 */
	BESTIARY_SCREEN_STAGE,

	/**
	 * Key indicating whether the Gold voting skin is unlocked.
	 */
	GOLD_SKIN_UNLOCKED("gold_skin", AttribType.BOOLEAN),
	
	/**
	 * Handles Abyssal Sire's combat state
	 */
	ABYSSAL_SIRE_TELEPORT_NEXT_HIT,
	NO_RETALIATE,

    /**
     * A key used to bypass any hit restrictions.
     */
    FORCED_HIT,

    /**
     * A key used to signify the player is busy (a general flag to indicate they're doing some action if we wish to 'lock' them from
     * doing anything else)
     */
	BUSY,

	/**
	 * An ID to differentiate between uses of interface 310 - macks sexy beastiary display
	 */
	LAST_INTER_310_USE_ID,


	/**
	 * An ID to differentiate between open books using the same interface
	 */
	OPEN_BOOK_ID,

	
	FIRST_KILL_OF_THE_DAY("first_kill_otd", AttribType.LONG),

	/**
	 * Tracks the last times we've used words which are blacklisted - advertisers
	 */
	SPAM_HISTORY,

	/**
	 * Amount of npcs left to kill on this task
	 */
	SLAYER_TASK_AMT("slayertask:amount", AttribType.INTEGER),
	/**
	 * The creature UID of this slayer task {@code SlayerTaskDef}
	 */
	SLAYER_TASK_ID("slayertask:id", AttribType.INTEGER),

    /**
     * A key used to track the time a player last claimed their blood money reward.
     */
    BLOOD_MONEY_CLAIM("last_bm_claim", AttribType.LONG),

	/**
	 * A key used to cache a tile location if we wish to return the player there
	 * and or reference it in later callings.
	 */
	CACHED_TILE,

	/**
	 * CategoryIndex and SubcategoryIndex for teleport interface
	 */
	TELEPORT_CATEGORY_INDEX("t_category_index", AttribType.INTEGER),
	TELEPORT_SUBCATEGORY_INDEX("t_subcategory_index", AttribType.INTEGER),

	/**
	 * Loyalty chest
	 */
	LOYALTY_CHEST_COUNT("loyalty_chest_count", AttribType.INTEGER),
	LOYALTY_CHEST_SPREE("loyalty_chest_spree", AttribType.INTEGER),
	LOYALTY_CHEST_HIGHEST_SPREE("loyalty_chest_hs", AttribType.INTEGER),
	LOYALTY_CHEST_DAY_REWARD("loyalty_chest_rwd", AttribType.INTEGER),

	SWAP_MAGE_PRAYERS("swap_mage_prayer", AttribType.BOOLEAN),
	SWAP_RANGE_PRAYERS("swap_range_prayer", AttribType.BOOLEAN),

	HIDE_TIMERS("hide_timers", AttribType.BOOLEAN),
	VORKATH_KC("vorkath_kc", AttribType.INTEGER),
	ANCIENT_WYVERN_KC("ancient_wyvern_kc", AttribType.INTEGER),
	TEKTON_KC("tekton_kc", AttribType.INTEGER),
	DEMONIC_GORILLA_KC("demonic_gorilla_kc", AttribType.INTEGER),
	SKOTIZO_KC("skotizo_kc", AttribType.INTEGER),
	REVENANT_KC("revenant_kc", AttribType.INTEGER),
	BATTLE_MAGE_KC("battle_mage_kc", AttribType.INTEGER),

	GRANITE_MAUL_SPECIALS,
	GRANITE_MAUL_TIMEOUT_TICKS,
	
	/**
	 * The time (System.currentTimeMillis()) that we last claimed the refund for this account. May be 0 or missing.
	 */
	LAST_REFUND_CLAIM("last_refund", AttribType.LONG),

	/**
	 * Attribute keys for the tournament system
	 */
	UNCLAIMED_TOURNAMENT_BM("tourny_rewards", AttribType.INTEGER),

	YELL_DISABLED("yell_disabled", AttribType.BOOLEAN),

	/**
	 * Wilderness hotspot enter/exit notification
	 */
	WILDERNESS_HOTSPOT_NOTIFICATION,

	/**
	 * Bracelet of Ethereum absorption toggle
	 */
	ETHEREUM_ABSORPTION("eth_aborption", AttribType.BOOLEAN),

	/**
	 * Store the obelisk redirection scroll unlock
	 */
	OBELISK_REDIRECTION_SCROLL("obelisk_scroll", AttribType.BOOLEAN),
	OBELISK_DESTINATION("obelisk_dest", AttribType.INTEGER),

	/**
	 * UpdateStateCustom has been sent
	 */
	UPDATE_STATE_CUSTOM("update_state_cstm", AttribType.BOOLEAN),

	ELO_RATING("elo_rating", AttribType.INTEGER),

	/**
	 * Bloody fragment count used for the bloody volcano
	 */
	BLOODY_FRAGMENTS,
	BLOODY_FRAGMENT_UPDATE
	;
	
	private String saveName;
	private AttribType type;
	
	AttributeKey() {
		
	}
	
	AttributeKey(String name, AttribType persistType) {
		this.saveName = name;
		this.type = persistType;
	}
	
	public String saveName() {
		return saveName;
	}
	
	public AttribType saveType() {
		return type;
	}
	
}
