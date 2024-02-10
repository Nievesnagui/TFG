package net.ausiasmarch.weekeat.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "weekly")
public class WeeklyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference("user-weekly")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate init_date;


    @JsonManagedReference("weekly-schedule")
    @OneToMany(mappedBy = "id_weekly", fetch = FetchType.EAGER)
    private List<ScheduleEntity> schedules;
    
    public WeeklyEntity() {
        schedules = new ArrayList<>();
    }

    public WeeklyEntity(UserEntity id_user, LocalDate init_date) {
        this.id_user = id_user;
        this.init_date = init_date;
    }

    public WeeklyEntity(Long id, UserEntity id_user, LocalDate init_date) {
        this.id = id;
        this.id_user = id_user;
        this.init_date = init_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getId_user() {
        return id_user;
    }

    public void setId_user(UserEntity id_user) {
        this.id_user = id_user;
    }

    public LocalDate getInit_date() {
        return init_date;
    }

    public void setInit_date(LocalDate init_date) {
        this.init_date = init_date;
    }

    public List<ScheduleEntity> getSchedulesList() {
        return schedules;
    }

    public void setSchedulesList(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    public int getSchedules() {
        return schedules.size();
    }
    
}
