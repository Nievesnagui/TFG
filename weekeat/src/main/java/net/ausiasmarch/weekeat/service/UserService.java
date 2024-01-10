package net.ausiasmarch.weekeat.service;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
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

   // @Autowired
    //SessionService oSessionService;

    private final String genericPasswd = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    public UserEntity get(Long id) {

        return oUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserEntity getByUsername(String username) {

        return oUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by username"));
    }

    public Long create(UserEntity oUserEntity) {
        oUserEntity.setId_user(null);
        oUserEntity.setPassword(genericPasswd);
        return oUserRepository.save(oUserEntity).getId_user();

    }

    public UserEntity update(UserEntity oUserEntity) {

        
          UserEntity oUserEntityAux =
          oUserRepository.findById(oUserEntity.getId_user())
          .orElseThrow(() -> new ResourceNotFoundException("User not found"));
          oUserEntityAux.setName(oUserEntity.getName());
          oUserEntityAux.setSurname(oUserEntity.getSurname());
          oUserEntityAux.setEmail(oUserEntity.getEmail());
          oUserEntityAux.setUsername(oUserEntity.getUsername());
         oUserEntityAux.setPhone(oUserEntity.getPhone());
          return oUserRepository.save(oUserEntityAux);
    }

    public Long delete(Long id) {
        oUserRepository.deleteById(id);
        return id;
    }
/* 
    public UserEntity getOneRandom() {
        Pageable oPageable = PageRequest.of((int) (Math.random() * oUserRepository.count()), 1);
        return oUserRepository.findAll(oPageable).getContent().get(0);
    }

    public Page<UserEntity> getPage(Pageable oPageable) {
        return oUserRepository.findAll(oPageable);
    }

    public Page<UserEntity> getPageByCitasNumberDesc(Pageable oPageable) {

        return oUserRepository.findVetssByCitasNumberDescFilter(oPageable);
    }

    public Long populate(Integer amount) {

        for (int i = 0; i < amount; i++) {
            String password = "unapasswordsegura12345567789976543" + i;
            String name = DataGenerationHelper.getRadomName();
            String surname = DataGenerationHelper.getRadomSurname();
            String email = name.substring(0, 3) + surname.substring(0, 3) + i
                    + "@ausiasmarch.net";
            String username = DataGenerationHelper
                    .doNormalizeString(
                            name.substring(0, 3) + surname.substring(1, 3) + i);
            oUserRepository.save(
                    new UserEntity(name, surname, email, username, password,
                            "32323232r", "648956235", true));
        }
        return oUserRepository.count();

    }
*/
    @Transactional
    public Long empty() {
        oUserRepository.deleteAll();
        // oUserRepository.resetAutoIncrement();
        UserEntity oUserEntity1 = new UserEntity("useradmin", "Admin", "Apellido", "mail@mail.com",
                 "658945123", "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e",
                 false);
        oUserRepository.save(oUserEntity1);
        oUserEntity1 = new UserEntity("User", "Apellido", "mail@mail.com",
                "useruser", "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", 
                "658945123", true);
        oUserRepository.save(oUserEntity1);
        return oUserRepository.count();
    }
}
