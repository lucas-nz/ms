package com.zhousz.ms.controller;


import com.zhousz.ms.service.MsUserService;
import com.zhousz.ms.util.Result;
import com.zhousz.ms.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private MsUserService msUserService;


    @RequestMapping("/to_login")
    public String to_login() {
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo) {
        Boolean login = msUserService.login(loginVo);
        return Result.success(login);
    }


}
