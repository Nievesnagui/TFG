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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/type")
public class TypeApi {
    
    @Autowired
    TypeService oTypeService;

    @GetMapping("/{id_type}")
    public ResponseEntity<TypeEntity> get(@PathVariable("id_type") Long id_type) {
        return ResponseEntity.ok(oTypeService.get(id_type));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid TypeEntity oTypeEntity) {
        return ResponseEntity.ok(oTypeService.create(oTypeEntity));
    }

    @PutMapping("")
    public ResponseEntity<TypeEntity> update(@RequestBody TypeEntity oTypeEntity) {
        return ResponseEntity.ok(oTypeService.update(oTypeEntity));

    }

    @DeleteMapping("/{id_type}")
    public ResponseEntity<Long> delete(@PathVariable("id_type") Long id_type) {
        return ResponseEntity.ok(oTypeService.delete(id_type));
    }

    @GetMapping("")
    public ResponseEntity<Page<TypeEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oTypeService.getPage(oPageable));
    }
}
