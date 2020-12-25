package com.ying.sell.service.impl;

import com.ying.sell.dataobject.SellerInfo;
import com.ying.sell.service.SellerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 17694
 * @date 2020/10/23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class SellerServiceImplTest {
        @Autowired
       private SellerServiceImpl sellerService;
    @Test
    void findSellerInfo() {
        List<SellerInfo> sellerInfo = sellerService.findSellerInfo();
        Assert.assertNotEquals(0,sellerInfo.size());
    }
}