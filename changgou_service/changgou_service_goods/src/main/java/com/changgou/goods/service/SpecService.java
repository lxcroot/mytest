package com.changgou.goods.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecService {

    public List<Map> findMapByCategoryName(String name);
}
