package com.example.service.admin.impl;

import com.example.dao.sys.RoleDao;
import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.Role;
import com.example.entity.sys.User;
import com.example.service.admin.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public JSONResult findAll(Integer page, Integer limit) {
        Pageable pageable=new PageRequest(page-1,limit);
        List<Role> list=roleDao.findAll(pageable).getContent();
        int count=roleDao.findAll().size();
        return  new JSONResult(0,"查询角色列表成功",list,count);
    }

    @Override
    public R DeleteById(Integer id) {
        return new R(1,"删除成功");
    }

    @Override
    public R addRole(User user) {
        return new R(1,"添加成功");
    }

    @Override
    public R findById(Integer id) {
      return   new R(1,"查询成功");
    }

    @Override
    public R findByRolename(String name) {
      return   new R(1,"查询成功");
    }
}
