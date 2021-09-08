package net.dodian.runescape.orm.repositories;

import net.dodian.orm.models.game.NpcSpawn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcSpawnsRepository extends JpaRepository<NpcSpawn, Integer> {
}
