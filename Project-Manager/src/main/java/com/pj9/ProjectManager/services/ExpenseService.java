package com.pj9.ProjectManager.services;

import com.pj9.ProjectManager.entities.Expense;
import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public List<Expense> findAllExpense(){
        return expenseRepository.findAll();
    }

    public List<Expense> findUserExpense(User user){
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public void addExpense(Expense expense, User user){
        expense.setUser(user);
        expenseRepository.save(expense);
    }
}
