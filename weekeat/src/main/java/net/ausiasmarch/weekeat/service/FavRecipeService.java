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
        oSessionService.onlyAdminsOrUsers();
        var fav = oFavRecipeRepository.findById(id_recipe).orElse(new FavRecipeEntity());
        return new FavRecipeDTO(fav.getId(), fav.getId_user(), fav.getId_recipe());
    }

    public Long create(FavRecipeEntity oFavRecipeEntity) {
        oSessionService.onlyAdminsOrUsers();
        return oFavRecipeRepository.save(oFavRecipeEntity).getId();
    }

     public Page<FavRecipeDTO> getPageByUserId(Pageable oPageable, Long id_user) {
        oSessionService.onlyAdminsOrUsers();
        return oFavRecipeRepository.findFavsByUserId(oPageable, id_user).map(FavRecipeDTO::fromFav); 
    }

    public Page<FavRecipeDTO> getPageByUserIdAndRecipeId(Pageable oPageable, Long id_user, Long id_recipe) {
        oSessionService.onlyAdminsOrUsers();
        return oFavRecipeRepository.findFavsByUserIdAndRecipeId(oPageable, id_user, id_recipe).map(FavRecipeDTO::fromFav); 
    }

    public Page<FavRecipeDTO> getPage(Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        return oFavRecipeRepository.findAll(oPageable).map(FavRecipeDTO::fromFav);
    }

    public Long delete(Long id_recipe) {
        oSessionService.onlyAdminsOrUsers();
        oFavRecipeRepository.deleteById(id_recipe);
        return id_recipe;
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oFavRecipeRepository.deleteAll();
        oFavRecipeRepository.resetAutoIncrement();
        oFavRecipeRepository.flush();
        return oFavRecipeRepository.count();
    }
}