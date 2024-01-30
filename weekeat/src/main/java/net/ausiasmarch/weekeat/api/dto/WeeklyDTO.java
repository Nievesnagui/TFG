package net.ausiasmarch.weekeat.api.dto;

import java.time.LocalDate;
import java.util.List;

import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;

public record WeeklyDTO (Long id, UserEntity user, LocalDate init_date, LocalDate end_date, List<ScheduleEntity> schedules) {
    
}
