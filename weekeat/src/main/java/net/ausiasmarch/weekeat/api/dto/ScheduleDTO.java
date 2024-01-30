package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public record ScheduleDTO(Long id, WeeklyEntity weekly, RecipeEntity recipe, String type, String day) {
    
}
