package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String showPage() {
		return "index";
	}
	
	
	@GetMapping(value="/login")
	public String showlogin() {
		return "view/loginForm";
	}
	
}
