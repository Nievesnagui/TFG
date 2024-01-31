package net.ausiasmarch.weekeat.api.dto;

import java.time.LocalDate;
import java.util.List;

import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public record WeeklyDTO(Long id, UserEntity user, LocalDate init_date, LocalDate end_date,
        List<ScheduleEntity> schedules) {
    public static WeeklyDTO fromWeekly(WeeklyEntity weekly){
        return new WeeklyDTO(weekly.getId(), weekly.getId_user(), weekly.getInit_date(), weekly.getEnd_date(), weekly.getSchedulesList());
    }
}
