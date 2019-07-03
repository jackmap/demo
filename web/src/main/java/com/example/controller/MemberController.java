package com.example.controller;

import com.example.entity.sys.JSONResult;
import com.example.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/member", produces = APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "会员管理")
public class MemberController {
    @Autowired
    public MemberService memberService;

    @PostMapping("/list")
    @ApiOperation(value = "获取会员列表", notes = "获取所有会员信息")
    public JSONResult FindAllManager(Integer page, Integer limit){
        System.out.println("页数："+page+"  条数:"+limit );
        JSONResult result= memberService.findAllMember(true,page, limit);
        return result;
    }


    @PostMapping("/delete/list")
    @ApiOperation(value = "已删除会员列表", notes = "获取已删除会员信息")
    public JSONResult DeleteManager(Integer page, Integer limit){
        System.out.println("页数："+page+"  条数:"+limit );
        return new JSONResult();
    }

}
