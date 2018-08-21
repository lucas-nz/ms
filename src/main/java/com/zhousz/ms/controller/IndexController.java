package com.zhousz.ms.controller;

import com.zhousz.ms.domain.CaPerson;
import com.zhousz.ms.domain.SysUser;
import com.zhousz.ms.redis.CaPersonKey;
import com.zhousz.ms.redis.RedisService;
import com.zhousz.ms.redis.SysUserKey;
import com.zhousz.ms.service.CaPersonService;
import com.zhousz.ms.service.SysUserService;
import com.zhousz.ms.util.CodeMsg;
import com.zhousz.ms.util.Result;
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

    @Autowired
    private RedisService redisService;

    @Autowired
    private CaPersonService caPersonService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/result")
    public Result<String> getResult() {
        return Result.success("hello, util");
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<SysUser> sysUserList = sysUserService.getSysUserList();
        model.addAttribute("sysUserList", sysUserList);
        return "index";
    }




    @ResponseBody
    @RequestMapping(value = "/user")
    public Result<List<SysUser>> getSysUser() {
        List<SysUser> sysUserList = sysUserService.getSysUserList();
        return Result.success(sysUserList);
    }
    @ResponseBody
    @RequestMapping(value = "/redis/set")
    public  Result<Object> redisSet(){
        List<CaPerson> list = caPersonService.getAllCaPerson();
        Result<Object> result = new Result<Object>();
        try{
            if (ValidateUtil.isNotEmpty(list)) {
                redisService.set(CaPersonKey.getListPrefix, "", list);
            }
            result = Result.success(true);
        }catch (Exception e){
            e.printStackTrace();
            result = Result.error(CodeMsg.SERVER_ERROR);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/redis/get")
    public Result<Object> redisGet() {
        Object listString = redisService.get(SysUserKey.getListPrefix, "");
        return Result.success(listString);
    }

    @ResponseBody
    @RequestMapping("/db/getCaperson")
    public Result<Object> dbGetCaPerson() {
        List<CaPerson> list = caPersonService.getAllCaPerson();
        return Result.success(list);
    }

}
