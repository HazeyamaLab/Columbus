package com.example.service;

import com.example.repository.UserRepository;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;;


@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
		User user = userRepository.findOne(id);
		if(user == null) {
			throw new UsernameNotFoundException("The requested user is not found");
		}
		return new LoginUserDetails(user);
		
	}
}
