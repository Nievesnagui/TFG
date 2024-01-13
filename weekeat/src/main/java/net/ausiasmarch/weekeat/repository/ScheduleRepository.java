package net.ausiasmarch.weekeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {
     @Modifying
    @Query(value = "ALTER TABLE schedule AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
