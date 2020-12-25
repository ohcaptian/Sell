package com.ying.sell.controller;
/**
 * @author 17694
 * @date 2020/10/23
 **/
import com.ying.sell.dataobject.SellerInfo;
import com.ying.sell.service.SellerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * @ClassName : SellUserController 
 * @Description : 用户登入登出  
 */
/*@Controller
@Api("卖家登入")
@RequestMapping("/seller")
public class SellUserController {
    @Autowired
   private SellerService sellerService;
    @GetMapping("/login")
            public String sellerLogin(@RequestParam(value="name", required = false) String name, @RequestParam(value="password", required = false) String password, Model model){
                List<SellerInfo> sellerInfoList = sellerService.findSellerInfo();
                //验证用户信息
                for (SellerInfo sellerInfo:sellerInfoList) {
                    if((sellerInfo.getUsername().equals(name))&&(sellerInfo.getPassword().equals(password))){
                                return "product/index";
                    }
                }
                model.addAttribute("msg","登入失败");
                return "redirect:/";
            }
    @GetMapping("/logout")
    public String sellerLogout(){
        return "admin/logout";
    }
}  */
