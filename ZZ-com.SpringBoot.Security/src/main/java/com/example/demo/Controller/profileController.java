package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entite.User;
import com.example.demo.service.TaskService;
import com.example.demo.service.Userservice;

@Controller
public class profileController {

	 @Autowired
	 private TaskService taskService;
	 @Autowired
	 private Userservice userService;
	 
	 
	 @GetMapping(value="/profile")
	 public String showProfie(Model model , Principal prinsipal) {
		 
		 String email = prinsipal.getName();
		 User user = userService.findOne(email);
		 model.addAttribute("tasks",taskService.findUserTask(user));
		 return "view/profile";
	 }
}
