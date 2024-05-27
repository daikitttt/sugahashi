package com.example.demo.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.SampleDao;
import com.example.demo.entity.EntForm;

@Controller
public class FormController {
	
	private final SampleDao sampledao;

	@Autowired
	public FormController(SampleDao sampledao) {
		this.sampledao = sampledao;
	}

	//完了の処理
	@RequestMapping ("/complete")
	public String complete(Form form, Model model){
		EntForm entform = new EntForm();
		entform.setName(form.getName1());
		entform.setPlace(form.getPlace());
		sampledao.insertDb(entform);
		return "form/complete";
	}
	
	@RequestMapping("/index")
	public String index(Model model, Form form) {
		model.addAttribute("message", "ホーム"); 
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
	@RequestMapping("/top")
	public String top(Model model, Form form) {
		model.addAttribute("title", "上段"); 
		return "form/top";
	}

	@RequestMapping("/middle")
	public String middle(Model model, Form form) {
		model.addAttribute("title", "中段"); 
		return "form/middle";
	}

	@RequestMapping("/bottom")
	public String bottom(Model model, Form form) {
		model.addAttribute("title", "下段"); 
		return "form/bottom";
	}


	
}
