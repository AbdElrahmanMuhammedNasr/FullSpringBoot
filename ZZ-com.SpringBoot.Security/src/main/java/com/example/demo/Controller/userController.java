package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.Userservice;

@Controller
public class userController {

	@Autowired
	private Userservice userService;
	
	@GetMapping(value="/users")
	public String listUser(Model model , @RequestParam(defaultValue="") String name) {
		
		model.addAttribute("users", userService.findByName(name));
		return "view/list";
	}
}
