package com.ying.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品状态
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

}
