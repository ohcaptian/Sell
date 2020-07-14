package com.ying.sell.service;


import com.ying.sell.dataobject.SellerInfo;

public interface SellerService {


    SellerInfo findSellerInfoByOpenid(String openid);
}
