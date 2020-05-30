package com.pj9.ProjectManager.services;

import com.pj9.ProjectManager.entities.Post;
import com.pj9.ProjectManager.entities.User;
import com.pj9.ProjectManager.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAllPost(){
        return postRepository.findAll();
    }

    public List<Post> findUserPost(User user){

        return postRepository.findByUser(user);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public void addPost(Post post, User user){
        post.setUser(user);
        postRepository.save(post);
    }
}
