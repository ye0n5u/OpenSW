package com.example.budgetReminder.repository;

import com.example.budgetReminder.entity.Reminder;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ReminderRepository extends CrudRepository<Reminder, Long> {
    @Override
    ArrayList<Reminder> findAll();
}

