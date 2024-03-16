package com.example.test.test.Models.Enums;

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

    public static SlotType validateSlotType(String slotType) {
        if (slotType == null) {
            return null;
        }

        try {
            return valueOf(slotType.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
