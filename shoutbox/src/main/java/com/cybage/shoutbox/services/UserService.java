package com.cybage.shoutbox.services;

import java.util.List;
import java.util.Optional;

import com.cybage.shoutbox.models.User;

public interface UserService {

	
	public List<User> getUsers();

	public void saveUser(User user);

	public Optional<User> getUserById(Long id);
}
