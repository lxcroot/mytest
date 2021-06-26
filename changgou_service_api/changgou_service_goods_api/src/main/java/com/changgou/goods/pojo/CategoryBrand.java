package com.changgou.goods.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 实体类
 * @author Administrator
 *
 */
@Table(name="tb_category_brand")
public class CategoryBrand {
    @Column(name = "category_id")
    private Integer categoryId;//分类ID
    @Column(name = "brand_id")
    private Integer brandId;//分类ID

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
