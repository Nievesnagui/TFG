package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.FavRecipeDTO;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.repository.FavRecipeRepository;

@Service
public class FavRecipeService {
    
    @Autowired
    FavRecipeRepository oFavRecipeRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public FavRecipeDTO get(Long id_recipe) {
        var fav = oFavRecipeRepository.findById(id_recipe).orElse(new FavRecipeEntity());
        return new FavRecipeDTO(fav.getId(), fav.getId_user(), fav.getId_recipe());
    }

    public Long create(FavRecipeEntity oFavRecipeEntity) {
        return oFavRecipeRepository.save(oFavRecipeEntity).getId();
    }

     public Page<FavRecipeDTO> getPageByUserId(Pageable oPageable, Long id_user) {
        return oFavRecipeRepository.findFavsByUserId(oPageable, id_user).map(FavRecipeDTO::fromFav); 
    }

    public Page<FavRecipeDTO> getPageByUserIdAndRecipeId(Pageable oPageable, Long id_user, Long id_recipe) {
        return oFavRecipeRepository.findFavsByUserIdAndRecipeId(oPageable, id_user, id_recipe).map(FavRecipeDTO::fromFav); 
    }

    public Page<FavRecipeDTO> getPage(Pageable oPageable) {
        return oFavRecipeRepository.findAll(oPageable).map(FavRecipeDTO::fromFav);
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