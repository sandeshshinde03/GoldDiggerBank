package com.BWA.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.BWA.Entites.Account;
import com.BWA.Services.AccountService;

@Controller
public class AccountManagementController {
	@Autowired
	private AccountService acserv;
	
	@RequestMapping("/acManage")
	public String visitACManage() {
		return "acManage";
	}
	
	@RequestMapping("/openAC")
	public String openAccountForm() {
		return "openACform";
	}
	
	@GetMapping("/sendAcDetails")
	public String fetchDataOfAccount(@ModelAttribute Account ac,RedirectAttributes ra) {
		Account ac1=acserv.addAccount(ac);
		ra.addFlashAttribute("acdata", ac1);
		return "redirect:/transferdata";
	}
	@GetMapping("/transferdata")
	public String showData() {
		return "showAccount";
	}
	
	@GetMapping("/viewAC")
	public String verifyAcNum() {
		return "verifyAccount";
	}
	
	@GetMapping("/verify")
	public String fetchSingleData(@RequestParam("acnum") long acno, Model model) {
	    Optional<Account> op = acserv.getSingleData(acno);
	    if(op.isPresent()) {
	        Account ac = op.get();
	        model.addAttribute("acdata", ac);
	    } else {
	        model.addAttribute("error", "Account Number Not Found");
	    }
	    return "viewAccount";
	}
	
	@GetMapping("/editAC")
	public String editAcForm() {
		return "verifyforedit";
	}
	
	@RequestMapping("/verifyEdit")
	public String editAccount(@RequestParam("acnum") long acno,Model model) {
		
		Optional<Account> op = acserv.getSingleData(acno);
	    if(op.isPresent()) {
	        Account ac = op.get();
	        model.addAttribute("acdetail", ac);
	    } else {
	        model.addAttribute("error", "Account Number Not Found");
	    }
		
		return "editform";
	}
	
	@PostMapping("/sendEditedData")
	public String fetchEditedData(@ModelAttribute Account ac, Model model) {

	    Account updatedAccount = acserv.addAccount(ac); 

	    model.addAttribute("acdata", updatedAccount);  

	    return "showUpdatedAccount"; 
	}
	
	@RequestMapping("/deleteAC")
	public String verifyACforDelete() {
		return "verifyDelete";
	}
	
	
	@GetMapping("/verifyRemove")
	public String deleteAccount(@RequestParam("acnum") long acno, Model model) {

	    boolean status = acserv.deleteAccount(acno);

	    if(status) {
	        model.addAttribute("msg", "Account Deleted Successfully");
	    } else {
	        model.addAttribute("error", "Account Not Found");
	    }

	    return "Deleteresult";
	}

}
