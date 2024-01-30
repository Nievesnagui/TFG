package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.RecipeDTO;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository oRecipeRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public RecipeDTO get(Long id) {
        var recipe = oRecipeRepository.findById(id).orElse(new RecipeEntity());
        return new RecipeDTO(recipe.getId(), recipe.getId_user().getUsername(), recipe.getName(), recipe.getDescription(), recipe.getRecipe_image(), recipe.getContent(), recipe.getFavs(), recipe.getSchedulesList());
    }

    public RecipeEntity getByName(String name) {
        return oRecipeRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found by name"));
    }

    public Long create(RecipeEntity oRecipeEntity) {
        return oRecipeRepository.save(oRecipeEntity).getId();
    }

    public RecipeEntity update(RecipeEntity oRecipeEntity) {
        RecipeEntity oRecipeEntity2 = oRecipeRepository.findById(oRecipeEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
        oRecipeEntity2.setName(oRecipeEntity.getName());
        oRecipeEntity2.setDescription(oRecipeEntity.getDescription());
        oRecipeEntity2.setRecipe_image(oRecipeEntity.getRecipe_image());
        oRecipeEntity.setId_user(oRecipeEntity.getId_user());
        return oRecipeRepository.save(oRecipeEntity2);
    }

    public Page<RecipeEntity> getPage(Pageable oPageable) {
        return oRecipeRepository.findAll(oPageable);
    }

    public Long delete(Long id) {
        oRecipeRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty() {
        oRecipeRepository.deleteAll();
        oRecipeRepository.resetAutoIncrement();
        oRecipeRepository.flush();
        return oRecipeRepository.count();
    }
}