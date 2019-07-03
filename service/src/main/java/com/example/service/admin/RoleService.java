package com.example.service.admin;

import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.User;

public interface RoleService {
    JSONResult findAll(Integer page, Integer limit);
    R DeleteById(Integer id);
    R  addRole(User user);
    R findById(Integer id);
    R findByRolename(String name);
}
