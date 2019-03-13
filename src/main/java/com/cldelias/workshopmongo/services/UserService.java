package com.cldelias.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cldelias.workshopmongo.domain.User;
import com.cldelias.workshopmongo.repository.UserRepository;
import com.cldelias.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> opUser = this.userRepository.findById(id);
		return opUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return this.userRepository.insert(obj);
	}
	
	public void delete(String id) {
		this.findById(id);
		this.userRepository.deleteById(id);
	}

	
}
