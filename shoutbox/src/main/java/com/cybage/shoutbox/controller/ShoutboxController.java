package com.cybage.shoutbox.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.shoutbox.models.User;
import com.cybage.shoutbox.services.UserService;

@RestController
public class ShoutboxController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/home")
	public String controller() {
		return "shoutbox in command";
	}

	@GetMapping("findAll")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PostMapping("/save")
	public void saveUser(@RequestParam("firstName") String name, @RequestParam("mail") String mail, @RequestParam("lastName") String lastName, @RequestParam("city") String city) {
		
		userService.saveUser(new User(name, lastName, mail, city));
		
	}
	
	@PostMapping("update")
	public String updateUser(@RequestParam("firstName") String name, @RequestParam("mail") String mail,
			@RequestParam("lastName") String lastName, @RequestParam("city") String city,
			@RequestParam("id") long userId) {

		Optional<User> user = userService.getUserById(userId);

		if (user.isPresent()) {
			if (!user.get().getCity().equals(city) || user.get().getCity() == null) {
				user.get().setCity(city);
			}
			if (!user.get().getFirstName().equals(name) || user.get().getFirstName() == null) {
				user.get().setFirstName(name);
			}
			if (!user.get().getLastName().equals(lastName) || user.get().getLastName() == null) {
				user.get().setLastName(lastName);
			}
			if (!user.get().getMail().equals(mail) || user.get().getMail() == null) {
				user.get().setMail(mail);
				System.out.println("mail updated");
			}
			userService.saveUser(user.get());
				return "user updated";
		
		} else
			return "No userfound with id: " + userId;

	}
}
