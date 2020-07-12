package com.ying.sell.repository;

import com.ying.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
        dao
        商品表jpa接口
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
        /*
            查询上架的商品
         */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
