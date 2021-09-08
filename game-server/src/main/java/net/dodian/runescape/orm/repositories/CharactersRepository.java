package net.dodian.runescape.orm.repositories;

import net.dodian.runescape.orm.models.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharactersRepository extends JpaRepository<Character, Integer> {
    Optional<Character> findFirstByUsername(String username);
}
