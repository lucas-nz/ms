package com.zhousz.ms.controller;

import com.zhousz.ms.domain.SysUser;
import com.zhousz.ms.util.CodeMsg;
import com.zhousz.ms.util.ResultUtil;
import com.zhousz.ms.service.SysUserService;
import com.zhousz.ms.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResultUtil<String> getResult() {
        return ResultUtil.success("hello, util");
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name", "zhousz");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public ResultUtil<List<SysUser>> getUser() {
        List<SysUser> list = sysUserService.getSysUserList();
        if (ValidateUtil.isEmpty(list)){
            return ResultUtil.error(CodeMsg.COLL_EMPTY);
        }
        return ResultUtil.success(list);
    }
}
