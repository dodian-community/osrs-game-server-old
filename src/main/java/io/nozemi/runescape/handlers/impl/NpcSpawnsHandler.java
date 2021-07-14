package io.nozemi.runescape.handlers.impl;

import io.nozemi.runescape.handlers.Handler;
import io.nozemi.runescape.model.Tile;
import io.nozemi.runescape.model.World;
import io.nozemi.runescape.model.entity.Npc;
import io.nozemi.runescape.orm.repositories.NpcSpawnsRepository;
import io.nozemi.runescape.util.SpawnDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NpcSpawnsHandler implements InitializingBean {

    private static final Logger logger = LogManager.getLogger(NpcSpawnsHandler.class);

    private final NpcSpawnsRepository repository;
    private final World world;

    @Autowired
    public NpcSpawnsHandler(NpcSpawnsRepository repository, World world) {
        this.repository = repository;
        this.world = world;
    }

    @Override
    public void afterPropertiesSet() {
        List<Npc> npcSpawns = new ArrayList<>();
        repository.findAll().forEach(npcSpawn -> {
            Npc npc = new Npc(npcSpawn.getNpcId(), world, new Tile(npcSpawn.getX(), npcSpawn.getY(), npcSpawn.getLevel()));
            npc.spawnDirection(npcSpawn.getDirection());
            npc.walkRadius(npcSpawn.getWalkRadius());
            npcSpawns.add(npc);
        });

        npcSpawns.forEach(world::registerNpc);
        logger.info("Spawned {} NPCs.", npcSpawns.size());
    }
}
