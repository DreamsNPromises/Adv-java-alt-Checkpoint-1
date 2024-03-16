package com.example.test.test.Models.DTOs;

import com.example.test.test.Models.Entities.Period;
import lombok.Data;

import java.util.List;

@Data
public class PeriodsResponse {
    private List<Period> periods;
    private int pageNumber;
    private int pageSize;
    private long totalElements;

    public PeriodsResponse(List<Period> periods, int pageNumber, int pageSize, long totalElements) {
        this.periods = periods;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }
}