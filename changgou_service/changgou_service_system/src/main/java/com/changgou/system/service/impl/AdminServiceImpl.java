package com.changgou.system.service.impl;

import com.changgou.goods.pojo.Admin;
import com.changgou.system.dao.AdminMapper;
import com.changgou.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminMapper adminMapper;
    //添加
    @Override
    public void add(Admin admin) {
        //获取盐   //可以省去
        String gensalt = BCrypt.gensalt();
        //将盐和密码加入到一起
        String hashpw = BCrypt.hashpw(admin.getPassword(), gensalt);
        //将加入后的放到admin
        admin.setPassword(hashpw);
        //添加到数据库
        adminMapper.insert(admin);
    }
    //验证
    @Override
    public boolean login(Admin admin) {

        Admin adminOne = new Admin();
        adminOne.setLogin_name(admin.getLogin_name());
        adminOne.setStatus("1");
        //获取数据库中的密码  加密后的
        Admin admin2 = adminMapper.selectOne(adminOne);
        if (admin2 == null){
            return false;

        }else{
            //验证密码, Bcrypt为spring的包, 第一个参数为明文密码, 第二个参数为密文密码
            return  BCrypt.checkpw(admin.getPassword(), admin2.getPassword());

        }




    }
}
