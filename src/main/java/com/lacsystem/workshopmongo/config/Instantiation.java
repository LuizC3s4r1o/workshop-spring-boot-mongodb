package com.lacsystem.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lacsystem.workshopmongo.domain.Post;
import com.lacsystem.workshopmongo.domain.User;
import com.lacsystem.workshopmongo.dto.AuthorDTO;
import com.lacsystem.workshopmongo.dto.CommentDTO;
import com.lacsystem.workshopmongo.repository.PostRepository;
import com.lacsystem.workshopmongo.repository.UserRepository;

/**
 * @author Luiz.Cesario
 *
 */

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User luiz = new User(null, "Luiz Cesario", "luizC@gmail.com");
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User gabi = new User(null, "Gabi Rofhman", "gabiR@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(luiz, maria, gabi, alex, bob));
		
		Post post1 = new Post(null, simpleDateFormat.parse("10/09/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(luiz));
		Post post2 = new Post(null, simpleDateFormat.parse("12/09/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(luiz));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem", simpleDateFormat.parse("10/09/2018"), new AuthorDTO(gabi));
		CommentDTO comment2 = new CommentDTO("Aproveite", simpleDateFormat.parse("10/09/2018"), new AuthorDTO(maria));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia", simpleDateFormat.parse("12/09/2018"), new AuthorDTO(gabi));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		luiz.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(luiz);

		
	}

}
