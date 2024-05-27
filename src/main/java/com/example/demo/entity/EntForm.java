package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class EntForm {
	private int id;
	private String name;
	private String place;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // フォーマットを指定
	private String syoumkigen;

	public EntForm() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	public String getSyoumkigen() {
		return syoumkigen;
	}

	public void setSyoumkigen(String syoumkigen) {
		this.syoumkigen = syoumkigen;
	}
}
