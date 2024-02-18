package net.ausiasmarch.weekeat.api;

import java.time.LocalDate;

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

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.weekeat.api.dto.WeeklyDTO;
import net.ausiasmarch.weekeat.api.dto.WeeklyWithSchedulesDTO;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;
import net.ausiasmarch.weekeat.repository.WeeklyRepository;
import net.ausiasmarch.weekeat.service.SessionService;
import net.ausiasmarch.weekeat.service.WeeklyService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/weekly")
public class WeeklyApi {

    @Autowired
    WeeklyService oWeeklyService;

    @Autowired
    WeeklyRepository oWeeklyRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    @GetMapping("/{id}")
    public ResponseEntity<WeeklyDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oWeeklyService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody WeeklyEntity oWeeklyEntity) {
        return ResponseEntity.ok(oWeeklyService.create(oWeeklyEntity));
    }

    @PutMapping("")
    public ResponseEntity<WeeklyEntity> update(@RequestBody WeeklyEntity oWeeklyEntity) {
        return ResponseEntity.ok(oWeeklyService.update(oWeeklyEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oWeeklyService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<WeeklyDTO>> getPage(Pageable oPageable,
            @RequestParam(value = "id_user", defaultValue = "", required = false) Long id_user) {
        if (id_user == null) {
            return ResponseEntity.ok(oWeeklyService.getPage(oPageable));
        } else {
            return ResponseEntity.ok(oWeeklyService.getWeeklyByUser(oPageable, id_user));
        }
    }

    @GetMapping("/withSchedules")
    public ResponseEntity<Page<WeeklyWithSchedulesDTO>> getPage(
            @RequestParam(value = "id_user", defaultValue = "", required = true) Long id_user,
            Pageable oPageable) {
        return ResponseEntity.ok(oWeeklyService.getWeeklyWithSchedulesByUser(id_user, oPageable)); 
    }

    @GetMapping("/betweenDates")
    public ResponseEntity<WeeklyDTO> getBetweenDates(
            @RequestParam(value = "start", defaultValue = "", required = true) LocalDate start,
            @RequestParam(value = "end", defaultValue = "", required = true) LocalDate end,
            @RequestParam(value = "id_user", defaultValue = "", required = true) Long id_user) {
                return ResponseEntity.ok(oWeeklyService.getBetweenDates(start, end, id_user));            
            }

}
