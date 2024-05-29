package com.example.demo.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("title", "冷蔵庫"); 
		return "form/top";
	}
	
	@RequestMapping("/top_del")
	public String top_del(Model model, Form form) {
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList",list);
		model.addAttribute("title", "冷蔵庫"); 
		return "form/top_del";
	}

	@RequestMapping("/middle")
	public String middle(Model model, Form form) {
		model.addAttribute("title", "中段"); 
		List<EntForm> list2 = sampledao.searchDb2();
		model.addAttribute("dbList2",list2);
		return "form/middle";
	}
	
	@RequestMapping("/middle_del")
	public String middle_del(Model model, Form form) {
		model.addAttribute("title", "中段"); 
		List<EntForm> list2 = sampledao.searchDb2();
		model.addAttribute("dbList2",list2);
		return "form/middle_del";
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
	
	@RequestMapping("/bottom_del")
	public String bottom_del(Model model, Form form) {
		model.addAttribute("title", "下段"); 
		List<EntForm> list3 = sampledao.searchDb3();
		model.addAttribute("dbList3",list3);
		List<EntForm> list4 = sampledao.searchDb4();
		model.addAttribute("dbList4",list4);
		return "form/bottom_del";
	}
	
	@RequestMapping("/search")
	public String search(Model model, Form form) {
		model.addAttribute("title", "下段"); 
		List<EntForm> list3 = sampledao.searchDb3();
		model.addAttribute("dbList3",list3);
		List<EntForm> list4 = sampledao.searchDb4();
		model.addAttribute("dbList4",list4);
		return "form/search";
	}
	
	@RequestMapping("/del/{id}")
	public String destory(@PathVariable Long id) {
		sampledao.deleteDb(id);
		return "redirect:/index";
	}
	
	////////////////////////////
	
	// 検索結果を表示するためのメソッド
    @PostMapping("/search")
    public String search(@RequestParam("find") String find, Model model) {
        List<EntForm> list = sampledao.findByName(find);
        model.addAttribute("searchtitle", "検索結果");
        model.addAttribute("data", list);
        return "form/search";
    }
}
