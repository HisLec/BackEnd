package edu.handong.walab.model.dto;

public class LectureForMainCaledar {
	int id;
	int instructor_id;
	String name;
	String intro;
	String inst_name;
	String phone;
	int date_id;
	String date;
	int form_id;
	int lecture_date_id;
	String contact_start_date;
	String contact_end_date;
	int status;
	String admin_name;
	String church_name;
	int lecture_id;
	String region_list;
	String topic_list;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
	public int getDate_id() {
		return date_id;
	}
	public void setDate_id(int date_id) {
		this.date_id = date_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getLecture_date_id() {
		return lecture_date_id;
	}
	public void setLecture_date_id(int lecture_date_id) {
		this.lecture_date_id = lecture_date_id;
	}
	public String getContact_start_date() {
		return contact_start_date;
	}
	public void setContact_start_date(String contact_start_date) {
		this.contact_start_date = contact_start_date;
	}
	public String getContact_end_date() {
		return contact_end_date;
	}
	public void setContact_end_date(String contact_end_date) {
		this.contact_end_date = contact_end_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getChurch_name() {
		return church_name;
	}
	public void setChurch_name(String church_name) {
		this.church_name = church_name;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getRegion_list() {
		return region_list;
	}
	public void setRegion_list(String region_list) {
		this.region_list = region_list;
	}
	public String getTopic_list() {
		return topic_list;
	}
	public void setTopic_list(String topic_list) {
		this.topic_list = topic_list;
	}
	
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	@Override
	public String toString() {
		return "LectureForMainCalenar [id=" + id + ", instructor_id=" + instructor_id + ", name=" + name + ", intro="
				+ intro + ", inst_name=" + inst_name + ", phone=" + phone + ", date_id=" + date_id + ", date=" + date
				+ ", lecture_date_id=" + lecture_date_id + ", contact_start_date=" + contact_start_date
				+ ", contact_end_date=" + contact_end_date + ", status=" + status + ", admin_name=" + admin_name
				+ ", church_name=" + church_name + ", lecture_id=" + lecture_id + ", region_list=" + region_list
				+ ", topic_list=" + topic_list + "]";
	}
	
	
}
