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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.ausiasmarch.weekeat.entity.RecipeEntity;
import net.ausiasmarch.weekeat.service.RecipeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recipe")
public class RecipeApi {
    @Autowired
    RecipeService oRecipeService;

    @GetMapping("/{id_recipe}")
    public ResponseEntity<RecipeEntity> get(@PathVariable("id_recipe") Long id_recipe) {
        return ResponseEntity.ok(oRecipeService.get(id_recipe));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid RecipeEntity oRecipeEntity) {
        return ResponseEntity.ok(oRecipeService.create(oRecipeEntity));
    }

    @PutMapping("")
    public ResponseEntity<RecipeEntity> update(@RequestBody RecipeEntity oRecipeEntity) {
        return ResponseEntity.ok(oRecipeService.update(oRecipeEntity));

    }

    @DeleteMapping("/{id_recipe}")
    public ResponseEntity<Long> delete(@PathVariable("id_recipe") Long id_recipe) {
        return ResponseEntity.ok(oRecipeService.delete(id_recipe));
    }

    @GetMapping("")
    public ResponseEntity<Page<RecipeEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oRecipeService.getPage(oPageable));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<RecipeEntity> get(@PathVariable("name") String name) {
        return ResponseEntity.ok(oRecipeService.getByName(name));
    }

}
