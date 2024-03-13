package com.example.test.test.Repositories;

import com.example.test.test.Entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SlotRepository extends JpaRepository<Slot, UUID> {

}