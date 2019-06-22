package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entite.User;
import com.example.demo.service.Userservice;

@Controller
public class RegisterController {
	
	@Autowired
	private Userservice userservice;
	
	@GetMapping(value="/register")
	public String registerForm(Model model) {
		model.addAttribute("user", new User());
		return "view/registerForm";
	}
	
	
	@PostMapping(value="/register")
	public String registerUser(@Valid User user ,BindingResult bindingResult , Model model) {
		if (bindingResult.hasErrors()) {
			return "view/registerForm";
		}
		if(userservice.isUserFound(user.getEmail())) {
			model.addAttribute("exist", true);
			return "view/registerForm";
		}
		userservice.createUser(user);
		
		return "view/success";
	}
	

}
