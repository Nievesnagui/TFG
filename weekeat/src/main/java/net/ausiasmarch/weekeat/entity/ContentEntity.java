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
@Table(name = "content")
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_content;

    @JsonBackReference("ingredient-content")
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private IngredientEntity id_ingredient;

    @JsonBackReference("recipe-content")
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private RecipeEntity id_recipe;

    public ContentEntity() {
    }

    public ContentEntity(IngredientEntity id_ingredient, RecipeEntity id_recipe) {
        this.id_ingredient = id_ingredient;
        this.id_recipe = id_recipe;
    }

    public ContentEntity(Long id_content, IngredientEntity id_ingredient, RecipeEntity id_recipe) {
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

    public IngredientEntity getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(IngredientEntity id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public RecipeEntity getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(RecipeEntity id_recipe) {
        this.id_recipe = id_recipe;
    }

}
