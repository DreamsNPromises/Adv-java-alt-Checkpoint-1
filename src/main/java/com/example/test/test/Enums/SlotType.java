package com.example.test.test.Enums;

public enum SlotType {
    LOCAL("Local"),
    FROM_HOME("From Home"),
    UNDEFINED("Undefined");

    private final String label;

    SlotType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
