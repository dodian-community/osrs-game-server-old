package io.nozemi.runescape.orm.repositories;

import io.nozemi.runescape.orm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByUsername(String username);
    Optional<User> findFirstByEmail(String email);
}
