package com.example.test.test.Models.Entities;

import com.example.test.test.Utils.UUIDConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "slots")
public class Slot {

    @Id
    private String id;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            UUIDConverter uuidConverter = new UUIDConverter();
            //На практике это означает, что даже при генерации миллиардов UUID в секунду
            //вероятность коллизии остается настолько ничтожно малой, что ей можно пренебречь.
            this.id = uuidConverter.convertToDatabaseColumn(UUID.randomUUID());
        }
    }

    @Column(name = "begin_time", nullable = false)
    private LocalTime beginTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    // Связанные сущности
    @ManyToOne
    @JoinColumn(name = "schedule_template_id", nullable = false)
    private ScheduleTemplate template;
}