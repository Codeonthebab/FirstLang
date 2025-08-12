package com.actiontag;

public class Customer {
	private String name;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getTel() {
		return tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	private String email;
	private String tel;
	private String birth;
}
