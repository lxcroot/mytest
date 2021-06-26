package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.entity.Goods;
import com.changgou.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    //添加
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods){

        spuService.add(goods);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    //根据id查询
    @RequestMapping("/{id}")
    public Result findById(@PathVariable String id){

        Goods goodsById = spuService.findGoodsById(id);

        return new Result(true,StatusCode.OK,"查询成功",goodsById);
    }
    //修改@param goods @param id
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Goods goods,@PathVariable String id){
        spuService.update(goods);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    //需要校验是否是被删除的商品，如果未删除则修改审核状态为1，并自动上架
    /**
     * 审核
     * @param id
     * @return
     */
    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable String id){
        spuService.audit(id);
        return new Result();
    }


    /**
     * 下架
     * @param id
     * @return
     */
    @PutMapping("/pull/{id}")
    public Result pull(@PathVariable String id){
        spuService.pull(id);
        return new Result();
    }
    /**
     * 上架
     * @param id
     * @return
     */
    @PutMapping("/put/{id}")
    public Result put(@PathVariable String id){
        spuService.put(id);
        return new Result();
    }



    /**
     * 物理删除
     * @param id
     * @return
     */
    @DeleteMapping("/realDelete/{id}")
    public Result realDelete(@PathVariable String id){
        spuService.realDelete(id);
        return new Result();
    }

}
