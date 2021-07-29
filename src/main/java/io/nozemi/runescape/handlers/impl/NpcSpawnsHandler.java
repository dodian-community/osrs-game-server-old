package io.nozemi.runescape.handlers.impl;

import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.model.entity.npc.NpcCombatInfo;
import io.nozemi.runescape.orm.models.NpcSpawn;
import io.nozemi.runescape.orm.repositories.NpcSpawnsRepository;
import io.nozemi.runescape.util.SpawnDirection;
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

    private final NpcSpawnsRepository repository;
    private final World world;

    private BeanFactory beanFactory;

    @Autowired
    public NpcSpawnsHandler(NpcSpawnsRepository repository, World world) {
        this.repository = repository;
        this.world = world;
    }

    @Override
    public void afterPropertiesSet() {
        List<Npc> npcSpawns = new ArrayList<>();
        repository.findAll().forEach(npcSpawn -> {
            Npc npc = beanFactory.getBean(Npc.class);

            npc.setId(npcSpawn.getNpcId());

            Tile tile = new Tile(npcSpawn.getX(), npcSpawn.getY(), npcSpawn.getLevel());

            npc.tile(tile);
            npc.setSpawnTile(tile);

            npc.spawnDirection(npcSpawn.getDirection());
            npc.walkRadius(npcSpawn.getWalkRadius());

            NpcCombatInfo info = new NpcCombatInfo();
            info.stats = new NpcCombatInfo.Stats();
            info.stats.attack = 1;
            info.stats.defence = 1;
            info.stats.hitpoints = 10;
            info.maxhit = 10;

            npc.combatInfo(info);

            npcSpawns.add(npc);
        });

        npcSpawns.forEach(world::registerNpc);
        logger.info("Spawned {} NPCs.", npcSpawns.size());
    }

    @Override
    public void setBeanFactory(@NotNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
