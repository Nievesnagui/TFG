package net.ausiasmarch.weekeat.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.ausiasmarch.weekeat.api.dto.IngredientDTO;
import net.ausiasmarch.weekeat.api.dto.RecipeDTO;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.service.RecipeService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/recipe")
public class RecipeApi {
    @Autowired
    RecipeService oRecipeService;

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oRecipeService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid RecipeEntity oRecipeEntity) {
        return ResponseEntity.ok(oRecipeService.create(oRecipeEntity));
    }

    @PutMapping("")
    public ResponseEntity<RecipeEntity> update(@RequestBody RecipeEntity oRecipeEntity) {
        return ResponseEntity.ok(oRecipeService.update(oRecipeEntity));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oRecipeService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<RecipeDTO>> getPage(Pageable oPageable, 
    @RequestParam(value = "id_user", required = false) Long id_user) {

        if(id_user != null){
            return ResponseEntity.ok(oRecipeService.geRecipesByUser(id_user, oPageable));
        } else{
            return ResponseEntity.ok(oRecipeService.getPage(oPageable, id_user));

        }
    }

     @GetMapping("/byContentFilter")
    public ResponseEntity<Page<RecipeDTO>> getPageByContentFilter(Pageable oPageable, @RequestParam(value = "id_ingredient", required = true)Long id_ingredient ) {
        return ResponseEntity.ok(oRecipeService.getPageByContentFilter(oPageable,id_ingredient));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<RecipeEntity> get(@PathVariable("name") String name) {
        return ResponseEntity.ok(oRecipeService.getByName(name));
    }

}
