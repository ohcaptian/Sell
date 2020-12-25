package com.ying.sell.service;


import com.ying.sell.dataobject.SellerInfo;

import java.util.List;

public interface SellerService {

        List<SellerInfo> findSellerInfo();
    //SellerInfo findSellerInfoByOpenid(String openid);
}
