package com.example.test.test.Models.Enums;

public enum EmployeeStatus {

    WORKING("Working"),
    TRIAL("Trial"),
    TIME_OFF("Time Off"),
    DISMISSED("Dismissed");

    private final String label;

    EmployeeStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}