package com.example.service.member;

import com.example.entity.sys.JSONResult;

public interface MemberService  {
   JSONResult findAllMember(Boolean state,Integer page, Integer pageSize);
}
