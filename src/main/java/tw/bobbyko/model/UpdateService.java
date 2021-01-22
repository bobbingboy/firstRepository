package tw.bobbyko.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {

	@Autowired
	private UpdateDAO uDAO;

	public boolean update(
			String user_acc,
			String user_pwd,
			String user_phone,
			String user_birth,
			String user_email) {
		return uDAO.update(
				user_acc,
				user_pwd,
				user_phone,
				user_birth,
				user_email);
	}
}
