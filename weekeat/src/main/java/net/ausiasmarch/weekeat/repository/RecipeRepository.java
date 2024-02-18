package net.ausiasmarch.weekeat.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    Optional<RecipeEntity> findByName(String name);

    @Query(value = "SELECT r.id, r.name, r.description, r.recipe_image, r.process FROM recipe r WHERE LENGTH(:searchText) >= 1 AND (r.name LIKE %:searchText% OR r.description LIKE %:searchText%)", nativeQuery = true)
    Page<Object[]> findByNameIgnoringCase(String searchText, Pageable pageable);
    
    @Modifying
    @Query(value = "ALTER TABLE recipe AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();

}
