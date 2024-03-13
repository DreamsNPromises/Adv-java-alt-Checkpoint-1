package com.example.test.test.Enums;

public enum EmployeePosition {

    MANAGER("Manager"),
    EMPLOYEE("Employee"),
    UNDEFINED("Undefined"),
    TECH("Tech");

    private final String label;

    EmployeePosition(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
