package net.ausiasmarch.weekeat.entity;

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

    @ManyToOne
    @JoinColumn(name = "id_user")
    private TypeEntity id_user;

    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private TypeEntity id_recipe;

    public FavRecipeEntity() {
    }

    public FavRecipeEntity(TypeEntity id_user, TypeEntity id_recipe) {
        this.id_user = id_user;
        this.id_recipe = id_recipe;
    }

    public FavRecipeEntity(Long id_fav, TypeEntity id_user, TypeEntity id_recipe) {
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

    public TypeEntity getId_user() {
        return id_user;
    }

    public void setId_user(TypeEntity id_user) {
        this.id_user = id_user;
    }

    public TypeEntity getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(TypeEntity id_recipe) {
        this.id_recipe = id_recipe;
    }
}
