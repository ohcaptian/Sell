package com.ying.sell.service.impl;

import com.ying.sell.dataobject.OrderDetail;
import com.ying.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    private final String BUYER_OPENID = "1101110";
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小张");
        orderDTO.setBuyerAddress("腾讯");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("12345647896");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(11);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单 result{}",result);
    }

    @Test
    void findOne() {
    }

    @Test
    void findList() {
    }

    @Test
    void cancel() {
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }

    @Test
    void testFindList() {
    }
}