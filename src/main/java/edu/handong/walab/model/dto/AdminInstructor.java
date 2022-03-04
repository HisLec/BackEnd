package edu.handong.walab.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdminInstructor {
	int id;
	int user_id;
	int position_id;
	String inst_name;
	String phone;
	String image;
	String intro;
	String memo;
	@JsonFormat(pattern = "yyyy-MM-dd") 
	Date reg_date;
	@JsonFormat(pattern = "yyyy-MM-dd") 
	Date del_date;
	String position_name;
	String email;
	int status;
	
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
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getInst_name() {
		return inst_name;
	}
	public void setInst_name(String inst_name) {
		this.inst_name = inst_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
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
	
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	@Override
	public String toString() {
		return "AdminInstructor [id=" + id + ", user_id=" + user_id + ", position_id=" + position_id + ", inst_name="
				+ inst_name + ", phone=" + phone + ", image=" + image + ", intro=" + intro + ", memo=" + memo
				+ ", reg_date=" + reg_date + ", position_name=" + position_name + ", email=" + email + ", status="
				+ status + "]";
	}
	
	

}
