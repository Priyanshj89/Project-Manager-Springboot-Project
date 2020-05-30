package com.pj9.ProjectManager.controllers;

import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.services.PostService;
import com.pj9.ProjectManager.services.TaskService;
import com.pj9.ProjectManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private PostService postService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findUserTask(user));


        return "views/profile";
    }



}
