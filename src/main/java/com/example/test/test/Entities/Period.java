package com.example.test.test.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "periods")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @Column(name = "slot_type", nullable = false)
//    private SlotType slotType;

    @Column(name = "begin_time", nullable = false)
    private LocalTime beginTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    // Связанные сущности
    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private Slot slot;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "administrator_id", nullable = false)
    private Employee administrator;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Employee executor;
}
