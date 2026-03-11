package com.BWA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BWA.Entites.Customer;
import com.BWA.Services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService cserv;
	
	@GetMapping("/visitRForm")
	public String visitRegistration() {
		return "signup";
	}
	
	@PostMapping("/addUser")
	public String getNewUser(@ModelAttribute Customer cus) {
		cserv.addCustomer(cus);
		return "login";
	}
	
	@RequestMapping("/gotologin")
	public String visitLogin() {
		return "login";
	}
	@RequestMapping("/userpanel")
	public String visitUserDashboard() {
		return "userpanel";
	}
	@RequestMapping("/adminpanel")
	public String visitAdminDashboard() {
		return "adminpanel";
	}
	@RequestMapping("/logout")
	public String logOutPage() {
		return "login";
	}
	@PostMapping("/contact-submit")
	public String contactSubmit() {

	    return "thankyou";
	}
}
