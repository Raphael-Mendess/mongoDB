package com.raphael.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.raphael.workshopmongo.domain.Post;
import com.raphael.workshopmongo.domain.User;
import com.raphael.workshopmongo.dto.AuthorDTO;
import com.raphael.workshopmongo.repository.PostRepository;
import com.raphael.workshopmongo.repository.UserRepository;

//implementar métodos 
@Configuration
public class Instantiation implements CommandLineRunner {	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private PostRepository postRepository ;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		 User batman = new User (null, "Batman", "batman@gmail.com");
		 User raphael = new User(null, "Raphael", "raphael@gmail.com");
		 User joker = new User(null, "Joker", "joker@gmail.com"); 
		 
		 userRepository.saveAll(Arrays.asList(batman, raphael, joker));
		 
		 Post post1 = new Post(null, sdf.parse("21/03/2018"), "Estou fugindo do Batman", "Vou viajar para Gotham City.", new AuthorDTO(joker)); 
		 Post post2 = new Post(null, sdf.parse("21/03/2018"), "Cheguei", "Consegui dar fuga", new AuthorDTO(joker));
		 
		 postRepository.saveAll(Arrays.asList(post1, post2)); 
		 
		 joker.getPosts().addAll(Arrays.asList(post1, post2));
		 userRepository.save(joker);
	}
}
