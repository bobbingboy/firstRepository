package tw.bobbyko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.bobbyko.model.OrderService;
import tw.bobbyko.model.OrderAddReq;
import tw.bobbyko.model.OrderAddResp;
//import team.takoyaki.vo.OrderInquireReq;
//import team.takoyaki.vo.OrderInquireResp;

@RestController
@RequestMapping(value = "order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(path = "yyy")
	public String processMainPage() {
		return "test1";
	}
	
	@PostMapping(path = "add")
	public OrderAddResp orderAdd(@RequestBody OrderAddReq req) {
		//use @RequestBody to get JSON data then convert to Bean form.
		//then use the Bean form to enter backend.
		return orderService.orderAdd(req);
	}
	
//	@PostMapping(path ="/inquire")
//	public OrderInquireResp orderInquire(OrderInquireReq req) {
//		return orderService.orderInquire(req);
//	}
	
}
