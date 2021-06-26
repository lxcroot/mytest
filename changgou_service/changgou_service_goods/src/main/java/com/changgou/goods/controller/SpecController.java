package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.goods.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spec")
public class SpecController {

    @Autowired
    private SpecService specService;


    @RequestMapping("/findMapByCategoryName.do/{name}")
    public Result findMapByCategoryName(@PathVariable String name){
        List<Map> list = specService.findMapByCategoryName(name);
        return  new Result(true,200,"查询成功",list);
    }
}
