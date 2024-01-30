package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.entity.RecipeEntity;

public record ContentDTO(Long id, IngredientEntity ingredient, RecipeEntity recipe) {
    
}
