package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String Index() {
       return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    /*sys*/
    @RequestMapping("/admin/list")
    public String AdminList() {
        return "/admin/list";
    }
    @RequestMapping("/admin/role")
    public String AdminRole() {
        return "/admin/role";
    }
    @RequestMapping("/admin/rule")
    public String AdminRule() {
        return "/admin/rule";
    }
    @RequestMapping("/admin/cate")
    public String AdminCate() {
        return "/admin/cate";
    }

    /*member*/
    @GetMapping("/member/list")
    public String MemberList() {
        return "member/list";
    }

    @GetMapping ("/member/add")
    public String MemberAdd() {
        return "/member/add";
    }

    @GetMapping("/member/edit")
    public String MemberEdit() {
        return "/member/edit";
    }


    /* *order*/
    @RequestMapping("/order/order-list")
    public String OrderList() {
        return "/order/list";
    }
    @RequestMapping("/order/order-list1")
    public String OrderList1() {
        return "/order/list1";
    }
    @GetMapping("/order/add ")
    public String OrderAdd() {
        return "/order/add";
    }

}
