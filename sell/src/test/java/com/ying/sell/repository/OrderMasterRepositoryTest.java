package com.ying.sell.repository;

import com.ying.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    private final String openId = "110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("小光");
        orderMaster.setBuyerPhone("12343232367");
        orderMaster.setBuyerAddress("腾讯");
        orderMaster.setBuyerOpenid(openId);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
    PageRequest request =PageRequest.of(0,1);
    Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(openId, request);
    Assert.assertNotEquals(0,result.getTotalElements());
}
}