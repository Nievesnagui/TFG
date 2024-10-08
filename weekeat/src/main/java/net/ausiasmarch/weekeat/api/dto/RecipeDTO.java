package net.ausiasmarch.weekeat.api.dto;

import java.util.List;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;

public record RecipeDTO(Long id, UserEntity id_user, String name, String description, String recipe_image,
                String process,
                List<ContentDTO> content, List<FavRecipeDTO> favs, List<ScheduleEntity> schedules,
                Boolean hasIngredient, Boolean isFavourite) {

        public static RecipeDTO fromRecipeWithIngredient(RecipeEntity recipe, boolean hasIngredient) {
                return new RecipeDTO(recipe.getId(), recipe.getId_user(), recipe.getName(), recipe.getDescription(),
                                recipe.getRecipe_image(), recipe.getProcess(),
                                recipe.getContent().stream().map(ContentDTO::fromContent).toList(),
                                recipe.getFavs().stream().map(FavRecipeDTO::fromFav).toList(),
                                recipe.getSchedulesList(), hasIngredient, false);
        }

        public static RecipeDTO fromRecipeFavourite(RecipeEntity recipe, boolean isFavourite) {
                return new RecipeDTO(recipe.getId(), recipe.getId_user(), recipe.getName(), recipe.getDescription(),
                                recipe.getRecipe_image(), recipe.getProcess(),
                                recipe.getContent().stream().map(ContentDTO::fromContent).toList(),
                                recipe.getFavs().stream().map(FavRecipeDTO::fromFav).toList(),
                                recipe.getSchedulesList(), false, isFavourite);
        }

        public static RecipeDTO fromRecipe(RecipeEntity recipe) {
                return new RecipeDTO(recipe.getId(), recipe.getId_user(), recipe.getName(), recipe.getDescription(),
                                recipe.getRecipe_image(), recipe.getProcess(),
                                recipe.getContent().stream().map(ContentDTO::fromContent).toList(),
                                recipe.getFavs().stream().map(FavRecipeDTO::fromFav).toList(),
                                recipe.getSchedulesList(), false, false);
        }
}
