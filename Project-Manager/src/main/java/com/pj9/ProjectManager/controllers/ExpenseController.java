package com.pj9.ProjectManager.controllers;

import com.pj9.ProjectManager.entities.Expense;
import com.pj9.ProjectManager.entities.Post;
import com.pj9.ProjectManager.services.ExpenseService;
import com.pj9.ProjectManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    UserService userService;

    @GetMapping("/listExpense")
    public String listExpense(Model model){
        model.addAttribute("expenses",expenseService.findAllExpense());
        return "views/allExpense";
    }

    @GetMapping("/addExpense")
    public String expenseForm(String email, Model model, HttpSession session) {

        session.setAttribute("email", email);
        model.addAttribute("expense", new Expense());
        return "views/expenseForm";
    }

    @PostMapping("/addExpense")
    public String expenseTask(@Valid Expense expense, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return "views/expenseForm";
        }
        String email = (String) session.getAttribute("email");
        expenseService.addExpense(expense, userService.findOne(email));

        return  "views/profile";
    }

    @GetMapping("/deleteExpense")
    public String deletePos(Long id, HttpSession session){
        session.setAttribute("id", id);
        Long id1= (Long) session.getAttribute("id");
        expenseService.deleteExpense(id1);
        return "views/profile";
    }

    @GetMapping("/addExpenses")
    public String addMyExpenses(Model model, Principal principal, HttpSession session){
        String email = principal.getName();
        session.setAttribute("email", email);
        model.addAttribute("expense", new Expense());
        return "views/expenseForm";
        // return "views/viewPost1";
    }
}
