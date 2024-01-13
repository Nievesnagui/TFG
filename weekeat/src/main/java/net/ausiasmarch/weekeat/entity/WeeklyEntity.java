package net.ausiasmarch.weekeat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weekly")
public class WeeklyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_weekly;

    // ???????
}
