package com.pj9.ProjectManager.repositories;

import com.pj9.ProjectManager.entities.Expense;
import com.pj9.ProjectManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
