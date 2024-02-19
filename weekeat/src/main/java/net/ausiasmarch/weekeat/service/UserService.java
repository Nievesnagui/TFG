package net.ausiasmarch.weekeat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import net.ausiasmarch.weekeat.entity.FavRecipeEntity;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.exception.ResourceNotFoundException;
import net.ausiasmarch.weekeat.helper.DataGenerationHelper;
import net.ausiasmarch.weekeat.repository.FavRecipeRepository;
import net.ausiasmarch.weekeat.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository oUserRepository;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    FavRecipeRepository oFavRecipeRepository;

    @Autowired
    SessionService oSessionService;

    /*
     * @Autowired
     * EmailService oEmailService;
     */
    private final String genericPasswd = "c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261";

    public UserEntity get(Long id) {
        oSessionService.onlyAdminsOrUsersWithIisOwnData(id);
        return oUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserEntity getByUsername(String username) {
        oSessionService.onlyAdminsOrUsers();
        return oUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by username"));
    }

    public Page<UserEntity> getPage(Pageable oPageable, String filter) {
         Page<UserEntity> page;
         oSessionService.onlyAdmins();
        if (filter == null || filter.isEmpty() || filter.trim().isEmpty()) {
            if (oSessionService.isAdmin()) {
                page = oUserRepository.findAll(oPageable);
            } else {
               // page = oUserRepository.findAllByActiveTrue(oPageable);
               page = oUserRepository.findAll(oPageable);
            }
        } else {
            page = oUserRepository.findByUserByNameOrSurnameContainingIgnoreCase(
                    filter, filter, filter, filter, oPageable);
        }
        return page;
    }

    public Long create(UserEntity oUserEntity) {
        oSessionService.onlyAdmins();
        oUserEntity.setId(null);
        oUserEntity.setPassword(genericPasswd);
        return oUserRepository.save(oUserEntity).getId();
    }

    public UserEntity update(UserEntity oUserEntity) {
        oSessionService.onlyAdmins();
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
        UserEntity user = oUserRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        for (FavRecipeEntity fav : user.getFavsList()) {
            oFavRecipeRepository.delete(fav);
        }
        oUserRepository.deleteById(id);

        return id;
    }

    @Transactional
    public Long empty() {
        oSessionService.onlyAdmins();
        oUserRepository.deleteAll();
        oUserRepository.resetAutoIncrement();
        UserEntity oUserEntity1 = new UserEntity("administrador", "Admin", "Apellido", "mail1@mail.com",
                "658945123", "c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261",
                false);
        oUserRepository.save(oUserEntity1);
        oUserEntity1 = new UserEntity("usuario", "Admin", "Apellido", "mail2@mail.com",
                "658945123", "c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261",
                true);
        oUserRepository.save(oUserEntity1);
        return oUserRepository.count();
    }

    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
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
                    new UserEntity(username, name, surname, email, "654123654", password, true));
        }
        return oUserRepository.count();

    }
}