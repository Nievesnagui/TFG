package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.ScheduleRepository;

@Service
public class ScheduleService {
    
    @Autowired
    ScheduleRepository oScheduleRepository;

     @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public ScheduleEntity get(Long id_schedule) {
        return oScheduleRepository.findById(id_schedule)
          .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
    }

    public Long create(ScheduleEntity oScheduleEntity) {
        oScheduleEntity.setId_schedule(null);
        return oScheduleRepository.save(oScheduleEntity).getId_schedule();
    }

    public ScheduleEntity update(ScheduleEntity oScheduleEntity) {
        ScheduleEntity oScheduleEntity2 = oScheduleRepository.findById(oScheduleEntity.getId_schedule())
        .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
          oScheduleEntity2.setId_weekly(oScheduleEntity.getId_weekly());
          oScheduleEntity2.setId_recipe(oScheduleEntity.getId_recipe());
          oScheduleEntity2.setType(oScheduleEntity.getType());
          oScheduleEntity2.setDay(oScheduleEntity.getDay());
        return oScheduleRepository.save(oScheduleEntity2);
    }

    public Page<ScheduleEntity> getPage(Pageable oPageable) {
        return oScheduleRepository.findAll(oPageable);
    }

    public Long delete(Long id_schedule) {
        oScheduleRepository.deleteById(id_schedule);
        return id_schedule;
    }

    @Transactional
    public Long empty(){
        oScheduleRepository.deleteAll();
        oScheduleRepository.resetAutoIncrement();
        oScheduleRepository.flush();
        return oScheduleRepository.count();
    }
}