package com.example.controller;

import com.example.entity.sys.Cate;
import com.example.entity.sys.JSONResult;
import com.example.service.admin.CateService;
import com.example.service.admin.RoleService;
import com.example.service.admin.RuleService;
import com.example.service.admin.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/admin", produces = APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "系统管理")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/manager/list")
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    public JSONResult FindAllManager(Integer page, Integer limit){
       System.out.println("页数："+page+"  条数:"+limit );
        JSONResult result= userService.findAllManager(page,limit);
        return result;
    }

    @Autowired
    RoleService roleService;

    @GetMapping("/role/list")
    @ApiOperation(value = "获取角色列表", notes = "获取所有角色信息")
    public JSONResult FindAllRole(Integer page, Integer limit){
        System.out.println("页数："+page+"  条数:"+limit );
        JSONResult result=  roleService.findAll(page,limit);
        return result;
    }
    @GetMapping("/role/add")
    public String AddRole(){
        return null;
    }
    @GetMapping("/role/edit")
    public String EditRole(){
        return null;
    }
    @GetMapping("/role/delete")
    public String DeleteRole(){
        return null;
    }

    @Autowired
    RuleService ruleService;

    @GetMapping("/rule/list")
    @ApiOperation(value = "获取权限列表", notes = "获取所有权限信息")
    public JSONResult FindAllRule(Integer page, Integer limit){
        System.out.println("页数："+page+"  条数:"+limit );
        return ruleService.findAllRule(page, limit);
    }

    @GetMapping("/rule/add")
    public String AddRule(){
        return null;
    }
    @GetMapping("/rule/edit")
    public String EditRule(){
        return null;
    }
    @GetMapping("/rule/delete")
    public String DeleteRule(){
        return null;
    }

    @Autowired
    CateService cateService;

    @GetMapping("/cate/list")
    @ApiOperation(value = "获取权限分类列表", notes = "获取所有权限分类信息")
    public JSONResult FindAllCate(Integer page, Integer limit) {
        System.out.println("页数："+page+"  条数:"+limit );
        return cateService.findAllCate(page, limit);
    }

    @ApiOperation(value = "添加权限分类列表", notes = "添加所有权限分类信息")
    @ApiImplicitParam(name = "cate", value = "权限分类实体user", required = true, dataType = "Cate")
    @ApiResponses({ @ApiResponse(code = 400, message = "无效的权限分类信息") })
    @RequestMapping(value = "/cate/add", method = RequestMethod.POST)
    public JSONResult AddCate(Cate cate){
        return cateService.addCate(cate);
    }
    @GetMapping("/cate/edit")
    @ApiOperation(value = "修改权限分类列表", notes = "修改所有权限分类信息")
    public JSONResult EditCate(Cate cate){
        return cateService.updateCate(cate);
    }
    @ApiOperation(value = "删除权限分类列表", notes = "删除所有权限分类信息")
    @RequestMapping(value = "/cate/delete/{id}", method = RequestMethod.DELETE)
    public JSONResult DeleteCate(Integer cateid){
        return cateService.deleteCate(cateid);
    }
}
