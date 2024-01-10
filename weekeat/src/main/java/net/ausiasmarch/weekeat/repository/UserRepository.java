package net.ausiasmarch.weekeat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.weekeat.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
