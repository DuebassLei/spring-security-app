package com.gaolei.controller;


import com.gaolei.bean.WebResponse;
import com.gaolei.entity.UserDO;
import com.gaolei.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {

    private final UserService userService;

    @PostMapping("/register")
    public WebResponse doRegister(@RequestBody UserDO userDO){
        // 此处省略校验逻辑
        userService.insert(userDO);
        return WebResponse.success("注册成功");
    }

}
