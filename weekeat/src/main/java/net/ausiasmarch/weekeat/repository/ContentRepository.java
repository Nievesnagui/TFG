package net.ausiasmarch.weekeat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.RecipeEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Long>{
   /* Page<ContentEntity> findByRecipeId(Long id_recipe, Pageable pageable);
    Page<ContentEntity> findByIngredientId(Long id_ingredient, Pageable pageable);
    */

    @Modifying
    @Query(value = "ALTER TABLE content AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
