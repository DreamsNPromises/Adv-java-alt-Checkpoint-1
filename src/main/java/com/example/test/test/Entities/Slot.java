package com.example.test.test.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "begin_time", nullable = false)
    private LocalTime beginTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    // Связанные сущности
    @ManyToOne
    @JoinColumn(name = "schedule_template_id", nullable = false)
    private ScheduleTemplate template;
}