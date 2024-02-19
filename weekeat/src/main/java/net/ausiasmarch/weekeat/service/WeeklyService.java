package net.ausiasmarch.weekeat.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.api.dto.WeeklyDTO;
import net.ausiasmarch.weekeat.api.dto.WeeklyWithSchedulesDTO;
import net.ausiasmarch.weekeat.entity.ScheduleEntity;
import net.ausiasmarch.weekeat.entity.WeeklyEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.ScheduleRepository;
import net.ausiasmarch.weekeat.repository.WeeklyRepository;

@Service
public class WeeklyService {
    
    @Autowired
    WeeklyRepository oWeeklyRepository;

    @Autowired
    ScheduleRepository oScheduleRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public WeeklyDTO get(Long id) {
        oSessionService.onlyAdminsOrUsers();
        var weekly = oWeeklyRepository.findById(id).orElse(new WeeklyEntity());
        return new WeeklyDTO(id, weekly.getId_user(), weekly.getInit_date());
    }

    public Long create(WeeklyEntity oWeeklyEntity) {
        oSessionService.onlyAdminsOrUsers();
        oWeeklyEntity.setId(null);
        return oWeeklyRepository.save(oWeeklyEntity).getId();
    }

    public WeeklyEntity update(WeeklyEntity oWeeklyEntity) {
        oSessionService.onlyAdminsOrUsers();
        WeeklyEntity oWeeklyEntity2 = oWeeklyRepository.findById(oWeeklyEntity.getId())
          .orElseThrow(() -> new ResourceNotFoundException("Weekly not found"));
          oWeeklyEntity2.setId_user(oWeeklyEntity.getId_user());
          oWeeklyEntity2.setInit_date(oWeeklyEntity.getInit_date());
        return oWeeklyRepository.save(oWeeklyEntity2);
    }

    public Page<WeeklyDTO> getPage(Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        return oWeeklyRepository.findAll(oPageable)
                    .map(weekly -> mapWeeklyDTO(weekly)); 
    }

    private WeeklyDTO mapWeeklyDTO(WeeklyEntity weekly){
        oSessionService.onlyAdminsOrUsers();
        return new WeeklyDTO(weekly.getId(), weekly.getId_user(), weekly.getInit_date());
    }

    public Page<WeeklyDTO> getWeeklyByUser(Pageable oPageable, Long id_user) {
        oSessionService.onlyAdminsOrUsers();
      return filterWeekly(oPageable, id_user);
    }

    public Page<WeeklyWithSchedulesDTO> getWeeklyWithSchedulesByUser( Long id_user,Pageable oPageable) {
        oSessionService.onlyAdminsOrUsers();
        return oWeeklyRepository.findWeeklyWithSchedulesByUser(id_user, oPageable).map(WeeklyWithSchedulesDTO::fromWeekly);
      }

      public WeeklyDTO getBetweenDates(LocalDate start, LocalDate end, Long id_user) {
        oSessionService.onlyAdminsOrUsers();
        var weekly = oWeeklyRepository.findBetweenDates(start, end, id_user);
        return new WeeklyDTO(weekly.getId(), weekly.getId_user(), weekly.getInit_date());
      }

    public Page<WeeklyDTO> filterWeekly(Pageable oPageable, Long id_user){
        oSessionService.onlyAdminsOrUsers();
          List<WeeklyDTO> result = oWeeklyRepository.findAll().stream()
        .filter( weekly -> 
        {
            var user = weekly.getId_user();
            if(user != null){
                return weekly.getId_user().getId().equals(id_user);
            }else {
                return false;
            }
        })
        .map(WeeklyDTO::fromWeekly).collect(Collectors.toList());

        return new PageImpl<>(result, oPageable, result.size());
    }

    public Long delete(Long id) {
        oSessionService.onlyAdminsOrUsers();
        WeeklyEntity weekly = oWeeklyRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Could not find weekly"));
        oWeeklyRepository.deleteById(id);
        for (ScheduleEntity schedule: weekly.getSchedulesList()){
            oScheduleRepository.delete(schedule);
        }

        return id;
    }

    @Transactional
    public Long empty(){
        oSessionService.onlyAdmins();
        oWeeklyRepository.deleteAll();
        oWeeklyRepository.resetAutoIncrement();
        oWeeklyRepository.flush();
        return oWeeklyRepository.count();
    }
    
}