package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;

public record ScheduleDTO(Long id, WeeklyEntity weekly, RecipeEntity recipe, String type, String day) {
    public static ScheduleDTO fromSchedule(ScheduleEntity schedule){
        if(schedule != null) {
            return new ScheduleDTO(schedule.getId(), schedule.getId_weekly(), schedule.getId_recipe(), schedule.getType(), schedule.getDay());
        } else{
            return new ScheduleDTO(0l, null, null, "", "");
        }
    }
    
}
