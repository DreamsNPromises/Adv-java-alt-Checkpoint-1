package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Slot;
import com.example.test.test.Repositories.SlotRepository;
import com.example.test.test.Services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public Slot getById(String id) throws NotFoundException {
        Optional<Slot> slot = slotRepository.findById(id);
        if(slot.isPresent()){
            return slot.get();
        }else{
            throw new NotFoundException("Slot not found with id : " + id);
        }
    }

}
