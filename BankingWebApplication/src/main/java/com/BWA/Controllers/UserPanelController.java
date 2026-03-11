package com.BWA.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserPanelController {
	@RequestMapping("/aboutus")
	public String visitAboutUs() {
		return "aboutus";
	}
	
	@RequestMapping("/contactus")
	public String visitContactUs() {
		return "contactus";
	}
	
	@RequestMapping("/services")
	public String visitServices() {
		return "services";
	}
	
	@RequestMapping("/home")
	public String visitHome() {
		return "userpanel";
	}
	
}
