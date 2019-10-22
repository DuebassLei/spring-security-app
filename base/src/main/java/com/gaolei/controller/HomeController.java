package com.gaolei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: GaoLei
 * @Date: 2019/10/22 18:46
 * @Blog https://blog.csdn.net/m0_37903882
 * @Description:
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
