package com.ying.sell.dataobject;


/*
     类目实体类
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
public class ProductCategory{
        //类目id 主键
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer categoryId;
        //类目名字
        private String categoryName;
        //类目编号
        private Integer categoryType;
        //创建时间
        private Date createTime;
        //跟新时间
        private Date updateTime;

        public ProductCategory(String categoryName, Integer categoryType) {
                this.categoryName = categoryName;
                this.categoryType = categoryType;
        }
}
