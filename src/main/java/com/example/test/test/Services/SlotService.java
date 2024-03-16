package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Models.Entities.Slot;

import java.util.UUID;

public interface SlotService {

    Slot createSlot(Slot slot);

    Slot getById(String id) throws NotFoundException;

}
