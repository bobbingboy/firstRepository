package com.vintage.service;

import java.util.List;

import com.vintage.model.ShoppingCart;
import com.vintage.model.ShoppingOrder;
import com.vintage.model.ShoppingOrderDetail;



public interface ShoppingOrderService {
	ShoppingOrder shoppingOrder(int id);
	
ShoppingOrder getShoppingOrder(int id);
	
	List<ShoppingOrder> getShoppingOrderList(String shopper);
	
	List<ShoppingOrderDetail> getShoppingOrderDetail(int orderId);
	
	boolean createShoppingOrderByShopper(String shopper);
	
	void insertShoppingOrderWithDetail(ShoppingOrder order,List<ShoppingOrderDetail> orderDetails);
	
	void deleteShoppingOrderDetail(int orderDetailId);
	
	void deleteShoppingOrderWithDetail(int orderId);
	
	void updateShoppingOrder(ShoppingOrder order);
	
	List<ShoppingCart> getShoppingCartList(String shopper);
	
	int getShoppingCartBuyCount(String shopper);
	
	void insertShoppingCart(ShoppingCart shoppingCart);
	
	void deleteShoppingCart(int shoppingCartId);
	
	void clearShoppingCart(String shopper);
}
