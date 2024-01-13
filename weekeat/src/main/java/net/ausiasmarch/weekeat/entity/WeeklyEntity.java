package net.ausiasmarch.weekeat.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
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
    private Long id_weekly;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity id_user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime init_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime end_date;

    @OneToMany(mappedBy = "weekly", fetch = jakarta.persistence.FetchType.LAZY)
    private List<ScheduleEntity> schedules;
    
    public WeeklyEntity() {
        schedules = new ArrayList<>();
    }

    public WeeklyEntity(UserEntity id_user, LocalDateTime init_date) {
        this.id_user = id_user;
        this.init_date = init_date;
    }

    public WeeklyEntity(Long id_weekly, UserEntity id_user, LocalDateTime init_date) {
        this.id_weekly = id_weekly;
        this.id_user = id_user;
        this.init_date = init_date;
    }

    public WeeklyEntity(UserEntity id_user, LocalDateTime init_date, LocalDateTime end_date) {
        this.id_user = id_user;
        this.init_date = init_date;
        this.end_date = end_date;
    }

    public WeeklyEntity(Long id_weekly, UserEntity id_user, LocalDateTime init_date, LocalDateTime end_date) {
        this.id_weekly = id_weekly;
        this.id_user = id_user;
        this.init_date = init_date;
        this.end_date = end_date;
    }

    public Long getId_weekly() {
        return id_weekly;
    }

    public void setId_weekly(Long id_weekly) {
        this.id_weekly = id_weekly;
    }

    public UserEntity getId_user() {
        return id_user;
    }

    public void setId_user(UserEntity id_user) {
        this.id_user = id_user;
    }

    public LocalDateTime getInit_date() {
        return init_date;
    }

    public void setInit_date(LocalDateTime init_date) {
        this.init_date = init_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    
}
