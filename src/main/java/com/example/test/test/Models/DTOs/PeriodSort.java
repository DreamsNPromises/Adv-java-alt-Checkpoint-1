package com.example.test.test.Models.DTOs;

import com.example.test.test.Models.Enums.SortDirection;
import com.example.test.test.Models.Enums.SortField;
import lombok.Data;

@Data
public class PeriodSort {

    private SortField field;
    private SortDirection direction;
}