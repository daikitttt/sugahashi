package com.example.demo.form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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
		sampledao.insertDb(entform);
		return "form/complete";
	}
	
	@RequestMapping("/index")
	public String index(Model model, Form form) {
		model.addAttribute("message", "ホーム"); 
		List<EntForm> list = sampledao.searchDb();
		model.addAttribute("dbList",list);
		model.addAttribute("title","一覧ページ");
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
	
	////////////////////////////
	

    @GetMapping("/redirectByPlace")
    public RedirectView redirectByPlace() {
        // データベースから place の値を取得
    	EntForm entform = new EntForm();
        String basyo = entform.getPlace();

        // place の値に応じてリダイレクト先を決定
        String redirectUrl;
        switch (basyo) {
            case "top":
                redirectUrl = "redirect:/top.html";
                break;
            case "middle":
                redirectUrl = "redirect:/middle.html";
                break;
            default:
                redirectUrl = "redirect:/bottom.html"; // place に対するデフォルトのリダイレクト先を指定
                break;
        }

        // リダイレクト実行
        return new RedirectView(redirectUrl);
    }

	
}
