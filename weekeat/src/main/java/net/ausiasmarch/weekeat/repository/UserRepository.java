package net.ausiasmarch.weekeat.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByUsername(String username);

  Page<UserEntity> findByNameContaining(String name, Pageable pageable);

  Optional<UserEntity> findByUsernameAndPassword(String username, String password);

 // Optional<UserEntity> findByToken(String token);

  Optional<UserEntity> findByEmail(String email);

  @Query(value = "SELECT * FROM user WHERE length(?1) >= 1 AND (name LIKE %?1% OR surname LIKE %?1% OR username LIKE %?1% OR email LIKE %?1%)", nativeQuery = true)
  Page<UserEntity> findByUserByNameOrSurnameContainingIgnoreCase(String searchText,
      String filter, String filter2, String filter3, Pageable pageable);

  @Modifying
  @Query(value = "ALTER TABLE user AUTO_INCREMENT = 1", nativeQuery = true)
  void resetAutoIncrement();

}
