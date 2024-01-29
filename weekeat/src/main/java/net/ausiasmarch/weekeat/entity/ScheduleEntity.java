package net.ausiasmarch.weekeat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonBackReference("weekly-schedule")
    @ManyToOne
    @JoinColumn(name = "id_weekly")
    private WeeklyEntity id_weekly;

    @JsonBackReference("recipe-schedule")
    @ManyToOne
    @JoinColumn(name = "id_recipe")
    private RecipeEntity id_recipe;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String type;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String day;

    public ScheduleEntity() {
    }

    public ScheduleEntity(WeeklyEntity id_weekly, RecipeEntity id_recipe,
            @NotBlank @NotNull @Size(min = 2, max = 20) String type,
            @NotBlank @NotNull @Size(min = 2, max = 20) String day) {
        this.id_weekly = id_weekly;
        this.id_recipe = id_recipe;
        this.type = type;
        this.day = day;
    }



    public ScheduleEntity(Long id, WeeklyEntity id_weekly, RecipeEntity id_recipe,
            @NotBlank @NotNull @Size(min = 2, max = 20) String type,
            @NotBlank @NotNull @Size(min = 2, max = 20) String day) {
        this.id = id;
        this.id_weekly = id_weekly;
        this.id_recipe = id_recipe;
        this.type = type;
        this.day = day;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeeklyEntity getId_weekly() {
        return id_weekly;
    }

    public void setId_weekly(WeeklyEntity id_weekly) {
        this.id_weekly = id_weekly;
    }

    public RecipeEntity getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(RecipeEntity id_recipe) {
        this.id_recipe = id_recipe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    

}
