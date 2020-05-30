package com.pj9.ProjectManager.controllers;

import com.pj9.ProjectManager.entities.Task;
import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.services.TaskService;
import com.pj9.ProjectManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/addTask")
    public String taskForm(String email, Model model, HttpSession session) {

        session.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "views/taskForm";

    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return "views/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findOne(email));

        return  "redirect:/users";
    }

   @GetMapping("/viewTask")
   public String viewTask(String email, Model model, HttpSession session) {
        session.setAttribute("email", email);
       String email1 = (String) session.getAttribute("email");
       User user = userService.findOne(email1);
       // model1.addAttribute("userView",user);
       model.addAttribute("viewTasks", taskService.findUserTask(user));
       return "views/viewTask";
   }

   @GetMapping("/deleteTask")
    public String deleteTask(Long id, HttpSession session){
       session.setAttribute("id", id);
       Long id1= (Long) session.getAttribute("id");
       taskService.deleteTask(id1);
       return "redirect:/viewTask";
   }


}
