package com.ying.sell.config;


import lombok.Data;
import org.springframework.stereotype.Component;

/*
    可以使用yaml方式注入
    这里为了方便起见
    将参数写死
 */
@Data
@Component
public class WeChatAccountConfig {

    private  String mpAppid;
    private String mpAppSecret;
    public WeChatAccountConfig(){
        mpAppid="wx9e540cb45d25e3dd";
        mpAppSecret="534a5bae2a89875397be28aba8a1a82f";
    }
}
