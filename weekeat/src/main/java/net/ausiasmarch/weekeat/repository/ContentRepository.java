package net.ausiasmarch.weekeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.ContentEntity;

public interface ContentRepository extends JpaRepository<ContentEntity, Long>{
   /* Page<ContentEntity> findByRecipeId(Long id_recipe, Pageable pageable);
    Page<ContentEntity> findByIngredientId(Long id_ingredient, Pageable pageable);
    */

    @Modifying
    @Query(value = "ALTER TABLE content AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
