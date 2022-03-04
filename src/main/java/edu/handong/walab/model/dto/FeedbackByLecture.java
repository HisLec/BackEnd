package edu.handong.walab.model.dto;

public class FeedbackByLecture {
	int id;
	int application_form_id;
	int lecture_star;
	int instructor_star;
	String content;
	String reg_date;
	int lecture_id;
	String topic_list;
	int instructor_id;
	String lecture_name;
	String church_name;
	String instructor_name;
	int position_id;
	String position_name;
	
	
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getTopic_list() {
		return topic_list;
	}
	public void setTopic_list(String topic_list) {
		this.topic_list = topic_list;
	}
	public int getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getLecture_name() {
		return lecture_name;
	}
	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}
	public String getChurch_name() {
		return church_name;
	}
	public void setChurch_name(String church_name) {
		this.church_name = church_name;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
}
