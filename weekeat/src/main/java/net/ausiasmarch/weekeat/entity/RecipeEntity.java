package net.ausiasmarch.weekeat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_recipe;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 255)
    private String name;

    @NotNull
    @NotBlank
    String description;

    @Lob
    private byte[] recipe_image;

    public RecipeEntity() {
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
    }

    public RecipeEntity(UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description, byte[] recipe_image) {
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.recipe_image = recipe_image;
    }

    public RecipeEntity(Long id_recipe, UserEntity id_user, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            @NotNull @NotBlank String description, byte[] recipe_image) {
        this.id_recipe = id_recipe;
        this.id_user = id_user;
        this.name = name;
        this.description = description;
        this.recipe_image = recipe_image;
    }

    public Long getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(Long id_recipe) {
        this.id_recipe = id_recipe;
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

    public byte[] getRecipe_image() {
        return recipe_image;
    }

    public void setRecipe_image(byte[] recipe_image) {
        this.recipe_image = recipe_image;
    }

    

}
