package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("user-recipe")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotBlank
    String description;
    
    @NotNull
    @NotBlank
    String process;

    String recipe_image;

    
    @JsonManagedReference("recipe-content")
    @OneToMany(mappedBy = "id_recipe", fetch = FetchType.EAGER)
    private List<ContentEntity> content;
    

    @JsonManagedReference("recipe-favourite")
    @OneToMany(mappedBy = "id_recipe", fetch = FetchType.EAGER)
    private List<FavRecipeEntity> favs;


    @JsonManagedReference("recipe-schedule")
    @OneToMany(mappedBy = "id_recipe", fetch = FetchType.EAGER)
    private List<ScheduleEntity> schedules;

    public RecipeEntity() {
        content = new ArrayList<>();
        favs = new ArrayList<>();
        schedules = new ArrayList<>();
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotNull @NotBlank String description, @NotNull @NotBlank String process, List<ContentEntity> content,
            List<FavRecipeEntity> favs, List<ScheduleEntity> schedules) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.process = process;
        this.content = content;
        this.favs = favs;
        this.schedules = schedules;
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotNull @NotBlank String description, @NotNull @NotBlank String process, String recipe_image,
            List<ContentEntity> content, List<FavRecipeEntity> favs, List<ScheduleEntity> schedules) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.process = process;
        this.recipe_image = recipe_image;
        this.content = content;
        this.favs = favs;
        this.schedules = schedules;
    }

    public RecipeEntity(Long id, UserEntity id_user, @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            @NotNull @NotBlank String description, @NotNull @NotBlank String process, String recipe_image,
            List<ContentEntity> content, List<FavRecipeEntity> favs, List<ScheduleEntity> schedules) {
        this.id = id;
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.process = process;
        this.recipe_image = recipe_image;
        this.content = content;
        this.favs = favs;
        this.schedules = schedules;
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description, String recipe_image) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.recipe_image = recipe_image;
    }

    public RecipeEntity(Long id, UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description, String recipe_image) {
        this.id = id;
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.recipe_image = recipe_image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getId_user() {
        return id_user;
    }

    public void setId_user(UserEntity id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipe_image() {
        return recipe_image;
    }

    public void setRecipe_image(String recipe_image) {
        this.recipe_image = recipe_image;
    }


    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setSchedules(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }


    public List<ContentEntity> getContent() {
        return content;
    }

    public void setContent(List<ContentEntity> content) {
        this.content = content;
    }

    public int getContent_count() {
        return content.size();
    }

    public List<FavRecipeEntity> getFavs() {
        return favs;
    }

    public void setFavs(List<FavRecipeEntity> favs) {
        this.favs = favs;
    }

    public List<ScheduleEntity> getSchedulesList() {
        return schedules;
    }

    public void setSchedulesList(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    public int getSchedules() {
        return schedules.size();
    }

}
