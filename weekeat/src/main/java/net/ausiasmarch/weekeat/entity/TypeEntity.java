package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "type")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @JsonManagedReference("type-ingredient")
    @OneToMany(mappedBy = "id_type",  fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients;

    public TypeEntity() {
        ingredients = new ArrayList<>();
    }

    public TypeEntity(@NotBlank @NotNull @Size(min = 2, max = 255) String name) {
        this.name = name;
    }

    public TypeEntity(Long id, @NotBlank @NotNull @Size(min = 6, max = 255) String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngredients() {
        return ingredients.size();
    }

    public List<IngredientEntity> getIngredientsList() {
        return ingredients;
    }

    public void setIngredientsList(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

}
