package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Form {
	
	private String name1;
	private String place;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // フォーマットを指定
	private Date syoumkigen;

	public Form() {}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getSyoumkigen() {
		return syoumkigen;
	}
	public void setSyoumkigen(Date syoumkigen) {
		this.syoumkigen = syoumkigen;
	}
	
}
