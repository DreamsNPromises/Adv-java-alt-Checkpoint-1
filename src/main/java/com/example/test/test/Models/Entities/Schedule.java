package com.example.test.test.Models.Entities;

import com.example.test.test.Utils.UUIDConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "schedule_name")
    private String name;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Связанные сущности
    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<ScheduleTemplate> templates;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<Period> periods;

}