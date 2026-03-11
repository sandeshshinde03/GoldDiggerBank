package com.BWA.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BWA.Entites.Customer;
import com.BWA.Repository.CustomerRepository;

@Service
public class CustomerService {
	
		@Autowired
		private CustomerRepository crepo;
		
		public void addCustomer(Customer cus) {
			crepo.save(cus);
		}
		
		public Customer getSingleData(String email) {
			Customer cus=crepo.findbyEmail(email);
			return cus;
		}
		
		public Optional<Customer> getDataById(int id) {
			Optional<Customer> op=crepo.findById(id);
			return op;
		}
		public List<Customer> getAllCustomers(){

		    List<Customer> list = crepo.findAll();

		    return list;
		}
		
		public boolean deleteCustomer(int cid) {

		    Optional<Customer> op = crepo.findById(cid);

		    if(op.isPresent()) {

		        crepo.deleteById(cid);

		        return true;
		    }

		    return false;
		}
}
