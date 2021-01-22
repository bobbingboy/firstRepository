package tw.bobbyko.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectService {
	@Autowired
	private SelectDAO sDAO;
		
	public String select(Userdata rBean) {
		return sDAO.select(rBean);
	}
	
	public List<Userdata> selectAll(Userdata rBean) {
		return sDAO.selectAll(rBean);
	}
}
