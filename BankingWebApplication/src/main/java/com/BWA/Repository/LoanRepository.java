package com.BWA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BWA.Entites.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
