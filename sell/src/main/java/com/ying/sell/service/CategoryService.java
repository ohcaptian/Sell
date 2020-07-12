package com.ying.sell.service;

import com.ying.sell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findone(Integer categoryId);
    List<ProductCategory> findall();
    List<ProductCategory> findByType(List<Integer> list);
    ProductCategory save(ProductCategory productCategory);
}
