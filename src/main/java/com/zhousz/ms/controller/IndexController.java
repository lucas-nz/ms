package com.zhousz.ms.controller;

import com.zhousz.ms.domain.SysUser;
import com.zhousz.ms.result.CodeMsg;
import com.zhousz.ms.result.Result;
import com.zhousz.ms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.security.validator.Validator;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/result")
    public Result<String> getResult() {
        return Result.success("hello, result");
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name", "zhousz");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public Result<List<SysUser>> getUser() {
        List<SysUser> list = sysUserService.getSysUserList();
        if (list.isEmpty()){
            return Result.error(CodeMsg.LIST_EMPTY);
        }
        return Result.success(list);
    }
}
