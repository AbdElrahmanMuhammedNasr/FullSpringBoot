package com.example.demo.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entite.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.Userservice;

@Controller
public class taskController {
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private Userservice userService;
	
	@GetMapping(value="/addTask")
	public String taskform( String email , Model model , HttpSession session) {
		session.setAttribute("email", email);
		System.out.println("44444444444444444444444444444444444444");
		model.addAttribute("task" ,new Task());
		System.out.println("55555555555555555555555555555555555555555555555");
		return "view/taskForm";
	}
	
	
	@PostMapping(value="/addTask")
	public String addTask(@Valid Task task , BindingResult bindingResult,HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "view/taskForm";
		}
		String email = (String) session.getAttribute("email");
		taskService.addTask(task, userService.findOne(email));
		return "redirect:/users";
	}


}
