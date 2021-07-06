package com.oracle.entity;

public class User {
	private String id;
	private String name;
	private String passWord;
	private String email;
	public User(String id, String name, String passWord, String email) {
		super();
		this.id = id;
		this.name = name;
		this.passWord = passWord;
		this.email = email;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
