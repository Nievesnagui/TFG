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
    private Long id_fav;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private RecipeEntity id_recipe;

    public FavRecipeEntity() {
    }

    public FavRecipeEntity(UserEntity id_user, RecipeEntity id_recipe) {
        this.id_user = id_user;
        this.id_recipe = id_recipe;
    }

    public FavRecipeEntity(Long id_fav, UserEntity id_user, RecipeEntity id_recipe) {
        this.id_fav = id_fav;
        this.id_user = id_user;
        this.id_recipe = id_recipe;
    }

    public Long getId_fav() {
        return id_fav;
    }

    public void setId_fav(Long id_fav) {
        this.id_fav = id_fav;
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
