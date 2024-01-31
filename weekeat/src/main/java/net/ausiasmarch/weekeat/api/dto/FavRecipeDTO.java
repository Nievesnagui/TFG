package net.ausiasmarch.weekeat.api.dto;

import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;

public record FavRecipeDTO (
    Long id,
    UserEntity user,
    RecipeEntity recipe
) {
    public static FavRecipeDTO fromFav(FavRecipeEntity fav){
        return new FavRecipeDTO(fav.getId(), fav.getId_user(), fav.getId_recipe());
    }
}
