package tw.bobbyko.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bobbyko.model.LoginService;
import tw.bobbyko.model.Userdata;

@Controller
public class LoginController {

	@Autowired
	LoginService lService = new LoginService();

	@GetMapping(path = "/")
	public String processMainPage() {
		return "index";
	}

	@PostMapping(path = "/login.checkController")
	public String processAction(
			@RequestParam(name = "user_acc") String user_acc,
			@RequestParam(name = "user_pwd") String password,
			Model m) {

		Userdata uBean = new Userdata();

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		if (user_acc == null || user_acc.length() == 0) {
			errors.put("msg_acc", "Please Enter Account!!");
		}

		if (password == null || password.length() == 0) {
			errors.put("msg_pwd", "Please Enter Password!!");
		}

		if (errors != null && !errors.isEmpty()) {
			return "index";
		}

		uBean.setUser_acc(user_acc);
		uBean.setUser_pwd(password);

		boolean loginResult = lService.checkLogin(uBean);

		if (loginResult) {
			// SUCCESS, select personal data and show it in resultPage.
			Userdata result = lService.showdata(uBean);
			m.addAttribute("username", result.getUsername());
			m.addAttribute("phone", result.getUser_phone());
			m.addAttribute("birthday", result.getBirthday());
			m.addAttribute("email", result.getEmail());
			return "resultPage";
		} else {
			return "index";
		}

	}
}
