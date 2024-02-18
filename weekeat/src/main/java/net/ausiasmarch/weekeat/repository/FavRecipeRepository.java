package net.ausiasmarch.weekeat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;


public interface FavRecipeRepository extends JpaRepository<FavRecipeEntity, Long> {

    @Query(value = "SELECT * FROM fav_recipe f WHERE f.id_user = ?1 ORDER BY f.id_user", nativeQuery = true)
    Page<FavRecipeEntity> findFavsByUserId(Pageable pageable, Long id_user);

    @Query(value = "SELECT * FROM fav_recipe f WHERE f.id_user = ?1 AND f.id_recipe=?2", nativeQuery = true)
    Page<FavRecipeEntity> findFavsByUserIdAndRecipeId(Pageable pageable, Long id_user, Long id_recipe);

    @Modifying
    @Query(value = "ALTER TABLE fav_recipe AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
