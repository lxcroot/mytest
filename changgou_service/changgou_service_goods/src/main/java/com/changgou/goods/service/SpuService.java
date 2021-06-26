package com.changgou.goods.service;

import com.changgou.goods.entity.Goods;

public interface SpuService {
    /***
     * 新增
     * @param goods
     */
    void add(Goods goods);
    /**
     * 根据ID查询商品
     * @param id
     * @return
     */
    public Goods findGoodsById(String id);

    /***
     * 修改数据
     * @param goods
     */
    void update(Goods goods);

    /**
     * 审核
     * @param id
     */
    public void audit(String id);
    /**
     * 下架商品
     * @param id
     */
    public void pull(String id);
    /**
     * 上架商品
     * @param id
     */
    public void put(String id);

    /**
     * 物理删除
     * @param id
     */
    public void realDelete(String id);

}
