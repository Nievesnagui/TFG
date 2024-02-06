package net.ausiasmarch.weekeat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.ContentDTO;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.repository.ContentRepository;
import net.ausiasmarch.weekeat.repository.RecipeRepository;

@Service
public class ContentService {

    @Autowired
    ContentRepository oContentRepository;

    @Autowired
    RecipeRepository oRecipeRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public ContentDTO get(Long id) {
        var content = oContentRepository.findById(id).orElse(new ContentEntity());
        return new ContentDTO(content.getId(), content.getId_ingredient(), content.getId_recipe());
    }

    public Long create(ContentEntity oContentEntity) {
        return oContentRepository.save(oContentEntity).getId();
    }

    public Page<ContentDTO> getPage(Pageable oPageable, Long id_recipe, Long id_ingredient) {
        return oContentRepository.findAll(oPageable)
                .map(content -> mapToContentDTO(content));
    }

    private ContentDTO mapToContentDTO(ContentEntity content) {
        return new ContentDTO(content.getId(), content.getId_ingredient(), content.getId_recipe());
    }

    public Long delete(Long id) {
        oContentRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty() {
        oContentRepository.deleteAll();
        oContentRepository.resetAutoIncrement();
        oContentRepository.flush();
        return oContentRepository.count();
    }

    public Page<ContentDTO> getContentsByRecipe(Long id_recipe, Pageable oPageable) {
        return filterContent(oPageable, id_recipe, null);
    }

    public Page<ContentDTO> getContentsByIngredient(Long id_ingredient, Pageable oPageable) {
        return filterContent(oPageable, null, id_ingredient);
    }

    private Page<ContentDTO> filterContent(Pageable oPageable, Long id_recipe, Long id_ingredient) {
        if (id_ingredient == null) {
            if (id_recipe == null) {
                return oContentRepository.findAll(oPageable).map(ContentDTO::fromContent);
            } else {
                List<ContentDTO> resultadoFiltro = oContentRepository.findAll().stream()
                        .filter(content -> 
                        {
                            var recipe = content.getId_recipe();
                            if(recipe != null){
                                return content.getId_recipe().getId().equals(id_recipe);
                            } else{
                                return false;
                            }
                           
                        })
                        .map(ContentDTO::fromContent)
                        .collect(Collectors.toList());
                        
    
                return new PageImpl<>(resultadoFiltro, oPageable, resultadoFiltro.size());
            }
        } else {
            List<ContentDTO> resultadoFiltro = oContentRepository.findAll().stream()
                    .filter(content -> content.getId_ingredient().getId().equals(id_ingredient))
                    .map(ContentDTO::fromContent)
                    .collect(Collectors.toList());
    
            return new PageImpl<>(resultadoFiltro, oPageable, resultadoFiltro.size());
        }
    }
    

}