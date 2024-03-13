package com.example.test.test.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "schedule_name")
    private String name;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Связанные сущности
    @OneToMany(mappedBy = "schedule")
    private List<ScheduleTemplate> templates;

    @OneToMany(mappedBy = "schedule")
    private List<Period> periods;

}