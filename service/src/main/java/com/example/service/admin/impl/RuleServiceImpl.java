package com.example.service.admin.impl;

import com.example.dao.sys.RuleDao;
import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.Rule;
import com.example.service.admin.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    RuleDao ruleDao;

    @Override
    public JSONResult findAllRule(Integer page, Integer pageSize) {
        Pageable pageable=new PageRequest(page-1,pageSize);
        List<Rule> list=ruleDao.findAll(pageable).getContent();
        int count=ruleDao.findAll().size();
        return new JSONResult(0,"查询权限列表成功",list,count);
    }

    @Override
    public R DeleteById(Integer id) {
        return new R(1,"删除成功");
    }


    @Override
    public R findById(Integer id) {
      return   new R(1,"查询成功");
    }

}
