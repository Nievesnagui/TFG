package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;

public record FavRecipeDTO (
    Long id,
    UserEntity user,
    RecipeEntity recipe
) {
    
}
