package com.vintage.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String shopper;
	private int goodsId;
	private int qty;
	private Date addedTime;
//	private Goods inGoods;
	
	
	public ShoppingCart(int id,String shopper,int goodsId,int qty,Date addedTime) {
		this.id=id;
		this.shopper=shopper;
		this.goodsId=goodsId;
		this.qty=qty;
		this.addedTime=addedTime;
	}
	
}
