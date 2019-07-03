package com.example.service.admin;

import com.example.entity.sys.JSONResult;
import com.example.entity.sys.R;
import com.example.entity.sys.User;

public interface RuleService {
    JSONResult findAllRule(Integer page,Integer pageSize);
    R DeleteById(Integer id);
    R findById(Integer id);
}
