package com.ying.sell.service.impl;


import com.ying.sell.dataobject.ProductCategory;
import com.ying.sell.repository.ProductCategoryRepository;
import com.ying.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
        类目
        接口的实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public ProductCategory findone(Integer categoryId) {
        return productCategoryRepository.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findall() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByType(List<Integer> list) {
        return productCategoryRepository.findBycategoryTypeIn(list);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
