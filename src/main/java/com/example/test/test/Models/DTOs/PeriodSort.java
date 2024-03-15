package com.example.test.test.Models.DTOs;

import lombok.Data;

@Data
public class PeriodSort {

    public enum Field {
        ID,
        SLOT_TYPE,
        BEGIN_TIME,
        END_TIME,
        ADMINISTRATOR_ID,
        EXECUTOR_ID
    }

    public enum Direction {
        ASC,
        DESC
    }

    private Field field;
    private Direction direction;

    // Getters and setters
}