package com.ying.sell.controller;


import com.ying.sell.Vo.ResultVo;
import com.ying.sell.converter.OrderForm2OrderDTOConverter;
import com.ying.sell.dto.OrderDTO;
import com.ying.sell.enums.ResultEnum;
import com.ying.sell.exception.SellException;
import com.ying.sell.form.OrderForm;
import com.ying.sell.service.OrderService;
import com.ying.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
@Api(value = "订单控制")
public class BuyerOrderController {
            //创建订单
    //6.10-6.11
    @Autowired
    private OrderService orderService;
    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
                public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
                            if(bindingResult.hasErrors()){
                                log.error("参数不正确",orderForm);
                                throw new SellException(ResultEnum.PARAM_ERROR);
                            }
                    OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
                            if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
                                log.error("购物车为空");
                                throw new SellException(ResultEnum.CART_EMPTY);
                            }
                    OrderDTO createresult = orderService.create(orderDTO);

                            Map<String,String> map = new HashMap<>();
                            map.put("orderId",createresult.getOrderId());
                            return ResultVOUtil.success(map);
                }


            //订单列表
            @ApiOperation(value = "查询所有订单")
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam(value = "openid")String openid,
                                         @RequestParam(value="page", defaultValue ="0") Integer page,
                                         @RequestParam(value = "size", defaultValue ="10") Integer size){
        if(StringUtils.isEmpty(openid)){
                log.error("openid为空");
                throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    @GetMapping("/detail")
    @ApiOperation(value = "订单详情")
    public ResultVo<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        //TODO
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultVOUtil.success(orderDTO);
//        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
//        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    @ApiOperation("取消订单")
    public ResultVo cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
//        buyerService.cancelOrder(openid, orderId);
        //TODO not safe;
        orderService.cancel(orderService.findOne(orderId));
        return ResultVOUtil.success();
    }



}
