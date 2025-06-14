package com.example.budgetReminder.controller;

import com.example.budgetReminder.dto.ReminderForm;
import com.example.budgetReminder.entity.Reminder;
import com.example.budgetReminder.repository.ReminderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j //로깅을 쓰기 위한 어노테이션
public class ReminderController {
    @Autowired
    private ReminderRepository reminderRepository;

    @PostMapping("/reminders/create")
    public String reminderCreate(ReminderForm form){
        Reminder reminder = form.toEntity();
        Reminder saved = reminderRepository.save(reminder);
        return "redirect:/reminders";
    }

    @GetMapping("/reminders")
    public String reminderMain(Model model){
        List<Reminder> reminderEntityList=reminderRepository.findAll();
        model.addAttribute("reminderList",reminderEntityList);
        return "reminders/index";
    }

    @GetMapping("/reminders/list")
    public String reminderShow(Model model){
        List<Reminder> reminderEntityList=reminderRepository.findAll();
        model.addAttribute("reminderList",reminderEntityList);
        return "reminders/list";
    }

    @GetMapping("/reminders/{id}/edit")
    public String reminderEdit(@PathVariable Long id, Model model){
        Reminder reminderEntity = reminderRepository.findById(id).orElse(null);
        model.addAttribute("reminder",reminderEntity);
        return "reminders/edit";
    }

    @PostMapping("/reminders/update")
    public String reminderUpdate(ReminderForm form){
        Reminder reminderEntity = form.toEntity();
        Reminder target = reminderRepository.findById(reminderEntity.getId()).orElse(null);
        if(target!=null){
            reminderRepository.save(reminderEntity);
        }
        return "redirect:/reminders";
    }

    @GetMapping("/reminders/{id}/delete")
    public String reminderDelete(@PathVariable Long id, RedirectAttributes rttr){
        Reminder target = reminderRepository.findById(id).orElse(null);
        if(target!=null){
            reminderRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료됨!");
        }
        return "redirect:/reminders";
    }
}
