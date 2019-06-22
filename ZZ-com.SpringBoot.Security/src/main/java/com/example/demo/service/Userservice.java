package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entite.Role;
import com.example.demo.Entite.User;
import com.example.demo.Repo.UserRepo;

@Service
public class Userservice {
	
	@Autowired
	private UserRepo userRepo;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new  Role("USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(userRole);
		user.setRole(roles);
		userRepo.save(user);
		
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new  Role("ADMIN");
		List<Role> roles = new ArrayList<Role>();
		roles.add(userRole);
		user.setRole(roles);
		userRepo.save(user);
		
	}
	public User findOne(String email) {
		return  userRepo.findByEmail(email);
	}

	public boolean isUserFound(String email) {
			User u = userRepo.findByEmail(email);
			if(u!=null)
				return true;
		return false;
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}

	public List<User> findByName(String name) {
		return userRepo.findByNameLike("%"+name+"%");
	}
	
}
