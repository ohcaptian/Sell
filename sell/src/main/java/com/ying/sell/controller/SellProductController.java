package com.ying.sell.controller;


import com.ying.sell.dataobject.ProductCategory;
import com.ying.sell.dataobject.ProductInfo;
import com.ying.sell.exception.SellException;
import com.ying.sell.form.ProductForm;
import com.ying.sell.service.CategoryService;
import com.ying.sell.service.ProductService;
import freemarker.template.utility.StringUtil;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/seller/product")
public class SellProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
            @GetMapping("/list")
            public ModelAndView productList(@RequestParam(value ="page",defaultValue = "1")Integer page, @RequestParam(value ="size" ,defaultValue = "10") Integer size,
                                            Map<String,Object> map){

                PageRequest request = PageRequest.of(page-1,size);
                Page<ProductInfo> productInfoPage = productService.findAll(request);
                map.put("productInfoPage",productInfoPage);
                map.put("currentPage",page);
                return  new ModelAndView("product/list",map);
            }
                /*
                商品上架
                 */
            @GetMapping("/on_sale")
            public ModelAndView onSale(@RequestParam("productId")String productId, Map<String,Object> map){

                try{
                    productService.onSale(productId);
                }catch (SellException e){
                    map.put("msg",e.getMessage());
                    map.put("url","/sell/seller/product/list");
                    return  new ModelAndView("common/error",map);
                }
                map.put("url","/sell/seller/product/list");
                return  new ModelAndView("common/success",map);
            }
            /*
            商品下架
             */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId")String productId, Map<String,Object> map){

        try{
            productService.offSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return  new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return  new ModelAndView("common/success",map);
    }
    @GetMapping("/index")
    public ModelAndView update(@RequestParam(value = "productId",required = false)String productId,Map<String,Object>map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }
                List<ProductCategory>  categoryList =categoryService.findAll();
                map.put("categoryList",categoryList);
                return new ModelAndView("product/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult,Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/list");
            return  new ModelAndView("common/error",map);
        }
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productForm,productInfo);
        try{
            productService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");
        return  new ModelAndView("common/success",map);





    }


}
