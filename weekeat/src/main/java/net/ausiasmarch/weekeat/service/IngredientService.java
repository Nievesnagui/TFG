package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.IngredientDTO;
import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.IngredientRepository;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository oIngredientRepository;

    @Autowired
    TypeService oTypeService;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public /*IngredientEntity*/ IngredientDTO get(Long id) {
        var ingredient = oIngredientRepository.findById(id).orElse(new IngredientEntity());

        ///////
        return new IngredientDTO(ingredient.getId(), ingredient.getId_type(), ingredient.getName(), ingredient.getContent(), ingredient.getContentList());
         //oIngredientRepository.findById(id)
              //.orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
    }

    public IngredientEntity getByName(String name) {
        return oIngredientRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found by name"));
    }

    public Long create(IngredientEntity oIngredientEntity) {
        oSessionService.onlyAdmins();
        oIngredientEntity.setId(null);
        return oIngredientRepository.save(oIngredientEntity).getId();
        // Creo que debería estar sin el getId
    }

    public IngredientEntity update(IngredientEntity oIngredientEntity) {
        oSessionService.onlyAdmins();
        IngredientEntity oIngredientEntity2 = oIngredientRepository.findById(oIngredientEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
        oIngredientEntity2.setName(oIngredientEntity.getName());
        oIngredientEntity2.setId_type(oIngredientEntity.getId_type());
        oIngredientEntity2.setIngredient_image(oIngredientEntity.getIngredient_image());
        return oIngredientRepository.save(oIngredientEntity2);
    }

    public Page<IngredientEntity> getPage(Pageable oPageable/* , Long id_type */) {

        //quiero poner aquí el dto pero no tengo muy claro cómo por el findall

        // if(id_type == null){
        return oIngredientRepository.findAll(oPageable);
        /*
         * } else {
         * return oIngredientRepository.findByIdTypeId(id_type, oPageable);
         * }
         */
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oIngredientRepository.deleteById(id);
        return id;
        // Creo que debería ser como comento abajo:
        /*
         * IngredientEntity oIngredient2 = oIngredientRepository.findById(id)
         * .orElseThrow(() -> new ResourceNotFoundException("No such resource"));
         * oIngredientRepository.deleteById(id);
         * return oIngredient2;
         */
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