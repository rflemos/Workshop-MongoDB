package com.rafael.mongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.mongodb.domain.Post;
import com.rafael.mongodb.domain.repository.PostRepository;
import com.rafael.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
		//return repo.findByTitleContainingIgnoreCase(text);
		
	}
	
	public List<Post> fullSearch(String  text, Date minDate, Date maxDate){
		maxDate =  new Date(maxDate.getTime() + 24 * 60 * 60 * 100);
		return repo.fullSearch(text, minDate, maxDate);
		
	}

 }
