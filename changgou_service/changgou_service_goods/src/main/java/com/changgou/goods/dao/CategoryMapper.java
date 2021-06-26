package com.changgou.goods.dao;

import com.changgou.goods.pojo.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository//无法装配到bean
public interface CategoryMapper extends Mapper<Category> {
}
