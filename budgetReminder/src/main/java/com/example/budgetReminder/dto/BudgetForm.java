package com.example.budgetReminder.dto;

import com.example.budgetReminder.entity.Budget;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BudgetForm {
    private Long id;
    private String memo;
    private int cash;

    public Budget toEntity(){return new Budget(id, memo, cash);}
}
