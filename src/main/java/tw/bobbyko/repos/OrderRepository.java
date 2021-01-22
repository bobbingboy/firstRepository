package tw.bobbyko.repos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface OrderRepository extends JpaRepository<OrderEntity, Long>  {

//	@Query(value = "select orderUid, amount, total, status from OrderEntity where orderUid = ?1")
//	OrderEntity findByOrderUid(Long orderUid);
//	
//	@Query(value = "select memberUid, amount, total, status from OrderEntity where memberUid = ?1")
//	List<OrderEntity> findByMemberUid(Long memberUid);
//	
//	@Query(value = "select orderTime, amount, total, status from OrderEntity where orderTime between ?1 and ?2")
//	List<OrderEntity> findByOrderTime(Timestamp date1,Timestamp date2);
}
