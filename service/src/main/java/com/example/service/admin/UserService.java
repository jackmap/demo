package com.example.service.admin;

import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.User;

public interface UserService {
    R findAll();

    JSONResult findAllManager(Integer page, Integer limit);

    R DeleteById(Integer id);

    User findById(Integer id);
    User findByUsername(String name);
    R  addUser(User user);
}
