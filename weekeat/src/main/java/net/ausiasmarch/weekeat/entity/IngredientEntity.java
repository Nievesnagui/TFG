package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
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
@Table(name = "ingredient")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("type-ingredient")
    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeEntity id_type;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "ingredient_image")
    private byte[] ingredient_image;


    @JsonManagedReference("ingredient-content")
    @OneToMany(mappedBy = "id_ingredient", fetch = FetchType.EAGER)
    private List<ContentEntity> content;

    public IngredientEntity() {
        content = new ArrayList<>();
    }

    public IngredientEntity(TypeEntity id_type, @NotBlank @NotNull @Size(min = 6, max = 255) String name) {
        this.id_type = id_type;
        this.name = name;
    }

    public IngredientEntity(Long id, TypeEntity id_type,
            @NotBlank @NotNull @Size(min = 6, max = 255) String name, byte[] ingredient_image) {
        this.id = id;
        this.id_type = id_type;
        this.name = name;
        this.ingredient_image = ingredient_image;
    }

    public IngredientEntity(TypeEntity id_type, @NotBlank @NotNull @Size(min = 3, max = 255) String name,
            byte[] ingredient_image) {
        this.id_type = id_type;
        this.name = name;
        this.ingredient_image = ingredient_image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ContentEntity> getContentList() {
        return content;
    }

    public void setContentList(List<ContentEntity> content) {
        this.content = content;
    }

    public int getContent() {
        return content.size();
    }

}
