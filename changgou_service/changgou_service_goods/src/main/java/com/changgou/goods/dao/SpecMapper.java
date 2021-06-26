package com.changgou.goods.dao;

import com.changgou.goods.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Repository//无法装配到bean
public interface SpecMapper extends Mapper<Spec> {

    @Select("select name,options from tb_spec where template_id in (select template_id from tb_category where name = #{name} ) order by seq")
    public List<Map> findMapByCategoryName(@Param("name") String name);
}
