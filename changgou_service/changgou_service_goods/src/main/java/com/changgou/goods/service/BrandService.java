package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /***
     * 查询所有品牌
     * @return
     */
    public List<Brand> findAll();

    //根据品牌id查询
    public Brand findById(Integer id);

    //添加
    public void add(Brand brand);

    //修改
    public void update(Brand brand);

    //删除
    public void delete(Integer id);


    /***
     * 多条件搜索品牌方法
     * @param searchMap
     * @return
     */
    public List<Brand> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<Brand> findPage(int page, int size);


    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Brand> findPage(Map<String, Object> searchMap, int page, int size);



    //根据分类名称查询规格列表
    public List<Brand> findMapByCategoryName(String name);
}