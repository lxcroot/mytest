package com.changgou.system.service;

import com.changgou.goods.pojo.Admin;

public interface AdminService {

    //添加
    public void add(Admin admin);


    //验证
    public boolean login(Admin admin);
}
