package com.BWA.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BWA.Entites.Account;
import com.BWA.Entites.Customer;
import com.BWA.Entites.Loan;
import com.BWA.Services.AccountService;
import com.BWA.Services.CustomerService;
import com.BWA.Services.LoanService;

@Controller
public class AdminController {
	
	@Autowired
	private LoanService loanServ;
	
	@Autowired
	private AccountService accServ;
	
	@Autowired
	private CustomerService custServ;
	
	@RequestMapping("/homeAdmin")
	public String visitAdminHome() {
		return "adminpanel";
	}
	@RequestMapping("/loanQueries")
	public String shoeLoanQueries(Model model) {
		List<Loan> list=loanServ.getAllLoanData();
		model.addAttribute("lnlist", list);
		return "ShowAllLoanQueries";
	}
	
	@RequestMapping("/approved/{lnId}")
	public String approvedStutas(@PathVariable("lnId") int id, Model model) {
		loanServ.updateStutas(id);
		List<Loan> list=loanServ.getAllLoanData();
		model.addAttribute("lnlist", list);
		return "ShowAllLoanQueries";
	}
	
	
	
	@RequestMapping("/rejected/{lnId}")
	public String rejectStutas(@PathVariable("lnId") int id, Model model) {
		loanServ.rejectStutas(id);
		List<Loan> list=loanServ.getAllLoanData();
		model.addAttribute("lnlist", list);
		return "ShowAllLoanQueries";
	}
	
	@RequestMapping("/adminAccounts")
	public String showAllAccounts(Model model) {

	    List<Account> list = accServ.getAllAccounts();

	    model.addAttribute("acclist", list);

	    return "ShowAllAccounts";
	}
	@RequestMapping("/deleteAccount/{acno}")
	public String deleteAccount(@PathVariable("acno") long acno, Model model) {

	    accServ.deleteAccount(acno);

	    List<Account> list = accServ.getAllAccounts();

	    model.addAttribute("acclist", list);

	    return "ShowAllAccounts";
	}
	
	@RequestMapping("/adminCustomers")
	public String showCustomers(Model model){

	    List<Customer> list = custServ.getAllCustomers();

	    model.addAttribute("custlist", list);

	    return "ShowAllCustomers";
	}
	
	@RequestMapping("/deleteCustomer/{cid}")
	public String deleteCustomer(@PathVariable("cid") int cid) {

	    custServ.deleteCustomer(cid);

	    return "redirect:/adminCustomers";
	}
	
}
