package com.pj9.ProjectManager.controllers;

import com.pj9.ProjectManager.entities.Post;
import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.services.PostService;
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
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/addPost")
    public String postForm(String email, Model model, HttpSession session) {

        session.setAttribute("email", email);
        model.addAttribute("post", new Post());
        return "views/postForm";
    }

    @PostMapping("/addPost")
    public String addTask(@Valid Post post, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return "views/postForm";
        }
        String email = (String) session.getAttribute("email");
        postService.addPost(post, userService.findOne(email));

        return  "views/profile";
    }

    @GetMapping("/view")
    public String displayPost(Model model){
        model.addAttribute("aPost", postService.findAllPost());
        return "views/allBlog";
    }

    @GetMapping("/viewPost")
    public String viewPosts(String email, Model model, HttpSession session){
        session.setAttribute("emailPost", email);
        String email1 = (String) session.getAttribute("emailPost");
        User user = userService.findOne(email1);
        //model.addAttribute("allPosts",postService.findAllPost());
        model.addAttribute("posting",postService.findUserPost(user));
        return "views/viewPost";
    }

    @GetMapping("/deletePost")
    public String deletePos(Long id, HttpSession session){
        session.setAttribute("id", id);
        Long id1= (Long) session.getAttribute("id");
        postService.deletePost(id1);
        return "views/profile";
    }

    //@PostMapping("/deletePost")
   // public String deletePost(){
      //  return "views/profile";
    //}
    @GetMapping("/addPosts")
    public String addMyPosts(Model model, Principal principal, HttpSession session){
        String email = principal.getName();
        session.setAttribute("email", email);
        model.addAttribute("post", new Post());
        return "views/postForm";
       // return "views/viewPost1";
    }

    @GetMapping("/viewMyPosts")
    public String getMyPosts(Model model,Principal principal, HttpSession session){
        String email = principal.getName();
        session.setAttribute("emailPost", email);
        String email1 = (String) session.getAttribute("emailPost");
        User user = userService.findOne(email1);
        model.addAttribute("posting",postService.findUserPost(user));
        return "views/viewPost";
    }
}
