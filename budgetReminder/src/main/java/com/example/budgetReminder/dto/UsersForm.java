package com.example.budgetReminder.dto;

import com.example.budgetReminder.entity.Users;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UsersForm {
    private Long id;
    private String loginId;
    private String password;

    public Users toEntity(){
        return new Users(id, loginId, password);
    }
}