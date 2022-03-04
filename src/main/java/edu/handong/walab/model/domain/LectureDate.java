package edu.handong.walab.model.domain;

import java.util.Date;

public class LectureDate {
	int id;
	int lecture_id;
	String date;
	Date reg_date;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


}
