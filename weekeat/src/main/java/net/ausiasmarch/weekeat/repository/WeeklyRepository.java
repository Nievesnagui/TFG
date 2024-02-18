package net.ausiasmarch.weekeat.repository;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public interface WeeklyRepository extends JpaRepository<WeeklyEntity, Long> {

    @Query(value = "SELECT NEW net.ausiasmarch.weekeat.entity.WeeklyEntity(w.id, w.id_user, w.init_date, w.schedules) FROM WeeklyEntity w WHERE w.id_user.id = ?1")
    Page<WeeklyEntity> findWeeklyWithSchedulesByUser(Long id_user, Pageable oPageable);

    @Query(value = "SELECT * FROM weekly w WHERE w.id_user = ?3 AND w.init_date BETWEEN ?1 AND ?2", nativeQuery = true)
    WeeklyEntity findBetweenDates(LocalDate start, LocalDate end, Long id_user);


    @Modifying
    @Query(value = "ALTER TABLE weekly AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
