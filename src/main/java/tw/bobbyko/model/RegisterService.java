package tw.bobbyko.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	@Autowired
	private RegisterDAO rDAO;
		
	public Userdata insert(Userdata rBean) {
		return rDAO.insert(rBean);
	}
	
	public boolean checkExist(Userdata rBean) {
		return rDAO.checkExist(rBean);
	}
}
