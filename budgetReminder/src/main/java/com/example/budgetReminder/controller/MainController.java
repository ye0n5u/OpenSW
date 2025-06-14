package com.example.budgetReminder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String welcome(){return "main";}

    @GetMapping("/")
    public String home() {return "redirect:/login";}
}
