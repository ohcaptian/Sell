package com.ying.sell.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;
    @Column(name="seller_name")
    private String username;

    private String password;
}
