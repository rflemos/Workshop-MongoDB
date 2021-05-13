package com.rafael.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.mongodb.DTO.UserDTO;
import com.rafael.mongodb.domain.User;
import com.rafael.mongodb.domain.repository.UserRepository;
import com.rafael.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
		
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
 }
