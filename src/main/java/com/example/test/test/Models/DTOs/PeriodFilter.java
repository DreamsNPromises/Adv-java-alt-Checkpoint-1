package com.example.test.test.Models.DTOs;

import com.example.test.test.Models.Enums.SlotType;
import lombok.Data;

@Data
public class PeriodFilter {

    private String id;
    private String slotId;
    private String scheduleId;
    private SlotType slotType;
    private String administratorId;
    private String executorId;
}