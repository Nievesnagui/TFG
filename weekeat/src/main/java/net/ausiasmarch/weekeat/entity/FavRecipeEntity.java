package net.ausiasmarch.weekeat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fav_recipe")
public class FavRecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("user-favourite")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @JsonBackReference("recipe-favourite")
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private RecipeEntity id_recipe;

    public FavRecipeEntity() {
    }

    public FavRecipeEntity(UserEntity id_user, RecipeEntity id_recipe) {
        this.id_user = id_user;
        this.id_recipe = id_recipe;
    }

    public FavRecipeEntity(Long id, UserEntity id_user, RecipeEntity id_recipe) {
        this.id = id;
        this.id_user = id_user;
        this.id_recipe = id_recipe;
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

    public RecipeEntity getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(RecipeEntity id_recipe) {
        this.id_recipe = id_recipe;
    }
}
