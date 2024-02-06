package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    private Long id;

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
    private String password = "c9a4780375f66133954db3e1f51ab5503a31da7f963ccb29446e3f554a5a6261";

  
    private String profile_picture;

    //private boolean verified;

    //private String token;


    @JsonManagedReference("user-favourite")
    @OneToMany(mappedBy = "id_user", fetch = FetchType.EAGER)
    private List<FavRecipeEntity> favs;


    @JsonManagedReference("user-weekly")
    @OneToMany(mappedBy = "id_user", fetch = FetchType.EAGER)
    private List<WeeklyEntity> weeks;


    @JsonManagedReference("user-recipe")
    @OneToMany(mappedBy = "id_user", fetch = FetchType.EAGER)
    private List<RecipeEntity> recipes;

    public UserEntity(@NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity(@NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotBlank @NotNull @Size(min = 3, max = 255) String surname, @Email String email,
            @NotNull @NotBlank @Size(min = 8, max = 20) @Pattern(regexp = "^[0-9]+$", message = "Phone number must be decimal") String phone,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password,
            String profile_picture, Boolean role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profile_picture = profile_picture;
        this.role = role;
    }

    public UserEntity(Long id, @NotBlank @NotNull @Size(min = 6, max = 255) String username,
            @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotBlank @NotNull @Size(min = 3, max = 255) String surname, @Email String email,
            @NotNull @NotBlank @Size(min = 8, max = 20) @Pattern(regexp = "^[0-9]+$", message = "Phone number must be decimal") String phone,
            @NotNull @NotBlank @Size(min = 6, max = 256) @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be decimal") String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserEntity() {
        favs = new ArrayList<>();
        weeks = new ArrayList<>();
        recipes = new ArrayList<>();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public List<FavRecipeEntity> getFavsList() {
        return favs;
    }

    public void setFavsList(List<FavRecipeEntity> favs) {
        this.favs = favs;
    }

    public List<WeeklyEntity> getWeeksList() {
        return weeks;
    }

    public void setWeeksList(List<WeeklyEntity> weeks) {
        this.weeks = weeks;
    }

    public List<RecipeEntity> getRecipesList() {
        return recipes;
    }

    public void setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }

    public int getWeeks() {
        return weeks.size();
    }

    public int getFavs() {
        return favs.size();
    }

    public int getRecipes() {
        return recipes.size();
    }

    /* public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }*/
    
}
