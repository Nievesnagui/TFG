package net.ausiasmarch.weekeat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "content")
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_content;

    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private TypeEntity id_ingredient;

    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private TypeEntity id_recipe;

    public ContentEntity() {
    }

    public ContentEntity(TypeEntity id_ingredient, TypeEntity id_recipe) {
        this.id_ingredient = id_ingredient;
        this.id_recipe = id_recipe;
    }

    public ContentEntity(Long id_content, TypeEntity id_ingredient, TypeEntity id_recipe) {
        this.id_content = id_content;
        this.id_ingredient = id_ingredient;
        this.id_recipe = id_recipe;
    }

    public Long getId_content() {
        return id_content;
    }

    public void setId_content(Long id_content) {
        this.id_content = id_content;
    }

    public TypeEntity getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(TypeEntity id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public TypeEntity getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(TypeEntity id_recipe) {
        this.id_recipe = id_recipe;
    }

}
