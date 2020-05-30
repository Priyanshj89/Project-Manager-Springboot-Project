package com.pj9.ProjectManager.repositories;

import com.pj9.ProjectManager.entities.Post;
import com.pj9.ProjectManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

}
