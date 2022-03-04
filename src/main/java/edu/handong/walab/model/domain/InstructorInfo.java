package edu.handong.walab.model.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InstructorInfo {
	
	int id;
	int user_id;
	int position_id;
	String name;
	String phone;
	String image;
	MultipartFile file;
	String intro;
	String memo;
	String email;
	String position_name;
	@JsonFormat(pattern = "yyyy-MM-dd") 
	Date reg_date;
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
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getName() {
		return name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	@Override
	public String toString() {
		return "InstructorInfo [id=" + id + ", user_id=" + user_id + ", position_id=" + position_id + ", name=" + name
				+ ", phone=" + phone + ", image=" + image + ", file=" + file + ", intro=" + intro + ", memo=" + memo
				+ ", email=" + email + ", reg_date=" + reg_date + "]";
	}
	
}
