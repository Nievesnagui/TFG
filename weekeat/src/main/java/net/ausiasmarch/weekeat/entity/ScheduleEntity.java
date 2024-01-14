package net.ausiasmarch.weekeat.entity;

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
    private Long id_schedule;
    
    @ManyToOne
    @JoinColumn(name = "id_weekly")
    private WeeklyEntity id_weekly;

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



    public ScheduleEntity(Long id_schedule, WeeklyEntity id_weekly, RecipeEntity id_recipe,
            @NotBlank @NotNull @Size(min = 2, max = 20) String type,
            @NotBlank @NotNull @Size(min = 2, max = 20) String day) {
        this.id_schedule = id_schedule;
        this.id_weekly = id_weekly;
        this.id_recipe = id_recipe;
        this.type = type;
        this.day = day;
    }



    public Long getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(Long id_schedule) {
        this.id_schedule = id_schedule;
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
