package net.dodian.runescape.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.dodian.orm.models.character.Character;

import java.util.Optional;

@Repository
public interface CharactersRepository extends JpaRepository<Character, Integer> {
    Optional<Character> findFirstByUsername(String username);
}
