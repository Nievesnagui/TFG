package net.ausiasmarch.weekeat.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.entity.IngredientEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>{
    Optional<IngredientEntity> findByIngredientName(String name);

    @Modifying
    @Query(value = "ALTER TABLE ingredient AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
