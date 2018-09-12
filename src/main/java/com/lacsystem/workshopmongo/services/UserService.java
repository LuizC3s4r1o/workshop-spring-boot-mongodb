package com.lacsystem.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lacsystem.workshopmongo.domain.User;
import com.lacsystem.workshopmongo.repository.UserRepository;
import com.lacsystem.workshopmongo.services.exception.ObjectNotFoundException;

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
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
