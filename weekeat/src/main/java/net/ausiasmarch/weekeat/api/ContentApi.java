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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.weekeat.api.dto.ContentDTO;
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.service.ContentService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/content")
public class ContentApi {
    
    @Autowired
    ContentService oContentService;

    @GetMapping("/{id}")
    public ResponseEntity<ContentDTO> get(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oContentService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ContentEntity oContentEntity) {
        return  ResponseEntity.ok(oContentService.create(oContentEntity));
    }   

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oContentService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ContentDTO>> getPage(Pageable oPageable,
                           @RequestParam(value = "id_ingredient", defaultValue = "", required = false) Long id_ingredient,
                           @RequestParam(value = "id_recipe", defaultValue = "", required = false) Long id_recipe) {
    
        if (id_recipe != null) {
            return ResponseEntity.ok(oContentService.getContentsByRecipe(id_recipe, oPageable));
        } else if (id_ingredient != null) {
            return ResponseEntity.ok(oContentService.getContentsByIngredient(id_ingredient, oPageable));
        } else {
            return ResponseEntity.ok(oContentService.getPage(oPageable, null, null)); // Obtener todos los contenidos
        }
    }
}
