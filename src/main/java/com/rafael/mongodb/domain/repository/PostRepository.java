package com.rafael.mongodb.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafael.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {
	//?0 porque e o primeiro parametro do methodo.
	@Query("{ 'title': { $regex:?0 , $options: 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);// ja é montado um methodo de busca com query methods.
	
	

}
