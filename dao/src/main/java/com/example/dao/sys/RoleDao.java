package com.example.dao.sys;

import com.example.entity.sys.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,String> {
    Role findByRolename(String name);
}
