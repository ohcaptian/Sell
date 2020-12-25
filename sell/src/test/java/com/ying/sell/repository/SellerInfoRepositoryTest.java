package com.ying.sell.repository;

import com.ying.sell.dataobject.SellerInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 17694
 * @date 2020/10/23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class SellerInfoRepositoryTest {
            @Autowired
    private SellerInfoRepository sellerInfoRepository;
            @Test
            public void findTest(){
                List<SellerInfo> all = sellerInfoRepository.findAll();
                System.out.println(all);
            }
}