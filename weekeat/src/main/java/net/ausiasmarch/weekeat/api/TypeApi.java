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
import net.ausiasmarch.weekeat.entity.TypeEntity;
import net.ausiasmarch.weekeat.service.TypeService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/type")
public class TypeApi {
    
    @Autowired
    TypeService oTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<TypeEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oTypeService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid TypeEntity oTypeEntity) {
        return ResponseEntity.ok(oTypeService.create(oTypeEntity));
    }

    @PutMapping("")
    public ResponseEntity<TypeEntity> update(@RequestBody TypeEntity oTypeEntity) {
        return ResponseEntity.ok(oTypeService.update(oTypeEntity));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oTypeService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<TypeEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oTypeService.getPage(oPageable));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<TypeEntity> get(@PathVariable("name") String name) {
        return ResponseEntity.ok(oTypeService.getByTypeName(name));
    }
}
