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

    public TypeEntity get(Long id_type) {
        return oTypeRepository.findById(id_type)
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
        return oTypeRepository.save(oTypeEntity).getId_type();
    }

    public TypeEntity update(TypeEntity oTypeEntity) {
        TypeEntity oTypeEntity2 = oTypeRepository.findById(oTypeEntity.getId_type())
              .orElseThrow(() -> new ResourceNotFoundException("Type not found"));
        oTypeEntity2.setName(oTypeEntity.getName());
        return oTypeRepository.save(oTypeEntity2);
    }

    public Long delete(Long id_type) {
        oTypeRepository.deleteById(id_type);
        return id_type;
    }

    @Transactional
    public Long empty() {
        oTypeRepository.deleteAll();
        return oTypeRepository.count();
    }

   
}
