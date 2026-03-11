package com.BWA.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BWA.Entites.Account;
import com.BWA.Entites.Customer;
import com.BWA.Services.CustomerService;

@Controller
public class CustomerManagementController {
	
	@Autowired
	private CustomerService cservice;
	
	@RequestMapping("/cusManage")
	public String visitcusManage() {
		return "cusManage";
	}
	
	@RequestMapping("/viewInfo")
	public String visitVerifyForm() {
		return "verifyForViewAccount";
	}
	
	@RequestMapping("/verifyCustomer")
	public String viewCustomer(@RequestParam("cemail") String email,Model model) {
		Customer cus= cservice.getSingleData(email);
		model.addAttribute("cusData",cus);
		return "showCustomer";
	}
	
	@RequestMapping("/editform/{id}")
	public String visitEditform(@PathVariable("id") int cid, Model model) {
		Optional<Customer> op=cservice.getDataById(cid);
		if(op.isPresent()) {
				Customer cus= op.get();
	        model.addAttribute("cdata", cus);
	    } else {
	        model.addAttribute("error", "Customer Not Found");
	    }
		
		return "editCustomer";
	}
	
	@PostMapping("/editData")
	public String updateData(@ModelAttribute Customer cus,Model model) {
		cservice.addCustomer(cus);
		model.addAttribute("cusData", cus);
		return "showCustomer";
	}
	

}
