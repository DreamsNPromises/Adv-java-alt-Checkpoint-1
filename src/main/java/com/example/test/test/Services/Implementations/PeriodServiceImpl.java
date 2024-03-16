package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.Slot;
import com.example.test.test.Repositories.PeriodRepository;
import com.example.test.test.Repositories.SlotRepository;
import com.example.test.test.Services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    @Override
    public Period createPeriod(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public Period getById(UUID id) throws NotFoundException {
        Optional<Period> period = periodRepository.findById(id);
        if(period.isPresent()){
            return period.get();
        }else{
            throw new NotFoundException("Period not found with id : " + id);
        }
    }

    @Override
    public Page<Period> getAll(
        Pageable pageable
    ) {
        Page<Period> page = periodRepository.findAll(pageable);

        return periodRepository.findAll(pageable);
    }

}
