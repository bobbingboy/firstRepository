package com.vintage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vintage.model.RespMsg;
import com.vintage.model.ShoppingCart;
import com.vintage.service.ShoppingOrderService;

@Controller
public class ShoppingCartTestController {
	
	private ShoppingOrderService shoppingOrderService;
	
	//json : {"goodsid" : "xxx", "goodsqty" : "yyy"}
	@PostMapping(value = "/addToShoppingCart", produces = "/application/json;charset=utf-8")
	public RespMsg addToShoppingCart (@RequestBody Map<String, Integer> json) {
		int goodsId = json.get("goodsid");
		int qty = json.get("goodsqty");
		RespMsg msg = new RespMsg();
		
		if (goodsId <= 0) {
			msg.setCode(101);
			msg.setMsg("產品ID無效");
			return msg;
		}
		
		String shopper = ""; //get user by security Session.
		ShoppingCart shoppingCart = new ShoppingCart(0, shopper, goodsId, qty, new Date());
		
		shoppingOrderService.insertShoppingCart(shoppingCart);
		
		msg.setCode(0);
		msg.setMsg("加入購物車成功");
		
		int cartCount = shoppingOrderService.getShoppingCartBuyCount(shopper);
		HashMap<String, Object> data = new HashMap<>();
		data.put("cartCount", cartCount);
		
		msg.setData(data);
		
		return msg;
		
	}
}
