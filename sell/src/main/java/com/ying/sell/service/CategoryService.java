package com.ying.sell.service;

import com.ying.sell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByType(List<Integer> list);
    ProductCategory save(ProductCategory productCategory);
}
