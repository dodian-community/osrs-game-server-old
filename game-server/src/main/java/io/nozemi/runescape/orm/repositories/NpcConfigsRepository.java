package io.nozemi.runescape.orm.repositories;

import io.nozemi.runescape.orm.models.NpcConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NpcConfigsRepository extends JpaRepository<NpcConfig, Integer> {
    Optional<NpcConfig> findFirstByNpcId(int npcId);
    Optional<NpcConfig> findFirstByNpcIdEquals(int npcId);
}
