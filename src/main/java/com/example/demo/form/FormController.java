package com.example.demo.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	
	@RequestMapping("/index")
	public String index(Model model, Form form) {
		model.addAttribute("message", "Hello World2"); 
		return "index";
	}
	@RequestMapping("/input")
	public String input(Model model, Form form) {
		model.addAttribute("title", "冷蔵庫へ追加"); 
		return "form/input";
	}
	@RequestMapping("/confirm")
	public String confirm(Model model, Form form) {
		model.addAttribute("message", "Hello World2"); 
		return "form/confirm";
	}


	
}
