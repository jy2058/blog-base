package me.jiyeon.kim.blogbase.Repository;

import me.jiyeon.kim.blogbase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
