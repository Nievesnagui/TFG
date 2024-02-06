package net.ausiasmarch.weekeat.api.dto;

import java.util.List;

import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.entity.TypeEntity;

public record IngredientDTO(Long id, TypeEntity id_type, String name, Integer content,
        List<ContentEntity> contentList, Boolean isInContent) {
    // Puedo cambiar el TypeEntity por un String typename (p.ej) y usar solo ese
    // parámetro
    public static IngredientDTO fromIngredient(IngredientEntity ingredient) {
        return fromIngredient(ingredient, false);
    }

    public static IngredientDTO fromIngredient(IngredientEntity ingredient,Boolean isInContent) {
        return new IngredientDTO(ingredient.getId(), ingredient.getId_type(), ingredient.getName(),
        ingredient.getContent(), ingredient.getContentList(), isInContent);
    }
}
