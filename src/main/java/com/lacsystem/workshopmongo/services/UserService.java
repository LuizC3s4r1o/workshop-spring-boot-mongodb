package com.lacsystem.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacsystem.workshopmongo.domain.User;
import com.lacsystem.workshopmongo.repository.UserRepository;

/**
 * @author Luiz.Cesario
 *
 */

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}

}
