package com.BWA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWA.Entites.Loan;
import com.BWA.Repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository lnrepo;
	
	public Loan addLoanDetails(Loan ln) {
		lnrepo.save(ln);
		return ln;
	}
	
	public Optional<Loan> getSingleData(int lnid){
		Optional<Loan> op=lnrepo.findById(lnid);
		return op;
	}
	
	public List<Loan> getAllLoanData(){
		List<Loan> all=lnrepo.findAll();
		return all;
	}
	
	public Optional<Loan> updateStutas(int id){
		Optional<Loan> op=lnrepo.findById(id);
		Loan ln=op.get();
		ln.setStatus("Approved");
		lnrepo.save(ln);
		return op;
	}
	
	public Optional<Loan> rejectStutas(int id){
		Optional<Loan> op=lnrepo.findById(id);
		Loan ln=op.get();
		ln.setStatus("Rejected");
		lnrepo.save(ln);
		return op;
	}

}
