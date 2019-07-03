package com.example.service.admin.impl;

import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.User;
import com.example.dao.sys.UserDao;
import com.example.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public R findAll() {
        return new R(1,"查询用户列表成功",userDao.findAll(),userDao.findAll().size());
    }

    @Override
    public JSONResult findAllManager(Integer page, Integer pageSize) {
        Pageable pageable=new PageRequest(page-1,pageSize);
        List<User> list=userDao.findAll(pageable).getContent();
        int count=userDao.findAll().size();
        return new JSONResult(0,"查询用户列表成功",list,count);
    }

    @Override
    public R DeleteById(Integer id) {
        if(id<2) {
            return  new R(1,"该用户不能删除");
        }else {
            userDao.deleteById(id.toString());
            return  new R(1,"删除成功");
        }
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id.toString()).get();
    }

    @Override
    public User findByUsername(String name) {
        return userDao.findByUsername(name);
    }

    @Override
    public R addUser(User user) {
        userDao.save(user);
        return  new R(0,"添加成功");
    }
}
