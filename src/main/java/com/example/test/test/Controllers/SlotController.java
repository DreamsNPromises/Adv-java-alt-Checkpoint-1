package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.TimeRangeException;
import com.example.test.test.Models.Entities.Slot;
import com.example.test.test.Services.Implementations.SlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slot")
public class SlotController {

    @Autowired
    private SlotServiceImpl slotService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Slot createSlot(@RequestBody @Validated Slot slot) throws NotFoundException, TimeRangeException {
        return slotService.createSlot(slot);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slot> getSlotById(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(slotService.getById(id));
    }

}
