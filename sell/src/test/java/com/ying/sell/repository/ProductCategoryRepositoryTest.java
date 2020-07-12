package com.ying.sell.repository;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.javaws.IconUtil;
import com.ying.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public  class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void add(){
        ProductCategory poductCategory = new ProductCategory();
        poductCategory.setCategoryType(23);
        poductCategory.setCategoryName("只能白尼");
        repository.save(poductCategory);
    }
        @Test
    public void findall(){
            List<ProductCategory> list = repository.findAll();
                    for(ProductCategory pro:list){
                        System.out.println(pro);
                    }

        }
        @Test
    public void findone(){
        Optional<ProductCategory> poductCategory = repository.findById(1);
        System.out.println(poductCategory);
    }
    @Test
    public  void updata(){
        Optional<ProductCategory> poductCategory = repository.findById(1);
        ProductCategory poduc =  poductCategory.get();
        poduc.setCategoryType(11);
        repository.save(poduc);
    }
    @Test
    /*
    Arrays 操作数组的对象
     */
    public  void findByType(){
        List<Integer> list = Arrays.asList(11);
        List<ProductCategory> pro= repository.findBycategoryTypeIn(list);
        ProductCategory productCategory = pro.get(0);
        System.out.println(productCategory);

    }

}