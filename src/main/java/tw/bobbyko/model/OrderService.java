package tw.bobbyko.model;

import tw.bobbyko.model.OrderAddReq;
import tw.bobbyko.model.OrderAddResp;
//import team.takoyaki.vo.OrderInquireReq;
//import team.takoyaki.vo.OrderInquireResp;

public interface OrderService {
	
	/**
	 * 新增訂單
	 * 
	 * @param req
	 * @return
	 */
	public OrderAddResp orderAdd(OrderAddReq req);
	
	/**
	 * 查詢訂單
	 * 
	 * @param req
	 * @return
	 */
//	public OrderInquireResp orderInquire(OrderInquireReq req);


}
