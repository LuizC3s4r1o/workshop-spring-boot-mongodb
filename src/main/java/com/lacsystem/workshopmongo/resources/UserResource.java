package com.lacsystem.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lacsystem.workshopmongo.domain.User;

/**
 * 
 * @author Luiz.Cesario
 *
 */

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		
		User Luiz = new User("1", "Luiz Cesario", "LuizC@gmail.com");
		User Gabi = new User("2", "Gabi Rofhman ", "gabiR@gmail.com");
		
		list.addAll(Arrays.asList(Luiz, Gabi));
		
		return ResponseEntity.ok().body(list);
	}

}
