package tw.bobbyko.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import tw.bobbyko.model.UpdateService;
import tw.bobbyko.model.Userdata;

@Controller
public class UpdateController {

	@Autowired 
	UpdateService uService = new UpdateService();

	@RequestMapping(path = "/update.mainPageController", method = RequestMethod.GET)
	public String processMainPage() {
		return "FinalDawn";
	}

	@RequestMapping(path = "/update.checkController", method = RequestMethod.POST)
	public String updateAction(
			@RequestParam(name = "user_acc") String user_acc,
			@RequestParam(name = "userPwd") String user_pwd,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "birthday") String birthday,
			@RequestParam(name = "email") String email,
			Model m) {

		Userdata uBean = new Userdata();

		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		// check value at every column.

		
//		if (user_pwd == null || user_pwd.length() == 0) {
//			errors.put("msg_pwd", "You Should Enter Password.");
//
//		}
//
//		if (username == null || username.length() == 0) {
//			errors.put("msg_name", "You Should Enter Name.");
//
//		}
//
//		if (phone == null || phone.length() == 0) {
//			errors.put("msg_phone", "You Should Enter Phone.");
//
//		}
//
//		if (birthday == null || birthday.length() == 0) {
//			errors.put("msg_birth", "You Should Enter Birthday.");
//
//		}
//
//		if (email == null || email.length() == 0) {
//			errors.put("msg_email", "You Should Enter Email.");
//
//		}
//
//		if (authcode == null || authcode.length() == 0) {
//			errors.put("msg_authcode", "You Should Choose.");
//
//		}
//
//		if (errors != null && !errors.isEmpty()) {
//			return "register";
//		}
//
//		uBean.setUser_acc(user_acc);
//		boolean result = uService.update(uBean);
//		
//		if (result) {
//			// execute register
//			System.out.println("Account is OK for use");
//		} else {
//			errors.put("msg_acc", "Account You Entered Has Already Exist" + ", Please Choose Another One");
//			System.out.println("check point 2");
//			return "update";
//		}
//		;
		// Now get a object called "m" with all register data
		// and no duplicate account number
		// next step is execute the REGISTER.

		
//		uBean.setUser_acc(user_acc);
//		uBean.setUser_pwd(user_pwd);
//		uBean.setUser_phone(phone);
//		uBean.setBirthday(birthday);
//		uBean.setEmail(email);
		
		boolean result = uService.update(
				user_acc,
				user_pwd,
				phone,
				birthday,
				email);
		
		if (result) {
			return "updateResult";
		}else {
			return "success";
		}

		
		
		//Unsolved:
		//1.specify the data type of phone, birthday.
		//2.form data pattern for email.
	}
}
