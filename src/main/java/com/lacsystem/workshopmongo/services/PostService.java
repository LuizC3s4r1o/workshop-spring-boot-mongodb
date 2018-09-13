package com.lacsystem.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacsystem.workshopmongo.domain.Post;
import com.lacsystem.workshopmongo.repository.PostRepository;
import com.lacsystem.workshopmongo.services.exception.ObjectNotFoundException;

/**
 * @author Luiz.Cesario
 *
 */

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}