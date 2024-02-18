package net.ausiasmarch.weekeat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.RecipeDTO;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.ContentRepository;
import net.ausiasmarch.weekeat.repository.FavRecipeRepository;
import net.ausiasmarch.weekeat.repository.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository oRecipeRepository;

    @Autowired
    ContentRepository cContentRepository;

    @Autowired
    FavRecipeRepository oFavRecipeRepository;

    @Autowired
    ContentService oContentService;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public RecipeDTO get(Long id) {
        var recipe = oRecipeRepository.findById(id).orElse(new RecipeEntity());
        return RecipeDTO.fromRecipe(recipe);
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
        oRecipeEntity2.setProcess(oRecipeEntity.getProcess());
        oRecipeEntity.setId_user(oRecipeEntity.getId_user());
        return oRecipeRepository.save(oRecipeEntity2);
    }

    public Page<RecipeDTO> getPage(Pageable oPageable) {
        return oRecipeRepository.findAll(oPageable)
                .map(RecipeDTO::fromRecipe);
    }
    public Page<RecipeDTO> getPageByContentFilter(String searchText, Pageable pageable) {
        Page<Object[]> results = oRecipeRepository.findByNameIgnoringCase(searchText, pageable);
        List<RecipeDTO> dtos = results.stream()
            .map(row -> new RecipeDTO(
                (Long) row[0], // id
                null, // id_user - Puedes establecerlo en null ya que no se selecciona en la consulta
                (String) row[1], // name
                (String) row[2], // description
                (String) row[3], // recipe_image
                (String) row[4], // process
                null, // content - No está seleccionado en la consulta
                null, // favs - No está seleccionado en la consulta
                null, // schedules - No está seleccionado en la consulta
                false, // hasIngredient - Puedes establecerlo en false por defecto
                false
            ))
            .collect(Collectors.toList());
        return new PageImpl<>(dtos, pageable, results.getTotalElements());
    }
    public Page<RecipeDTO> geRecipesByUser(Long id_user, Pageable oPageable) {
        return filterRecipe(id_user, oPageable);
    }

    private Page<RecipeDTO> filterRecipe(Long id_user, Pageable oPageable) {

        if (id_user == null) {
            return oRecipeRepository.findAll(oPageable).map(RecipeDTO::fromRecipe);
        } else {
            List<RecipeDTO> resultadoFiltro = oRecipeRepository.findAll().stream()
                    .filter(recipe -> recipe.getId_user().getId().equals(id_user))
                    .map(RecipeDTO::fromRecipe)
                    .collect(Collectors.toList());

            return new PageImpl<>(resultadoFiltro, oPageable, resultadoFiltro.size());
        }

    }

    @Autowired
    private EntityManager entityManager;

    public Page<RecipeDTO> getPageByContentFilter(Pageable pageable, Long id_ingredient) {
        String queryString = "SELECT r FROM RecipeEntity r JOIN r.content c WHERE c.id_ingredient.id = :id_ingredient";
        TypedQuery<RecipeEntity> query = entityManager.createQuery(queryString, RecipeEntity.class);
        query.setParameter("id_ingredient", id_ingredient);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        Page<RecipeEntity> page = new PageImpl<>(query.getResultList(), pageable,
                countRecipesWithIngredient(id_ingredient));
        return page.map(RecipeDTO::fromRecipe);
    }

    private long countRecipesWithIngredient(Long id_ingredient) {
        String countQueryString = "SELECT COUNT(r) FROM RecipeEntity r JOIN r.content c WHERE c.id_ingredient.id = :id_ingredient";
        TypedQuery<Long> countQuery = entityManager.createQuery(countQueryString, Long.class);
        countQuery.setParameter("id_ingredient", id_ingredient);
        return countQuery.getSingleResult();
    }

    public Long delete(Long id) {
        RecipeEntity recipe = oRecipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
        oRecipeRepository.deleteById(id);
        for (ContentEntity content : recipe.getContent()) {
            cContentRepository.delete(content);
        }
        for (FavRecipeEntity fav : recipe.getFavs()) {
            oFavRecipeRepository.delete(fav);
        }
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