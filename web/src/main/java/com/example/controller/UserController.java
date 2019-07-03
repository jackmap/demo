package com.example.controller;

import com.example.entity.sys.R;
import com.example.entity.sys.User;
import com.example.service.admin.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE) //配置返回值 application/json
@Api(description = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public R list() {
        try {
            return R.isOk().data(userService.findAll());
        } catch (Exception e) {
            return R.isFail(e);
        }
    }
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @ApiResponses({ @ApiResponse(code = 400, message = "无效的用户信息") })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public R User(User user) {
        if(StringUtils.isEmpty(user.getUsername()) &&StringUtils.isEmpty(user.getPassword())){
            return     userService.addUser(user);
        }else{
            return new R(1,"账户或密码不能为空");
        }
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User getUser(@ApiParam(value = "用户id", required = true)
                        //[注意] @ApiParam与 Controller中方法并列使用,也可以省略的
                        @PathVariable(value = "id") Integer id) {
        System.out.println("传值：用户id："+id);
        return userService.findById(id);
    }



    @ApiOperation(value = "根据用户id删除用户", notes = "删除用户")
    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.DELETE)
    public  R deleteUser(@ApiParam(value = "用户id", required = true)@PathVariable Integer id) {
        System.out.println("传值：用户id："+id);
        R r = userService.DeleteById(id);
        System.out.println(r);
        return r;
    }
}
