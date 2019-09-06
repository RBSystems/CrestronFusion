package com.ztfd.crestronFusion.controller;

import com.ztfd.crestronFusion.servlet.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService service){
        loginService=service;
    }


    @RequestMapping("/login")
    @ResponseBody
    public Integer login(@RequestParam String name,@RequestParam String pwd){
        System.out.println(name+","+pwd);
        return loginService.login(name,pwd,"RoomView Administrators");
    }

}
