package edu.handong.walab.model.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	int id;
	String email;
	int status;
	String token;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date expire_token;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date reg_date;
	
	
	public User() {}
	
	public User(String email, int status) {
		super();
		this.email = email;
		this.status = status;
	}
	
	public User(int id, String email, int status, String token, Date expire_token) {
		super();
		this.id = id;
		this.email = email;
		this.status = status;
		this.token = token;
		this.expire_token = expire_token;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpire_token() {
		return expire_token;
	}

	public void setExpire_token(Date expire_token) {
		this.expire_token = expire_token;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}
