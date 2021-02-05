package com.vintage.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ShoppingOrderDetail {
	private Integer id;

    private Integer shoppingorderid;

    private Integer goodsid;

    private Integer qty;

    private BigDecimal totalprice;

    private String createby;

    private Date createtime;
}

//If there is any problem occured, find the original ShoppingOrderDetail file.