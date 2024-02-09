package net.ausiasmarch.weekeat.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findByName(String name);
    

    @Modifying
    @Query(value = "ALTER TABLE recipe AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();

}
