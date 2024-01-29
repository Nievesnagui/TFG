package net.ausiasmarch.weekeat.api;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import net.ausiasmarch.weekeat.entity.IngredientEntity;
import net.ausiasmarch.weekeat.service.IngredientService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/ingredient")
public class IngredientApi {
    
    @Autowired
    IngredientService oIngredientService;

    @GetMapping("/{id}")
    public ResponseEntity<IngredientEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oIngredientService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid IngredientEntity oIngredientEntity) {
        return ResponseEntity.ok(oIngredientService.create(oIngredientEntity));
    }

    @PutMapping("")
    public ResponseEntity<IngredientEntity> update(@RequestBody IngredientEntity oIngredientEntity) {
        return ResponseEntity.ok(oIngredientService.update(oIngredientEntity));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oIngredientService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<IngredientEntity>> getPage(Pageable oPageable/*,
    @RequestParam(value = "id_type", required = false) Long id_type*/) {
        return ResponseEntity.ok(oIngredientService.getPage(oPageable/*, id_type*/));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<IngredientEntity> get(@PathVariable("name") String name) {
        return ResponseEntity.ok(oIngredientService.getByName(name));
    }
    
}
