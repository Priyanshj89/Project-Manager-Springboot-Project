package com.pj9.ProjectManager.repositories;

import com.pj9.ProjectManager.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
