package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.IngredientRepository;

@Service
public class IngredientService {
    
    @Autowired
    IngredientRepository oIngredientRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public IngredientEntity get(Long id_ingredient) {
        return oIngredientRepository.findById(id_ingredient)
              .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
    }

    public IngredientEntity getByName(String name) {
        return oIngredientRepository.findByName(name)
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found by name"));
    }

    public Long create(IngredientEntity oIngredientEntity) {
        oSessionService.onlyAdmins();
        oIngredientEntity.setId_ingredient(null);
        return oIngredientRepository.save(oIngredientEntity).getId_ingredient();
    }

    public IngredientEntity update(IngredientEntity oIngredientEntity) {
        oSessionService.onlyAdmins();
        IngredientEntity oIngredientEntity2 = oIngredientRepository.findById(oIngredientEntity.getId_ingredient())
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
        oIngredientEntity2.setName(oIngredientEntity.getName());
        oIngredientEntity2.setId_type(oIngredientEntity.getId_type());
        oIngredientEntity2.setIngredient_image(oIngredientEntity.getIngredient_image());
        return oIngredientRepository.save(oIngredientEntity2);
    }

    public Page<IngredientEntity> getPage(Pageable oPageable) {
        return oIngredientRepository.findAll(oPageable);
    }

    public Long delete(Long id_ingredient) {
        oSessionService.onlyAdmins();
        oIngredientRepository.deleteById(id_ingredient);
        return id_ingredient;
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oIngredientRepository.deleteAll();
        oIngredientRepository.resetAutoIncrement();
        oIngredientRepository.flush();
        return oIngredientRepository.count();
    }
}