package com.BWA.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BWA.Entites.Account;
import com.BWA.Services.AccountService;

@Controller
public class TransactionManagementController {
			@Autowired
			private AccountService accountService;
	@RequestMapping("/transManage")
	public String visitTransManage() {
		return "transManage";
	}
	
	@RequestMapping("/withdrawForm")
	public String visitWithdrawForm() {
		return "withdrawForm";
	}
	
	@PostMapping("/withdraw")
	public String withdrawAmmountt(@RequestParam("acnum") long acnum,
	                               @RequestParam("withdrawAMT") double amt,
	                               Model model) {

	    Account ac = accountService.withdrawAmt(acnum, amt);

	    if(ac == null){
	        model.addAttribute("error","Invalid Account Number or Insufficient Balance");
	        return "Transaction";
	    }

	    model.addAttribute("acdata", ac);
	    return "Transaction";
	}
	
	@RequestMapping("/depositeForm")
	public String visitDepositeForm() {
		return "depositeForm";
	}
	
	@PostMapping("/deposite")
	public String depositAmount(@RequestParam("acnum") long acnum,
	                            @RequestParam("depositAMT") double amt,
	                            Model model) {

	    Account ac = accountService.depositAmt(acnum, amt);

	    if(ac == null){
	        model.addAttribute("error","Invalid Account Number or Amount");
	        return "Transaction";
	    }

	    model.addAttribute("acdata", ac);
	    return "Transaction";
	}
	
	@RequestMapping("/banktranferForm")
	public String visistBankTransferForm() {
		return "banktranferForm";
	}
	
	@PostMapping("/banktransfer")
	public String transferAmt(@RequestParam("acnum1") long acno1,
							  @RequestParam("acnum2") long acno2,
							  @RequestParam("transferAMT") double amt,
							  Model model) {
		
		Account ac = accountService.transferAmt(acno1, acno2, amt);

	    if(ac == null){
	        model.addAttribute("error","Transfer Failed. Check account numbers or balance.");
	        return "Transaction";
	    }

	    model.addAttribute("acdata", ac);
	    return "Transaction";
	}
}
