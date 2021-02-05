package com.vintage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vintage.model.ActivityInfo;
import com.vintage.model.ActivityInfoRepo;
import com.vintage.model.LocationRepo;

@Controller
public class ActivityController {
	
	@Autowired
	private ActivityInfoRepo aRepo;
	
	@Autowired
	private LocationRepo lRepo;
	
	@GetMapping("/actHome")
	public String viewActHomePage() {
		return "actHomePage";
	}
	
	@GetMapping("/actCreate")
	public String viewActCreatePage() {
		return "actCreatePage";
	}
	
	@GetMapping("/actCreateProcess")
	public String actCreateProcess(ActivityInfo aInfo) {
		
//		String createResult;
		
		if ( lRepo.findByLocation(aInfo.getActLocation()).getLocatReserved().isEmpty() ) {
			// if isEmpty return true means it can be used.
			aRepo.save(aInfo);
			return "SUCCESS";
		}else {
			return "FAILED";
		}
		
		
	}
}
