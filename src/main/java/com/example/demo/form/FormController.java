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
	//各削除確認ページ
	@RequestMapping("/confirm_top")
	public String confirm_top(Model model, Form form) {
		model.addAttribute("message", "Hello World2"); 
		return "form/confirm_top";
	}
	
	@RequestMapping("/confirm_middle")
	public String confirm_middle(Model model, Form form){
		return "form/confirm_middle";
	}
	
	@RequestMapping("/confirm_bottom")
	public String confirm_bottom(Model model, Form form) {
		model.addAttribute("message", "Hello World2"); 
		return "form/confirm_bottom";
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
	
	@RequestMapping("/topdel/{id}")
	public String destory(@PathVariable Long id) {
		sampledao.deleteDb(id);
		return "redirect:/confirm_top";
	}
	@RequestMapping("/middledel/{id}")
	public String destory2(@PathVariable Long id) {
		sampledao.deleteDb(id);
		return "redirect:/confirm_middle";
	}
	@RequestMapping("/bottomdel/{id}")
	public String destory3(@PathVariable Long id) {
		sampledao.deleteDb(id);
		return "redirect:/confirm_bottom";
	}
	
	////////////////////////////
	
//	@RequestMapping("/edit/{id}")
//	public String edit(@PathVariable Long id, Model model) {
//		List<EntForm> list1 = sampledao.selectOne(id);
//		return "redirect:/index";
//	}
//	
	// 検索結果を表示するためのメソッド
    @PostMapping("/search")
    public String search(@RequestParam("find") String find, Model model) {
        List<EntForm> list = sampledao.findByName(find);
        model.addAttribute("searchtitle", "検索結果");
        model.addAttribute("data", list);
        return "form/search";
    }
    
//  //更新画面の表示(SELECT)
//  		@RequestMapping("/edit/{id}")
//  		public String editView(@PathVariable Long id, Model model) {
//  			
//  			//DBからデータを1件取ってくる(リストの形)
//  			List<EntForm> list = sampledao.selectOne(id);
//
//  			
//  			if (list.isEmpty()) {
//  		        // エラーメッセージを設定してリダイレクトするか、エラーページを表示
//  		        model.addAttribute("errorMessage", "指定されたIDのデータが見つかりません");
//  		        return "error";
//  		    }
//  			
//  			//リストから、オブジェクトだけをピックアップ
//  			EntForm entformdb = list.get(0);
//  			
//  			 model.addAttribute("form", entformdb);
//  		    model.addAttribute("title", "編集ページ");
//  		    return "form/edit";
//  			
//
//  			
//  		}
//  		//更新処理(UPDATE)
//  		@RequestMapping("/edit/{id}/exe")
//  		public String editExe(@PathVariable Long id, Model model, Form form) {
//  			//フォームの値をエンティティに入れ直し
//  			EntForm entform = new EntForm();
//  			System.out.println(form.getName1());//取得できているかの確認
//  			entform.setName(form.getName1());
//  			//更新の実行
//  			sampledao.updateDb(id,entform);
//  			//一覧画面へリダイレクト
//  			return "redirect:/index";
//  		}
}
