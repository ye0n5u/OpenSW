package com.example.budgetReminder.dto;

import com.example.budgetReminder.entity.Reminder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ReminderForm {
    private Long id;
    private String date;
    private String todo;

    public Reminder toEntity(){
        return new Reminder(id, date, todo);
    }
}
