package com.vintage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vintage.model.ShoppingCart;



public interface ShoppingCartService {
List<ShoppingCart> getList(String shopper);
	
	void insert(ShoppingCart shoppingCart);
	
	void update(ShoppingCart shoppingCart);
	
	void deleteItem(int id);
	
	void delete(String shopper);
	
	int getBuyCount(String shopper);
	
	ShoppingCart get(@Param("shopper") String shopper,@Param("goodsId") int goodsId);

}
