package com;

public class UserDTO {
	private String name;
	private String number;
	private String id;
	private String pw;
	private String email;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}

	public UserDTO(String name, String number, String id, String pw, String email) {
		super();
		this.name = name;
		this.number = number;
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserInfo() {
		return name + " / " + number;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", number=" + number + ", id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}

}
