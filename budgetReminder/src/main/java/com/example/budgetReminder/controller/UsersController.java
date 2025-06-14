package com.example.budgetReminder.controller;

import com.example.budgetReminder.dto.UsersForm;
import com.example.budgetReminder.entity.Users;
import com.example.budgetReminder.repository.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {model.addAttribute("error", true);}
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String loginId, @RequestParam String password, HttpSession session) {
        Users user = usersRepository.findByLoginId(loginId);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loginId", loginId);
            return "redirect:/main";
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/register")
    public String registerPage(){return "register";}

    @PostMapping("/register/new")
    public String registerProcess(UsersForm form) {
        Users users = form.toEntity();
        Users saved = usersRepository.save(users);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){return "logout";}


}
