package net.ausiasmarch.weekeat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import jakarta.validation.Valid;
import net.ausiasmarch.weekeat.entity.UserEntity;
import net.ausiasmarch.weekeat.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserApi {
    
    @Autowired
    UserService oUserService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oUserService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody @Valid UserEntity oUserEntity) {
        return ResponseEntity.ok(oUserService.create(oUserEntity));
    }

    @PutMapping("")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity oUserEntity) {
        return ResponseEntity.ok(oUserService.update(oUserEntity));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oUserService.delete(id));
    }

    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(oUserService.empty());
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<UserEntity> get(@PathVariable("username") String username) {
        return ResponseEntity.ok(oUserService.getByUsername(username));
    }

    @GetMapping("")
    public ResponseEntity<Page<UserEntity>> getPage(Pageable oPageable,
     @RequestParam(name = "filter", required = false) String strFilter) {
        return ResponseEntity.ok(oUserService.getPage(oPageable, strFilter));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oUserService.populate(amount));

    }
}
