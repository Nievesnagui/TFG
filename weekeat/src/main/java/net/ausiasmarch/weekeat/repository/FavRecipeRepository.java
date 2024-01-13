package net.ausiasmarch.weekeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.entity.FavRecipeEntity;

public interface FavRecipeRepository extends JpaRepository<FavRecipeEntity, Long>{
    @Modifying
    @Query(value = "ALTER TABLE fav_recipe AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
