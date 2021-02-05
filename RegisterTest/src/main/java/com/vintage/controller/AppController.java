package com.vintage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vintage.model.User;
import com.vintage.model.UserRepository;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository uRepo;
	
	@GetMapping("")
	public String ViewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model m) {
		m.addAttribute("users", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		uRepo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model m) {
		List<User> listUsers = uRepo.findAll();
		m.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/testpage1")
	public String testP1(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "testPage1";
	}
	
	@GetMapping("/testpage2")
	public String testP2(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "testPage2";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword() {
		return "resetPassword";
	}
	
	@PostMapping("/resetPassword")
	public String getPassword(@RequestParam("email") String email, @RequestParam("password") String secondPwd, Model m) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(!uRepo.findByEmail(email).getEmail().isEmpty()) {
			User user = uRepo.findByEmail(email);
			user.setPassword(encoder.encode(secondPwd));
			uRepo.save(user);
			return "testPage1";
		}else {
			m.addAttribute("errors", "NO EMAIL EXIST!! PLEASE CHECK AGAIN.");
			return "resetPassword";
		}
	}
	
	@GetMapping("/loginPage")
	public String viewLoginPage() {
		return "login3";
	}
	
	@GetMapping("/testpage3")
	public String viewHomePage(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "index3";
	}
	
	@GetMapping("/toActivity")
	public String viewActivityPage(Model m) {
//		String user = GetCurrentUserAccount();
//		m.addAttribute("user", user);
		return "Activity";
	}
	
	@GetMapping("/home")
	public String ViewHomePagee() {
		return "index3";
	}
	
	@GetMapping("/personalInfo")
	public String viewPersonalInfo() {
		return "personalInfo";
	}
	
	@GetMapping("/registerNow")
	public String toRegister(Model m) {
		m.addAttribute("users", new User());
		return "register3";
	}
	
	@GetMapping("/registerProcess")
	public String registerProcess() {
		return "register_success";
	}
		
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
}
