package com.lacsystem.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lacsystem.workshopmongo.domain.User;
import com.lacsystem.workshopmongo.repository.UserRepository;

/**
 * @author Luiz.Cesario
 *
 */

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User luiz = new User(null, "Luiz Cesario", "luizC@gmail.com");
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User gabi = new User(null, "Gabi Rofhman", "gabiR@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(luiz, maria, gabi, alex, bob));

		
	}

}
