package com.example.budgetReminder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reminder {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String date;

    @Column
    private String todo;
}
