package net.ausiasmarch.weekeat.api.dto;

import java.util.List;

import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.TypeEntity;

public record IngredientDTO(Long id, TypeEntity id_type, String name, Integer content, List<ContentEntity> contentList) {
    //Puedo cambiar el TypeEntity por un String typename (p.ej) y usar solo ese parámetro
}
