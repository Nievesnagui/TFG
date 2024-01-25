package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SessionService oSessionService;

    /*
     * @Autowired
     * EmailService oEmailService;
     */
    private final String genericPasswd = "c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261";

    public UserEntity get(Long id) {
        return oUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserEntity getByUsername(String username) {
        return oUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by username"));
    }

   public Page<UserEntity> getPage(Pageable oPageable) {
        return oUserRepository.findAll(oPageable);
    }

    public Long create(UserEntity oUserEntity) {
        oSessionService.onlyAdmins();
        oUserEntity.setId(null);
        oUserEntity.setPassword(genericPasswd);
        return oUserRepository.save(oUserEntity).getId();
    }

    public UserEntity update(UserEntity oUserEntity) {
        UserEntity oUserEntityAux = oUserRepository.findById(oUserEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        oUserEntityAux.setName(oUserEntity.getName());
        oUserEntityAux.setSurname(oUserEntity.getSurname());
        oUserEntityAux.setEmail(oUserEntity.getEmail());
        oUserEntityAux.setUsername(oUserEntity.getUsername());
        oUserEntityAux.setPhone(oUserEntity.getPhone());
        oUserEntityAux.setRole(oUserEntity.getRole());
        oUserEntityAux.setProfile_picture(oUserEntity.getProfile_picture());
        return oUserRepository.save(oUserEntityAux);
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        oUserRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oUserRepository.deleteAll();
        oUserRepository.resetAutoIncrement();
        UserEntity oUserEntity1 = new UserEntity("administrador", "Admin", "Apellido", "mail1@mail.com",
                "658945123", "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e",
                false);
        oUserRepository.save(oUserEntity1);
        oUserEntity1 = new UserEntity("usuario", "Admin", "Apellido", "mail2@mail.com",
        "658945123", "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e",
        false);
        oUserRepository.save(oUserEntity1);
        return oUserRepository.count();
    }
}