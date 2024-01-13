package net.ausiasmarch.weekeat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.service.FavRecipeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fav_recipe")
public class FavRecipeApi {
    
    @Autowired
    FavRecipeService oFavRecipeService;

    @GetMapping("/{id_fav}")
    public ResponseEntity<FavRecipeEntity> get(@PathVariable("id_fav") Long id_fav) {
        return  ResponseEntity.ok(oFavRecipeService.get(id_fav));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody FavRecipeEntity oFavRecipeEntity) {
        return  ResponseEntity.ok(oFavRecipeService.create(oFavRecipeEntity));
    }

    @DeleteMapping("/{id_fav}")
    public ResponseEntity<Long> delete(@PathVariable("id_fav") Long id_fav) {
        return  ResponseEntity.ok(oFavRecipeService.delete(id_fav));
    }

    @GetMapping("")
    public ResponseEntity<Page<FavRecipeEntity>> getPage(Pageable oPageable) {
        return  ResponseEntity.ok(oFavRecipeService.getPage(oPageable));
    }
}
