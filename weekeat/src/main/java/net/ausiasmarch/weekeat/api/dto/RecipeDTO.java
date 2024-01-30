package net.ausiasmarch.weekeat.api.dto;

import java.util.List;

import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;

public record RecipeDTO(Long id, String user, String name, String description, byte[] recipe_image, List<ContentEntity> content, List<FavRecipeEntity> favs, List<ScheduleEntity> schedues) {
    
}
