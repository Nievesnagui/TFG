package net.ausiasmarch.weekeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;


public interface WeeklyRepository extends JpaRepository<WeeklyEntity, Long> {
     @Modifying
    @Query(value = "ALTER TABLE weekly AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
