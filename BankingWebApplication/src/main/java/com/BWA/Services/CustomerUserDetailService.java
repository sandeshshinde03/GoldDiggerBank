package com.BWA.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BWA.Entites.Customer;
import com.BWA.Repository.CustomerRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerRepository crepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer cus=crepo.findbyEmail(email);
		if(cus==null) {
			throw new UsernameNotFoundException("User not found: "+email);
		}
		List<GrantedAuthority> authorities=List.of(new SimpleGrantedAuthority("ROLE_"+cus.getRole()));
		
		return new User(cus.getCemail(),cus.getCpass(),authorities);
	}

}
