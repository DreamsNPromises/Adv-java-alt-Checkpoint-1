package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.TimeRangeException;
import com.example.test.test.Models.Entities.Slot;

public interface SlotService {

    Slot createSlot(Slot slot) throws NotFoundException, TimeRangeException;

    Slot getById(String id) throws NotFoundException;

}
