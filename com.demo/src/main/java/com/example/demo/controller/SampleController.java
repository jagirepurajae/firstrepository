package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class SampleController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/newUser")
	public User addUSer(@RequestBody User user) {
		return userRepository.save(user);

	}

	@GetMapping("/{id}")
	public User getUSer(@PathVariable("id") Integer id) {
		
		Optional<User> opt=userRepository.findById(id);
		
		return opt.get() ;

	}

	
	@GetMapping("/user")
	public String user() {
		System.out.println("inside welcome()");
		return "<h2>Welcome to user</h2>";
	}
	

	@GetMapping("/admin")
	public String admin() {
		System.out.println("inside welcome()");
		return "<h2>Welcome to admin</h2>";
	}

}
