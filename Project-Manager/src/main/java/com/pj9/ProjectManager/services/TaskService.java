package com.pj9.ProjectManager.services;

import com.pj9.ProjectManager.entities.Task;
import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void addTask(Task task, User user)
    {
        task.setUser(user);
        taskRepository.save(task);
    }
    public List<Task> findUserTask(User user){

        return taskRepository.findByUser(user);
    }

    public void deleteTask(Long id){
        //Long id = task.getId();
        taskRepository.deleteById(id);
    }
}
