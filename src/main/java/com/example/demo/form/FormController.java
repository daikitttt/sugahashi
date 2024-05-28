package com.example.demo.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	//完了の
	@RequestMapping ("/complete")
	public String complete(Form form, Model model){
		EntForm entform = new EntForm();
		entform.setName(form.getName1());
		entform.setPlace(form.getPlace());
		entform.setSyoumkigen(form.getSyoumkigen());
		sampledao.insertDb(entform);
		return "form/complete";
	}
	
	@RequestMapping("/index")
	public String index(Model model, Form form) {
		model.addAttribute("message", "ホーム"); 
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList",list);
		model.addAttribute("title","一覧ページ");
		List<EntForm> list2 = sampledao.searchDb2();
		model.addAttribute("dbList2",list2);
		List<EntForm> list3 = sampledao.searchDb3();
		model.addAttribute("dbList3",list3);
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
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList",list);
		model.addAttribute("title", "上段"); 
		return "form/top";
	}

	@RequestMapping("/middle")
	public String middle(Model model, Form form) {
		model.addAttribute("title", "中段"); 
		List<EntForm> list2 = sampledao.searchDb2();
		model.addAttribute("dbList2",list2);
		return "form/middle";
	}

	@RequestMapping("/bottom")
	public String bottom(Model model, Form form) {
		model.addAttribute("title", "下段"); 
		List<EntForm> list3 = sampledao.searchDb3();
		model.addAttribute("dbList3",list3);
		List<EntForm> list4 = sampledao.searchDb4();
		model.addAttribute("dbList4",list4);
		return "form/bottom";
	}
	@RequestMapping("/del/{id}")
	public String destory(@PathVariable Long id) {
		sampledao.deleteDb(id);
		return "redirect:/index";
	}
	
	////////////////////////////
	

    

	
}
