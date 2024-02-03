package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.entity.RecipeEntity;

public record ContentDTO(Long id, IngredientEntity ingredient, RecipeEntity recipe) {
    public static ContentDTO fromContent(ContentEntity content) {
        return new ContentDTO(content.getId(), 
        content.getId_ingredient(), 
        content.getId_recipe());
    }
}
