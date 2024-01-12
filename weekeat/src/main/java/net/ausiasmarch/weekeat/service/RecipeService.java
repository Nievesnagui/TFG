package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
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

    public RecipeEntity get(Long id_recipe) {
        return oRecipeRepository.findById(id_recipe)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
    }

    public RecipeEntity getByRecipeName(String name) {
        return oRecipeRepository.findByRecipeName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found by name"));
    }

    public Long create(RecipeEntity oRecipeEntity) {
        oRecipeEntity.setId_user(null);
        return oRecipeRepository.save(oRecipeEntity).getId_recipe();
    }

    public RecipeEntity update(RecipeEntity oRecipeEntity) {
        RecipeEntity oRecipeEntity2 = oRecipeRepository.findById(oRecipeEntity.getId_recipe())
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

    public Long delete(Long id_recipe) {
        oRecipeRepository.deleteById(id_recipe);
        return id_recipe;
    }

    @Transactional
    public Long empty() {
        oRecipeRepository.deleteAll();
        oRecipeRepository.resetAutoIncrement();
        oRecipeRepository.flush();
        return oRecipeRepository.count();
    }
}
