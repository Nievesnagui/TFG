package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.FavRecipeRepository;

@Service
public class FavRecipeService {
    
    @Autowired
    FavRecipeRepository oFavRecipeRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public FavRecipeEntity get(Long id_recipe) {
        return oFavRecipeRepository.findById(id_recipe)
            .orElseThrow(() -> new ResourceNotFoundException("FavRecipe not found"));
    }

    public Long create(FavRecipeEntity oFavRecipeEntity) {
        oFavRecipeEntity.setId_fav(null);
        return oFavRecipeRepository.save(oFavRecipeEntity).getId_fav();
    }

    public Page<FavRecipeEntity> getPage(Pageable oPageable) {
        return oFavRecipeRepository.findAll(oPageable);
    }

    public Long delete(Long id_recipe) {
        oFavRecipeRepository.deleteById(id_recipe);
        return id_recipe;
    }

    @Transactional
    public Long empty() {
        oFavRecipeRepository.deleteAll();
        oFavRecipeRepository.resetAutoIncrement();
        oFavRecipeRepository.flush();
        return oFavRecipeRepository.count();
    }
}
