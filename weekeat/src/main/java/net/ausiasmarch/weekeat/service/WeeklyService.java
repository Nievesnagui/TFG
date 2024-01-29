package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.WeeklyRepository;

@Service
public class WeeklyService {
    
    @Autowired
    WeeklyRepository oWeeklyRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public WeeklyEntity get(Long id) {
        return oWeeklyRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Weekly not found"));
    }

    public Long create(WeeklyEntity oWeeklyEntity) {
        oWeeklyEntity.setId(null);
        return oWeeklyRepository.save(oWeeklyEntity).getId();
    }

    public WeeklyEntity update(WeeklyEntity oWeeklyEntity) {
        WeeklyEntity oWeeklyEntity2 = oWeeklyRepository.findById(oWeeklyEntity.getId())
          .orElseThrow(() -> new ResourceNotFoundException("Weekly not found"));
          oWeeklyEntity2.setId_user(oWeeklyEntity.getId_user());
          oWeeklyEntity2.setInit_date(oWeeklyEntity.getInit_date());
          oWeeklyEntity2.setEnd_date(oWeeklyEntity.getEnd_date());
        return oWeeklyRepository.save(oWeeklyEntity2);
    }

    public Page<WeeklyEntity> getPage(Pageable oPageable) {
        return oWeeklyRepository.findAll(oPageable);
    }

    public Long delete(Long id) {
        oWeeklyRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty(){
        oWeeklyRepository.deleteAll();
        oWeeklyRepository.resetAutoIncrement();
        oWeeklyRepository.flush();
        return oWeeklyRepository.count();
    }
    
}