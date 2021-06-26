package com.changgou.goods.dao;

import com.changgou.goods.pojo.CategoryBrand;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository//无法装配到bean
public interface CategoryBrandMapper extends Mapper<CategoryBrand> {
}
