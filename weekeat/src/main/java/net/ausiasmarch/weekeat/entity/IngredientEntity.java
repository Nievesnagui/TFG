package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
@Table(name = "ingredient")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingredient;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeEntity id_type;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 255)
    private String name;

    @Lob
    private byte[] ingredient_image;

    @OneToMany(mappedBy = "ingredient", fetch = jakarta.persistence.FetchType.LAZY)
    private List<ContentEntity> content;

    public IngredientEntity() {
        content = new ArrayList<>();
    }

    public IngredientEntity(TypeEntity id_type, @NotBlank @NotNull @Size(min = 6, max = 255) String name) {
        this.id_type = id_type;
        this.name = name;
    }
    
    public IngredientEntity(Long id_ingredient, TypeEntity id_type,
            @NotBlank @NotNull @Size(min = 6, max = 255) String name, byte[] ingredient_image) {
        this.id_ingredient = id_ingredient;
        this.id_type = id_type;
        this.name = name;
        this.ingredient_image = ingredient_image;
    }

    public IngredientEntity(TypeEntity id_type, @NotBlank @NotNull @Size(min = 6, max = 255) String name,
            byte[] ingredient_image) {
        this.id_type = id_type;
        this.name = name;
        this.ingredient_image = ingredient_image;
    }

    public Long getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(Long id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public TypeEntity getId_type() {
        return id_type;
    }

    public void setId_type(TypeEntity id_type) {
        this.id_type = id_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getIngredient_image() {
        return ingredient_image;
    }

    public void setIngredient_image(byte[] ingredient_image) {
        this.ingredient_image = ingredient_image;
    }

}
