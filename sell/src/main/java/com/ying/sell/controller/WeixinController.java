package com.ying.sell.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
/*
        微信网页授权
        普通公众号没有网页授权权限
        使用微信测试号进行测试
 */
public class WeixinController {
            @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
                    log.info("进入auth方法。。。");
                    log.info("code={}",code);
                    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9e540cb45d25e3dd&secret=534a5bae2a89875397be28aba8a1a82f&code=033qKGHx1v8yQc02HDHx1ACGHx1qKGHl&grant_type=authorization_code";
                    RestTemplate restTemplate = new RestTemplate();
                    String res = restTemplate.getForObject(url,String.class);
                    log.info(res);
                }
}
