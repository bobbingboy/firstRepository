package tw.bobbyko.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private LoginDAO lDAO;
		
	public boolean checkLogin(Userdata rBean) {
		return lDAO.checkLogin(rBean);
	}
	
	public Userdata showdata(Userdata rBean) {
		return lDAO.showdata(rBean);
	}
}
