package com.raphael.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.workshopmongo.domain.User;
import com.raphael.workshopmongo.repository.UserRepository;
import com.raphael.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; 
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	/*public User findById(String id) {
	    User user = repo.findOne(id);
	    if(user == null) {
	        throw new ObjectNotFoundException("Objeto não encontrado");            
	    }
	    return user;
	}*/	
}
