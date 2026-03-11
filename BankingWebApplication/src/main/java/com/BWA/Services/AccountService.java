package com.BWA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWA.Entites.Account;
import com.BWA.Repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository acrepo;
	
	public Account addAccount(Account ac) {
		Account ac1=acrepo.save(ac);
		return ac1;
	}
	
	public Optional<Account> getSingleData(long acno) {
		Optional<Account> no=acrepo.findById(acno);
		return no;
	}
	
	public Account withdrawAmt(long acno, double amt){

	    Optional<Account> op = acrepo.findById(acno);

	    if(op.isEmpty()) {
	        return null;   // account not found
	    }

	    Account ac = op.get();

	    double existingBalance = ac.getAcbalance();

	    if(existingBalance >= amt){

	        existingBalance -= amt;
	        ac.setAcbalance(existingBalance);

	        acrepo.save(ac);

	        return ac;   // withdraw success
	    }

	    return null;   // insufficient balance
	}
	
	public Account depositAmt(long acno, double amt){

	    Optional<Account> op = acrepo.findById(acno);

	    if(op.isEmpty()){
	        return null; // account not found
	    }

	    Account ac = op.get();

	    if(amt <= 0){
	        return null; // invalid deposit amount
	    }

	    double balance = ac.getAcbalance();
	    balance += amt;

	    ac.setAcbalance(balance);

	    acrepo.save(ac);

	    return ac;
	}
	
	public Account transferAmt(long sender, long receiver, double amt) {

	    Optional<Account> senderAcc = acrepo.findById(sender);
	    Optional<Account> receiverAcc = acrepo.findById(receiver);
	    
	    
	    if(sender==receiver) {
	    	return null;
	    }

	    // check sender account exists
	    if(senderAcc.isEmpty()) {
	        return null;
	    }

	    // check receiver account exists
	    if(receiverAcc.isEmpty()) {
	        return null;
	    }
	    
	    // check negative amount
	    if(amt<0) {
	    	return null;
	    }

	    Account senderAccount = senderAcc.get();
	    Account receiverAccount = receiverAcc.get();

	    double senderBalance = senderAccount.getAcbalance();
	    double receiverBalance = receiverAccount.getAcbalance();

	    // check sufficient balance
	    if(senderBalance < amt) {
	        return null;
	    }

	    // deduct from sender
	    senderAccount.setAcbalance(senderBalance - amt);

	    // add to receiver
	    receiverAccount.setAcbalance(receiverBalance + amt);

	    // save both accounts
	    acrepo.save(senderAccount);
	    acrepo.save(receiverAccount);

	    return senderAccount;
	}
	
	
	public boolean deleteAccount(long acno) {

	    Optional<Account> op = acrepo.findById(acno);

	    if(op.isPresent()) {
	        acrepo.deleteById(acno);
	        return true;   // delete success
	    }

	    return false;      // account not found
	}
	
	public List<Account> getAllAccounts() {

	    List<Account> list = acrepo.findAll();

	    return list;
	}
}
