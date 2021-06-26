package com.changgou.system.controller;


import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Admin;
import com.changgou.system.service.AdminService;
import com.changgou.system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //添加
    @RequestMapping("/add")
    public Result add(@RequestBody Admin admin){
        try {
            if (admin==null){
                return new Result(false, StatusCode.ERROR,"数据为空!");
            }else{
                adminService.add(admin);
                return new Result(true, StatusCode.OK,"添加成功!");
            }

        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"添加失败!",e.getMessage());
        }

    }
    //验证登录
    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin){
        try {
            boolean login = adminService.login(admin);
            if (login){
                Map<String,String> info = new HashMap<>() ;
                info.put("username",admin.getLogin_name());

                String token = JwtUtil.createJWT(UUID.randomUUID().toString(), admin.getLogin_name(), null);
                info.put("token",token);

                return new Result(true, StatusCode.OK,"登录成功!",info);
            }else{
                return new Result(false, StatusCode.LOGINERROR,"登录失败!");
            }
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"登陆失败!!!",e.getMessage());
        }
    }

    //测试
    @RequestMapping("/test")
    public Result test() {

        return new Result(true, StatusCode.OK,"登录成功!");

    }

}
