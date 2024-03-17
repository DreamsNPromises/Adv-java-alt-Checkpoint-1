package com.example.test.test.Repositories;

import com.example.test.test.Models.Entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    Schedule findByName(String name);
}
