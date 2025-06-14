package com.example.budgetReminder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Budget {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String memo;

    @Column
    private int cash;
}
