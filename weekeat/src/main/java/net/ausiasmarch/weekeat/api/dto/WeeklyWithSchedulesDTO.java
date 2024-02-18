package net.ausiasmarch.weekeat.api.dto;

import java.time.LocalDate;
import java.util.List;

import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public record WeeklyWithSchedulesDTO(Long id, UserEntity user, LocalDate init_date, List<ScheduleEntity> schedules) {
 
    public static WeeklyWithSchedulesDTO fromWeekly(WeeklyEntity weekly) {
        return new WeeklyWithSchedulesDTO(weekly.getId(), weekly.getId_user(), weekly.getInit_date(), weekly.getSchedulesList());
    }
    
}
