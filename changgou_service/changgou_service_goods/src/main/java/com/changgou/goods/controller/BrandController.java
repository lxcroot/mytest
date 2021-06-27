package com.changgou.goods.controller;


import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {


    @Autowired
    private BrandService brandService;

    //查询全部
    @GetMapping
    //@RequestMapping("/findAll.do")
    public Result findAll(){
        List<Brand> brandList = brandService.findAll();
        System.out.println("333");
        return new Result(true,2000,"成功",brandList);

    }

    //根据id查询
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result(true,2000,"成功",brand);
    }

    //添加
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,2000,"成功");
    }
    //修改
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){

        brand.setId(id);
        brandService.update(brand);
        return new Result(true,2000,"成功");
    }

    //删除
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true,2000,"成功");
    }


    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Brand> list = brandService.findList(searchMap);
        return new Result(true,2000,"成功",list);
    }



    /***
     * 分页搜索实现
     * @param page
     * @param size
     * @return
     */
/*    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        Page<Brand> pageList = brandService.findPage(page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true, StatusCode.OK,"查询成功",pageResult);
    }*/


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Brand> pageList = brandService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    //根据分类名称查询规格列表
   @RequestMapping("/findListByCategoryName.do/{name}")   //基于 restful 访问格式的http请求
    public Result findListByCategoryName(@PathVariable String  name){
        System.out.println("name");
       List<Brand> list = brandService.findMapByCategoryName(name);
        return  new Result(true,200,"查询成功",list);
    }



}
