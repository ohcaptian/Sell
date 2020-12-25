package com.ying.sell.service.impl;/**
 * @author 17694
 * @date 2020/10/23
 **/

import com.ying.sell.dataobject.SellerInfo;
import com.ying.sell.repository.SellerInfoRepository;
import com.ying.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : SellerServiceImpl 
 * @Description : 卖家信息表service层
 */
@Service
public class SellerServiceImpl implements SellerService {
        @Autowired
        SellerInfoRepository sellerInfoRepository;

    @Override
    public List<SellerInfo> findSellerInfo() {
        return sellerInfoRepository.findAll();
    }
}
