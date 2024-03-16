package com.example.test.test.Models.Enums;

import lombok.Getter;

@Getter
public enum SortField {

    BEGIN_TIME,
    END_TIME,
    SLOT_TYPE,
    ADMINISTRATOR_ID, // join with employee table for name
    EXECUTOR_ID; // join with employee table for name
}
