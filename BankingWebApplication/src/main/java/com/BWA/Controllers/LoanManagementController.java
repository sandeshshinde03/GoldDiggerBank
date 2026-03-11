package com.BWA.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BWA.Entites.Loan;
import com.BWA.Services.LoanService;

@Controller
public class LoanManagementController {
	
	@Autowired
	LoanService lnservice;
	
	@RequestMapping("/loanManage")
	public String visitLoanManage() {
		return "loanManage";
	}
	
	@RequestMapping("/loanForm")
	public String visitLoanForm() {
		return "loanForm";
	}
	
	@RequestMapping("/applyForLoan")
	public String addLoanDetails(@ModelAttribute Loan ln) {
		lnservice.addLoanDetails(ln);
		return "successLoanDetails";
	}
	
	@GetMapping("/verifyLoanID")
	public String checkLoanStutas() {
		
		return "verifyLnID";
	}
	
	@GetMapping("/verifyID")
	public String fetchLoanData(@RequestParam("loanId") int lnid, Model model) {

	    Optional<Loan> op = lnservice.getSingleData(lnid);

	    if(op.isPresent()) {

	        Loan ln = op.get();
	        model.addAttribute("loan", ln);

	    } else {

	        model.addAttribute("error", "Loan ID not found");

	    }

	    return "showloan";
	}

}
