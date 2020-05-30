package com.pj9.ProjectManager.repositories;

import com.pj9.ProjectManager.entities.Task;
import com.pj9.ProjectManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
