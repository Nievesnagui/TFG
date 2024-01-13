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
import net.ausiasmarch.weekeat.entity.ContentEntity;
import net.ausiasmarch.weekeat.service.ContentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/content")
public class ContentApi {
    
    @Autowired
    ContentService oContentService;

    @GetMapping("/{content_id}")
    public ResponseEntity<ContentEntity> get(@PathVariable("content_id") Long id_content) {
        return  ResponseEntity.ok(oContentService.get(id_content));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ContentEntity oContentEntity) {
        return  ResponseEntity.ok(oContentService.create(oContentEntity));
    }   

    @DeleteMapping("/{content_id}")
    public ResponseEntity<Long> delete(@PathVariable("content_id") Long id_content) {
        return  ResponseEntity.ok(oContentService.delete(id_content));
    }

    @GetMapping("")
    public ResponseEntity<Page<ContentEntity>> getPage(Pageable oPageable) {
        return  ResponseEntity.ok(oContentService.getPage(oPageable));
    }
}
