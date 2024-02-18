package net.ausiasmarch.weekeat.api.dto;

import java.time.LocalDate;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public record WeeklyDTO(Long id, UserEntity user, LocalDate init_date) {
    public static WeeklyDTO fromWeekly(WeeklyEntity weekly) {
        return new WeeklyDTO(weekly.getId(), weekly.getId_user(), weekly.getInit_date());
    }
}
