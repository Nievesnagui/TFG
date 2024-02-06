package net.ausiasmarch.weekeat.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.weekeat.entity.IngredientEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>{
    Optional<IngredientEntity> findByName(String name);

   // Page<IngredientEntity> findByIdTypeId(Long id_type/*, Pageable pageable*/);
    
    //@Query(value = "SELECT i.id, i.id_type, i.name, i.ingredient_image FROM ingredient i JOIN content c ON i.id = c.id_ingredient WHERE c.id_recipe = :id_recipe")
    //Page<IngredientEntity> findByRecipe(@Param("id_recipe")Long id_recipe, Pageable pageable);


    @Modifying
    @Query(value = "ALTER TABLE ingredient AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
