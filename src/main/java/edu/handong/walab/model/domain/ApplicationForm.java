package edu.handong.walab.model.domain;

import java.util.Date;

public class ApplicationForm {
	
	int id;
	int user_id;
	int lecture_id;
	int lecture_date_id;
	int church_id;
	String memo;
	String admin_phone;
	String admin_name;
	int attendee_number;
	String attendee_target;
	int status;
	String contact_start_date;
	String contact_end_date;
	Date reg_date;
	String timezone;
	
	
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
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public int getLecture_date_id() {
		return lecture_date_id;
	}
	public void setLecture_date_id(int lecture_date_id) {
		this.lecture_date_id = lecture_date_id;
	}
	public int getChurch_id() {
		return church_id;
	}
	public void setChurch_id(int church_id) {
		this.church_id = church_id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public int getAttendee_number() {
		return attendee_number;
	}
	public void setAttendee_number(int attendee_number) {
		this.attendee_number = attendee_number;
	}
	public String getAttendee_target() {
		return attendee_target;
	}
	public void setAttendee_target(String attendee_target) {
		this.attendee_target = attendee_target;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	@Override
	public String toString() {
		return "ApplicationForm [id=" + id + ", user_id=" + user_id + ", lecture_id=" + lecture_id
				+ ", lecture_date_id=" + lecture_date_id + ", church_id=" + church_id + ", memo=" + memo
				+ ", admin_phone=" + admin_phone + ", admin_name=" + admin_name + ", attendee_number=" + attendee_number
				+ ", attendee_target=" + attendee_target + ", status=" + status + ", contact_start_date="
				+ contact_start_date + ", contact_end_date=" + contact_end_date + ", reg_date=" + reg_date
				+ ", timezone=" + timezone + "]";
	}
	
}
