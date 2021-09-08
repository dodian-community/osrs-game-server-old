package net.dodian.runescape.handlers.impl;

import net.dodian.runescape.model.Tile;
import net.dodian.runescape.model.World;
import net.dodian.runescape.model.entity.Npc;
import net.dodian.runescape.model.entity.npc.NpcCombatInfo;
import net.dodian.runescape.orm.models.NpcConfig;
import net.dodian.runescape.orm.repositories.NpcConfigsRepository;
import net.dodian.runescape.orm.repositories.NpcSpawnsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NpcSpawnsHandler implements InitializingBean, BeanFactoryAware {

    private static final Logger logger = LogManager.getLogger(NpcSpawnsHandler.class);

    private final NpcSpawnsRepository spawnsRepository;
    private final NpcConfigsRepository configsRepository;
    private final World world;

    private BeanFactory beanFactory;

    @Autowired
    public NpcSpawnsHandler(NpcSpawnsRepository spawnsRepository, NpcConfigsRepository configsRepository, World world) {
        this.spawnsRepository = spawnsRepository;
        this.configsRepository = configsRepository;
        this.world = world;
    }

    @Override
    public void afterPropertiesSet() {
        List<Npc> npcSpawns = new ArrayList<>();
        spawnsRepository.findAll().forEach(npcSpawn -> {
            Npc npc = beanFactory.getBean(Npc.class);
            NpcConfig config = configsRepository.findFirstByNpcIdEquals(npcSpawn.getNpcId()).orElse(null);

            npc.setId(npcSpawn.getNpcId());

            Tile tile = new Tile(npcSpawn.getX(), npcSpawn.getY(), npcSpawn.getLevel());

            npc.tile(tile);
            npc.setSpawnTile(tile);

            npc.spawnDirection(npcSpawn.getDirection());
            npc.walkRadius(npcSpawn.getWalkRadius());

            if((config != null && config.isAttackAble())) {
                NpcCombatInfo info = new NpcCombatInfo();
                info.stats = new NpcCombatInfo.Stats();
                info.animations = new NpcCombatInfo.Animations();
                info.sounds = new NpcCombatInfo.Sounds();
                info.bonuses = new NpcCombatInfo.Bonuses();
                info.scripts = new NpcCombatInfo.Scripts();
                info.originalStats = info.stats;
                npc.combatInfo(parseNpcConfig(info, config));
            }

            npcSpawns.add(npc);
        });

        npcSpawns.forEach(world::registerNpc);
        logger.info("Spawned {} NPCs.", npcSpawns.size());
    }

    private NpcCombatInfo parseNpcConfig(NpcCombatInfo combatInfo, NpcConfig npcConfig) {
        if(npcConfig == null) {
            return null;
        }

        combatInfo.stats.health = npcConfig.getHealth();
        combatInfo.stats.defence = npcConfig.getDefenceLevel();
        combatInfo.stats.attack = npcConfig.getAttackLevel();
        combatInfo.stats.strength = npcConfig.getStrengthLevel();
        combatInfo.stats.magic = npcConfig.getMagicLevel();
        combatInfo.stats.ranged = npcConfig.getRangedLevel();

        combatInfo.sounds.attack = npcConfig.getAttackSound();
        combatInfo.sounds.death = npcConfig.getDeathSound();
        combatInfo.sounds.block = npcConfig.getBlockSound();

        combatInfo.animations.attack = npcConfig.getAttackAnimation();
        combatInfo.animations.death = npcConfig.getDeathAnimation();
        combatInfo.animations.block = npcConfig.getBlockAnimation();

        combatInfo.bonuses.attack = npcConfig.getAttackBonus();
        combatInfo.bonuses.magic = npcConfig.getMagicBonus();
        combatInfo.bonuses.ranged = npcConfig.getRangedBonus();
        combatInfo.bonuses.strength = npcConfig.getStrengthBonus();
        combatInfo.bonuses.stabDefence = npcConfig.getStabDefenceBonus();
        combatInfo.bonuses.slashDefence = npcConfig.getSlashDefenceBonus();
        combatInfo.bonuses.crushDefence = npcConfig.getCrushDefenceBonus();
        combatInfo.bonuses.rangedDefence = npcConfig.getRangedDefenceBonus();
        combatInfo.bonuses.magicDefence = npcConfig.getMagicDefenceBonus();

        combatInfo.maxHit = npcConfig.getMaxHit();
        combatInfo.attackSpeed = npcConfig.getAttackSpeed();
        combatInfo.slayerExperience = npcConfig.getSlayerExperience();
        combatInfo.slayerLevel = npcConfig.getSlayerLevel();
        combatInfo.respawnTime = npcConfig.getRespawnTime();
        combatInfo.respawnTimeRandomOffset = npcConfig.getRespawnTimeRandomOffset();
        combatInfo.retaliates = npcConfig.isRetaliating();
        combatInfo.aggressive = npcConfig.isAggressive();
        combatInfo.aggroRadius = npcConfig.getAggroRadius();
        combatInfo.unAttackAble = !npcConfig.isAttackAble();
        combatInfo.dropRolls = npcConfig.getDropRolls();
        combatInfo.boss = npcConfig.isBoss();

        combatInfo.scripts.hit = npcConfig.getHitScript();
        combatInfo.scripts.combat = npcConfig.getCombatScript();
        combatInfo.scripts.death = npcConfig.getDeathScript();
        combatInfo.scripts.dropTable = npcConfig.getDropTableScript();
        combatInfo.scripts.aggression = npcConfig.getAggressionScript();

        combatInfo.originalStats = combatInfo.stats;
        return combatInfo;
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
