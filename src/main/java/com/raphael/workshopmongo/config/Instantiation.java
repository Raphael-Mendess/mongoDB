package com.raphael.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.raphael.workshopmongo.domain.User;
import com.raphael.workshopmongo.repository.UserRepository;

//implementar métodos 
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository ;
	 
	
	@Override
	public void run(String... args) throws Exception {		
		userRepository.deleteAll();
		
	//“À esquerda eu declaro uma variável que guarda o objeto , e à direita eu instancio um objeto da classe tipo User, passando valores para seus atributos.”
		 User batman = new User (null, "Batman", "batman@gmail.com");
		 User raphael = new User(null, "Raphael", "raphael@gmail.com");
		 User joker = new User(null, "Joker", "joker@gmail.com"); 
		 
		 userRepository.saveAll(Arrays.asList(batman, raphael, joker));
		
	}
}
