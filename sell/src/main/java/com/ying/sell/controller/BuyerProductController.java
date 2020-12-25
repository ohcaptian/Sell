package com.ying.sell.controller;


import com.ying.sell.Vo.ProductInfoVO;
import com.ying.sell.Vo.ProductVo;
import com.ying.sell.Vo.ResultVo;
import com.ying.sell.dataobject.ProductCategory;
import com.ying.sell.dataobject.ProductInfo;
import com.ying.sell.service.CategoryService;
import com.ying.sell.service.ProductService;
import com.ying.sell.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */

@RestController
@RequestMapping("/buyer/product")
@Api(value = "提供给买家的商品信息")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /*
            Arrays.asList 该方法是将数组转化为list
     */
    //查询上架商品
    //查询类目
    //一次性查询
    //返回Vo视图
    @GetMapping("/list")
    public ResultVo list() {
        //1,查询所有商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2,查询类目
        List<Integer> categoryTypeList = new ArrayList<>();
        //把类型存到数组中;
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByType(categoryTypeList);
        //3 数据拼接
        List<ProductVo> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            //属性赋值，将productCategory值赋值给productVO，返回给前端
            ProductVo productVO = new ProductVo();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        /*

        ResultVo resultVo = new ResultVo();
        resultVo.setData(productVOList);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
         */
        //用工具类 对这串代码进行封装;
        return ResultVOUtil.success(productVOList);
    }
}