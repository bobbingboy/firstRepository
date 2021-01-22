package tw.bobbyko.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.bobbyko.repos.OrderRepository;
import tw.bobbyko.repos.OrderEntity;
import tw.bobbyko.model.OrderAddReq;
import tw.bobbyko.model.OrderAddResp;
//import team.takoyaki.vo.OrderInquireReq;
//import team.takoyaki.vo.OrderInquireResp;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public OrderAddResp orderAdd(OrderAddReq req) {
		repository.save(setOrderEntity(req));
		OrderAddResp orderAddResp = new OrderAddResp();
		orderAddResp.setSuccess(true);
		return orderAddResp;
		
	}

//	@Override
//	public OrderInquireResp orderInquire(OrderInquireReq req) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/**
	 * OrderAddReq轉OrderEntity
	 * 
	 * @param req
	 * @return
	 */
	
	private OrderEntity setOrderEntity(OrderAddReq req) {
		//1.convert Bean for frontend to Bean for backend, 
		//so in this step it`s Bean to Bean.
		//2.use Bean for backend to execute CRUD and save it to database.
		OrderEntity orderEntity = new OrderEntity();
		
		orderEntity.setUsername(req.getUsername());
		orderEntity.setUserpwd(req.getUserpwd());
		
		return orderEntity;
	}	
	
}
