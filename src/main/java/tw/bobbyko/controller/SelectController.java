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

import tw.bobbyko.model.SelectService;
import tw.bobbyko.model.Userdata;

@Controller
public class SelectController {

	@Autowired
	SelectService sService = new SelectService();

	@GetMapping(path = "/select")
	public String processMainPage() {
		return "select";
	}

	@GetMapping(path = "/SelectController")
	public String processAction(@RequestParam(name = "user_acc") String user_acc, Model m) {
		
		Userdata rBean = new Userdata();
		rBean.setUser_acc(user_acc);
		
		String result = sService.select(rBean);
		System.out.println(result);
		return "1";

	}

}
