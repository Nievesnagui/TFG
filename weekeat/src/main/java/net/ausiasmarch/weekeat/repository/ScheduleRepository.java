package net.ausiasmarch.weekeat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.weekeat.api.dto.ScheduleDTO;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

  @Query(value = "SELECT * FROM schedule s WHERE EXISTS(SELECT 1 FROM weekly w WHERE w.id = s.id_weekly AND w.id_user = ?1) ORDER BY s.id_weekly", nativeQuery = true)
  Page<ScheduleEntity> findSchedulesByUserId(Pageable pageable, Long id_user);

  // Este estoy probando
  @Query(value = "SELECT NEW net.ausiasmarch.weekeat.api.dto.ScheduleDTO(s.id, s.id_weekly, s.id_recipe, s.type, s.day) FROM ScheduleEntity s WHERE s.id_weekly = ?1 ORDER BY s.id_weekly")
  List<ScheduleDTO> findSchedulesArrayByWeeklyId(WeeklyEntity weeklyEntity);

  @Query(value = "SELECT * FROM schedule s WHERE s.id_weekly = ?1 AND s.id_recipe=?2 AND s.type=?3 AND s.day=?4", nativeQuery = true)
  ScheduleEntity findScheduleByWeekIdAndRecipeId(Long id_weekly, Long id_recipe, String type, String day);

  @Modifying
  @Query(value = "ALTER TABLE schedule AUTO_INCREMENT = 1", nativeQuery = true)
  void resetAutoIncrement();
}
