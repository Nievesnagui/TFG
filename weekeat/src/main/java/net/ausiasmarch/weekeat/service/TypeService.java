package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.TypeEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.TypeRepository;
import net.ausiasmarch.weekeat.repository.UserRepository;

@Service
public class TypeService {

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    TypeRepository oTypeRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    public TypeEntity get(Long id) {
        return oTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
    }

    public TypeEntity getByTypeName(String name) {
        return oTypeRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found by name"));
    }

    public Page<TypeEntity> getPage(Pageable oPageable) {
        return oTypeRepository.findAll(oPageable);
    }

    public Long create(TypeEntity oTypeEntity) {
        oSessionService.onlyAdmins();
        return oTypeRepository.save(oTypeEntity).getId();
    }

    public TypeEntity update(TypeEntity oTypeEntity) {
        oSessionService.onlyAdmins();
        TypeEntity oTypeEntity2 = oTypeRepository.findById(oTypeEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
        oTypeEntity2.setName(oTypeEntity.getName());
        return oTypeRepository.save(oTypeEntity2);
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oTypeRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oTypeRepository.deleteAll();
        return oTypeRepository.count();
    }

    public Long populate() {
        oTypeRepository.save(new TypeEntity("Dairy"));
        oTypeRepository.save(new TypeEntity("Meat"));
        oTypeRepository.save(new TypeEntity("Meat Product"));
        oTypeRepository.save(new TypeEntity("Fish"));
        oTypeRepository.save(new TypeEntity("Fruit"));
        oTypeRepository.save(new TypeEntity("Vegetable"));
        oTypeRepository.save(new TypeEntity("Grain"));
        oTypeRepository.save(new TypeEntity("Oil"));
        oTypeRepository.save(new TypeEntity("Fat"));
        oTypeRepository.save(new TypeEntity("Sweets"));
        oTypeRepository.save(new TypeEntity("Grain Product"));
        oTypeRepository.save(new TypeEntity("Legume"));
        oTypeRepository.save(new TypeEntity("Nut"));



        return oTypeRepository.count();

    }

}