package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 255)
    private String username;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 255)
    private String surname;

    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20)
    @Pattern(regexp = "^[0-9]+$", message = "Phone number must be decimal")
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @NotBlank
    @Size(min = 6, max = 256)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal")
    private String password = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    public UserEntity(@NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(Long id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotBlank @NotNull @Size(min = 3, max = 255) String surname, @Email String email,
            @NotNull @NotBlank @Size(min = 8, max = 20) @Pattern(regexp = "^[0-9]+$", message = "Phone number must be decimal") String phone,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password) {
        this.id_user = id_user;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserEntity() {
    }

    public UserEntity(@NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotBlank @NotNull @Size(min = 3, max = 255) String surname, @Email String email,
            @NotNull @NotBlank @Size(min = 8, max = 20) @Pattern(regexp = "^[0-9]+$", message = "Phone number must be decimal") String phone,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password,
            Boolean role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }

    private Boolean role = false;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

}
