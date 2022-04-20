package com.cybage.shoutbox.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.shoutbox.models.User;
import com.cybage.shoutbox.repo.UserRepo;
import com.cybage.shoutbox.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userRepo;
	

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}


	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}


	@Override
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
		
	}

}
