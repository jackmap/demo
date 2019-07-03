package com.example.dao.sys;

import com.example.entity.sys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,String> {
    User findByUsername(String name);
    List<User> findByManager(boolean bool);
}
