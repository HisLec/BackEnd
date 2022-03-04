package edu.handong.walab.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Administrator {
	int id;
	int user_id;
	String phone;
	String name;
	String email;
	int emailYN;
	@JsonFormat(pattern = "yyyy-MM-dd") 
	Date del_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmailYN() {
		return emailYN;
	}
	public void setEmailYN(int emailYN) {
		this.emailYN = emailYN;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", user_id=" + user_id + ", phone=" + phone + ", name=" + name + ", email="
				+ email + ", emailYN=" + emailYN + ", del_date=" + del_date + "]";
	}
	
	
}
