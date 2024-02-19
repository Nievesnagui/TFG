package net.ausiasmarch.weekeat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.ScheduleDTO;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.ScheduleRepository;

import org.modelmapper.ModelMapper;

@Service
public class ScheduleService {
    
    @Autowired
    ScheduleRepository oScheduleRepository;

     @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    //Prueba
    @Autowired
    private ModelMapper modelMapper;

    public ScheduleDTO get(Long id) {
        oSessionService.onlyAdminsOrUsers();
        var schedule = oScheduleRepository.findById(id).orElse(new ScheduleEntity());
        return new ScheduleDTO(schedule.getId(), schedule.getId_weekly(), schedule.getId_recipe(), schedule.getType(), schedule.getDay());
    }

    public Long create(ScheduleEntity oScheduleEntity) {
        oSessionService.onlyAdminsOrUsers();
        oScheduleEntity.setId(null);
        return oScheduleRepository.save(oScheduleEntity).getId();
    }

    public ScheduleEntity update(ScheduleEntity oScheduleEntity) {
        oSessionService.onlyAdminsOrUsers();
        ScheduleEntity oScheduleEntity2 = oScheduleRepository.findById(oScheduleEntity.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
          oScheduleEntity2.setId_weekly(oScheduleEntity.getId_weekly());
          oScheduleEntity2.setId_recipe(oScheduleEntity.getId_recipe());
          oScheduleEntity2.setType(oScheduleEntity.getType());
          oScheduleEntity2.setDay(oScheduleEntity.getDay());
        return oScheduleRepository.save(oScheduleEntity2);
    }

    public Page<ScheduleDTO> getPage(Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        return oScheduleRepository.findAll(oPageable).map(ScheduleDTO::fromSchedule);
    }
    public Page<ScheduleDTO> getPageByWeekly(Pageable oPageable, Long id_weekly) {
        oSessionService.onlyAdminsOrUsers();
        return filterByWeekly(id_weekly, oPageable); 
    }

    public Page<ScheduleDTO> getPageByUserId(Long id_user, Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        return oScheduleRepository.findSchedulesByUserId(oPageable,id_user ).map(ScheduleDTO::fromSchedule); 
    }

    private Page<ScheduleDTO> filterByWeekly(Long id_weekly, Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        if(id_weekly == null) {
        return oScheduleRepository.findAll(oPageable).map(ScheduleDTO::fromSchedule);
        } else {
            List<ScheduleDTO> resultadoFiltro =  oScheduleRepository.findAll().stream()
            .filter(schedule -> schedule.getId_weekly().getId().equals(id_weekly))
            .map(ScheduleDTO::fromSchedule)
            .collect(Collectors.toList());
            return new PageImpl<>(resultadoFiltro, oPageable, resultadoFiltro.size());
        }
    }

    public ScheduleDTO[] getScheduleByWeekly(WeeklyEntity id_weekly) {
        oSessionService.onlyAdminsOrUsers();
        List<ScheduleDTO> scheduleEntities = oScheduleRepository.findSchedulesArrayByWeeklyId(id_weekly);
        ScheduleDTO[] scheduleDTOs = new ScheduleDTO[scheduleEntities.size()];
        for (int i = 0; i < scheduleEntities.size(); i++) {
            scheduleDTOs[i] = modelMapper.map(scheduleEntities.get(i), ScheduleDTO.class);
        }
        return scheduleDTOs;
    }
    public ScheduleDTO getScheduleByWeekIdAndRecipeId(Long id_weekly, Long id_recipe, String type, String day) {
        oSessionService.onlyAdminsOrUsers();
        var schedule = oScheduleRepository.findScheduleByWeekIdAndRecipeId(id_weekly, id_recipe, type, day);
        return ScheduleDTO.fromSchedule(schedule);
    }

    public Long delete(Long id) {
        oSessionService.onlyAdminsOrUsers();
        oScheduleRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty(){
        oSessionService.onlyAdmins();
        oScheduleRepository.deleteAll();
        oScheduleRepository.resetAutoIncrement();
        oScheduleRepository.flush();
        return oScheduleRepository.count();
    }
}