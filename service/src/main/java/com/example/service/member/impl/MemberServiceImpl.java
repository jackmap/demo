package com.example.service.member.impl;

import com.example.dao.sys.MemberDao;
import com.example.entity.member.Member;
import com.example.entity.sys.JSONResult;
import com.example.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Override
    public JSONResult findAllMember(Boolean state,Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page - 1, pageSize);
         Page<Member>  list=memberDao.findByEnabledEquals(state,pageable);
        int count = memberDao.findAll().size();
        return new JSONResult(0, "查询会员列表成功", list.getContent(), count);
    }

}
