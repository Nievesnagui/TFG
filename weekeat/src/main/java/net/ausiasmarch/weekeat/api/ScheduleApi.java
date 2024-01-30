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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.weekeat.api.dto.ScheduleDTO;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.service.ScheduleService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/schedule")
public class ScheduleApi {

    @Autowired
    ScheduleService oScheduleService;

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> get(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oScheduleService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody ScheduleEntity oScheduleEntity) {
        return  ResponseEntity.ok(oScheduleService.create(oScheduleEntity));
    }

    @PutMapping("")
    public ResponseEntity<ScheduleEntity> update(@RequestBody ScheduleEntity oScheduleEntity) {
        return  ResponseEntity.ok(oScheduleService.update(oScheduleEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return  ResponseEntity.ok(oScheduleService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ScheduleEntity>> getPage(Pageable oPageable) {
        return  ResponseEntity.ok(oScheduleService.getPage(oPageable));
    }
    
}
