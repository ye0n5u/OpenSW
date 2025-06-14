package com.example.budgetReminder.repository;

import com.example.budgetReminder.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UsersRepository extends CrudRepository<Users,Long> {
    @Override
    ArrayList<Users> findAll();

    Users findByLoginId(String loginId);
}
