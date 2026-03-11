package com.BWA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BWA.Entites.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.cemail=:cemail")	
	Customer findbyEmail(@Param("cemail") String cemail);
}
