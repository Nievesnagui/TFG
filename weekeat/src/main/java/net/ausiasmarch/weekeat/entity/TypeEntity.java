package net.ausiasmarch.weekeat.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
    private Long id_type;

    @NotBlank
    @NotNull
    @Size(min = 6, max = 255)
    private String name;

    @OneToMany(mappedBy = "type", fetch = jakarta.persistence.FetchType.LAZY)
    private List<IngredientEntity> ingredients;

    public TypeEntity() {
        ingredients = new ArrayList<>();
    }

    public TypeEntity(@NotBlank @NotNull @Size(min = 6, max = 255) String name) {
        this.name = name;
    }

    public TypeEntity(Long id_type, @NotBlank @NotNull @Size(min = 6, max = 255) String name) {
        this.id_type = id_type;
        this.name = name;
    }

    public Long getId_type() {
        return id_type;
    }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
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


}
