package com.pj9.ProjectManager.controllers;

import com.pj9.ProjectManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

@Validated
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model, @Pattern(regexp="^[A-Za-z]*", message = "Invalid user name") @RequestParam(defaultValue="") String name) {
        model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }

}
