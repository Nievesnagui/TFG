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

import net.ausiasmarch.weekeat.api.dto.WeeklyDTO;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;
import net.ausiasmarch.weekeat.service.WeeklyService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/weekly")
public class WeeklyApi {
    
    @Autowired
    WeeklyService oWeeklyService;

    @GetMapping("/{id}")
    public ResponseEntity<WeeklyDTO> get(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oWeeklyService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody WeeklyEntity oWeeklyEntity) {
        return  ResponseEntity.ok(oWeeklyService.create(oWeeklyEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oWeeklyService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<WeeklyEntity>> getPage(Pageable oPageable) {
        return  ResponseEntity.ok(oWeeklyService.getPage(oPageable));
    }
}
