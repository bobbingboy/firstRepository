package tw.bobbyko.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.bobbyko.model.RegisterService;
import tw.bobbyko.model.Userdata;

@Controller
public class RegisterController {

	@Autowired
	RegisterService rService = new RegisterService();

	@GetMapping(path = "/register.mainPageController")
	public String processMainPage() {
		return "register";
	}

	@PostMapping(path = "/register.checkController")
	public String processAction(
			@RequestParam(name = "userName") String user_acc,
			@RequestParam(name = "userPwd") String user_pwd,
			@RequestParam(name = "name") String username,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "birthday") String birthday,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "authcode") String authcode,
			Model m) {

		Userdata uBean = new Userdata();

		Pattern user_accRegex = Pattern.compile("^\\w{1,16}$");

		Pattern user_pwdRegex = Pattern.compile("^\\w{8,16}$");

		Pattern user_emailRegex = Pattern.compile("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		// check value at every column.

		// for account, password, and email,set the basic form and check them.
		if (user_acc == null || user_acc.length() == 0) {
			errors.put("msg_acc", "You Should Enter Account.");

		} else if (!user_accRegex.matcher(user_acc).find()) {
			errors.put("msg_acc", "WRONG ACCOUNT FORM, Please Choose Another One.");
		}

		if (user_pwd == null || user_pwd.length() == 0) {
			errors.put("msg_pwd", "You Should Enter Password.");

		} else if (!user_pwdRegex.matcher(user_pwd).find()) {
			errors.put("msg_pwd", "WRONG PASSWORD FORM, Please Choose Another One.");
		}

		if (email == null || email.length() == 0) {
			errors.put("msg_email", "You Should Enter Email.");

		} else if (!user_emailRegex.matcher(email).find()) {
			errors.put("msg_email", "WRONG EMAIL FORM, Please Choose Another One.");
		}

		if (username == null || username.length() == 0) {
			errors.put("msg_name", "You Should Enter Name.");

		}

		if (phone == null || phone.length() == 0) {
			errors.put("msg_phone", "You Should Enter Phone.");

		}

		if (birthday == null || birthday.length() == 0) {
			errors.put("msg_birth", "You Should Enter Birthday.");

		}

		if (authcode == null || authcode.length() == 0) {
			errors.put("msg_authcode", "You Should Choose.");

		}
		
		//Check errors Map empty or not.
		if (errors != null && !errors.isEmpty()) {
			return "register";
		}

		uBean.setUser_acc(user_acc);
		boolean result = rService.checkExist(uBean);

		if (result) {
			// execute register
			System.out.println("Account is OK for use");
		} else {
			errors.put("msg_acc", "Account You Entered Has Already Exist" + ", Please Choose Another One");
			System.out.println("check point 2");
			return "register";
		}
		;

		// Check the form of data.

		m.addAttribute("userAccount", user_acc);
		m.addAttribute("userPassword", user_pwd);
		m.addAttribute("userName", username);
		m.addAttribute("phone", phone);
		m.addAttribute("birthday", birthday);
		m.addAttribute("email", email);
		m.addAttribute("authcode", authcode);

		// Now get a object called "m" with all register data
		// and no duplicate account number
		// next step is execute the REGISTER.

		uBean.setUser_pwd(user_pwd);
		uBean.setUsername(username);
		uBean.setUser_phone(phone);
		uBean.setBirthday(birthday);
		uBean.setEmail(email);
		uBean.setAutocode(authcode);

		rService.insert(uBean);

		return "registerResult";

		// Unsolved:
		// 1.specify the data type of phone, birthday.
		// 2.form data pattern for email.
	}
}
