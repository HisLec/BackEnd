package edu.handong.walab.model.domain;

import java.util.Date;

public class Feedback {
	int id;
	int application_form_id;
	int lecture_star;
	int instructor_star;
	String content;
	Date reg_date;
	Date del_date;
	int manageID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplication_form_id() {
		return application_form_id;
	}
	public void setApplication_form_id(int application_form_id) {
		this.application_form_id = application_form_id;
	}
	public int getLecture_star() {
		return lecture_star;
	}
	public void setLecture_star(int lecture_star) {
		this.lecture_star = lecture_star;
	}
	public int getInstructor_star() {
		return instructor_star;
	}
	public void setInstructor_star(int instructor_star) {
		this.instructor_star = instructor_star;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	public int getManageID() {
		return manageID;
	}
	public void setManageID(int manageID) {
		this.manageID = manageID;
	}
	
}
