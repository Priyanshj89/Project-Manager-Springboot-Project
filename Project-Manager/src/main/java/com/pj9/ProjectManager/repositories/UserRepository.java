package com.pj9.ProjectManager.repositories;

import com.pj9.ProjectManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameLike(String name);

    User findByEmail(String email);

}
