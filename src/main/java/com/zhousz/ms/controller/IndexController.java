package com.zhousz.ms.controller;

import com.zhousz.ms.domain.SysUser;
import com.zhousz.ms.redis.RedisService;
import com.zhousz.ms.redis.SysUserKey;
import com.zhousz.ms.util.CodeMsg;
import com.zhousz.ms.util.Result;
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

    @Autowired
    private RedisService redisService;

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
        model.addAttribute("name", "zhousz");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/user")
    public Result<List<SysUser>> getUser() {
        List<SysUser> list = sysUserService.getSysUserList();
        if (ValidateUtil.isEmpty(list)){
            return Result.error(CodeMsg.COLL_EMPTY);
        }
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping(value = "/redis/set")
    public  Result<Object> redisSet(){
        List<SysUser> sysUserList = sysUserService.getSysUserList();
        Result<Object> result = new Result<Object>();
        try{
            if (ValidateUtil.isNotEmpty(sysUserList)) {
                redisService.set(SysUserKey.getListPrefix, "", sysUserList);
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


}
