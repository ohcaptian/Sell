package com.ying.sell.repository;

import com.ying.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    dao
    类目表jpa
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
               List<ProductCategory> findBycategoryTypeIn(List<Integer> categoryTypeList);
}
