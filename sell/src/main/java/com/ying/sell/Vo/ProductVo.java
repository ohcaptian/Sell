package com.ying.sell.Vo;
/*
       新建一个对象
       返回给前端需要的内容
       提高安全性隐私性
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {
    //JsonProperty 返回给前端的名字
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
