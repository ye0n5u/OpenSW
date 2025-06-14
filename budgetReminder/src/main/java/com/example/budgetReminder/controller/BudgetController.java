package com.example.budgetReminder.controller;

import com.example.budgetReminder.dto.BudgetForm;
import com.example.budgetReminder.entity.Budget;
import com.example.budgetReminder.repository.BudgetRepository;
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
@Slf4j
public class BudgetController {
    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/budgets")
    public String budgetMain(Model model){
        List<Budget> budgetEntityList=budgetRepository.findAll();
        model.addAttribute("budgetList",budgetEntityList);
        return "budgets/index";
    }

    @PostMapping("/budgets/create")  
    public String budgetCreate(BudgetForm form) {
        Budget budget = form.toEntity();
        Budget saved = budgetRepository.save(budget);
        return "redirect:/budgets";
    }

    @GetMapping("/budgets/list")
    public String budgetShow(Model model){
        List<Budget> budgetEntityList=budgetRepository.findAll();
        model.addAttribute("budgetList",budgetEntityList);
        return "budgets/list";
    }

    @GetMapping("/budgets/{id}/edit")
    public String budgetEdit(@PathVariable Long id, Model model){
        Budget budgetEntity = budgetRepository.findById(id).orElse(null);
        model.addAttribute("budget", budgetEntity);
        return "budgets/edit";
    }

    @PostMapping("/budgets/update")
    public String budgetUpdate(BudgetForm form){
        Budget budgetEntity = form.toEntity();
        Budget target = budgetRepository.findById(budgetEntity.getId()).orElse(null);
        if(target!=null){budgetRepository.save(budgetEntity);}
        return "redirect:/budgets";
    }

    @GetMapping("/budgets/{id}/delete")
    public String budgetDelete(@PathVariable Long id, RedirectAttributes rttr){
        Budget target = budgetRepository.findById(id).orElse(null);
        if(target!=null){
            budgetRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료됨!");
        }
        return "redirect:/budgets";
    }
}

