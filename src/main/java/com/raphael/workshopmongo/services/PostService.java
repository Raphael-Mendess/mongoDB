package com.raphael.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raphael.workshopmongo.domain.Post;
import com.raphael.workshopmongo.repository.PostRepository;
import com.raphael.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo; 
	
    public Post findById(String id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
    
    public List<Post> findByTitle(String text){
    		return repo.searchTitle(text);
    }    
}
