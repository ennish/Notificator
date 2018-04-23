package com.enn.notifier;

public class Receiver {

	private String name;
	private String phone;
	private String mail;
	public String getName() {
		return name;
	}
	public Receiver(String name, String phone, String mail) {
		super();
		this.name = name;
		this.phone = phone;
		this.mail = mail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
