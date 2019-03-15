package com.cldelias.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldelias.workshopmongo.domain.Post;
import com.cldelias.workshopmongo.repository.PostRepository;
import com.cldelias.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> opPost = this.postRepository.findById(id);
		return opPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return this.postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
