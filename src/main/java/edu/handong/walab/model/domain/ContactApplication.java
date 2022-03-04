package edu.handong.walab.model.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContactApplication {
	int id;
	int user_id;
	String user_email;
	int lecture_id;
	int lecture_date_id;
	int church_id;
	String memo;
	String admin_phone;
	String admin_name;
	String admin_email;
	int attendee_number;
	String attendee_target;
	int status;
	int isVisiting;
	@JsonFormat(pattern = "HH:mm") 
	Date contact_start_date;
	@JsonFormat(pattern = "HH:mm") 
	Date contact_end_date;
	Date reg_date;
//	@JsonFormat(pattern = "yyyy-MM-dd") 
//	Date date;
	String date;
	Date start_date;
	Date end_date;
	String church_name;
	String city;
	String district;
	String zip_code;
	String addr1;
	String addr2;
	String phone;
	String email;
	String page_url;
	String lecture_name;
	String intro;
	String sample_url;
	String timezone;
	String inst_name;
	String visit_log;
	Date visit_reg_date;
	String new_name;
	String new_city;
	String new_district;
	String new_zip_code;
	String new_addr1;
	String new_addr2;
	
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
	public Date getContact_start_date() {
		return contact_start_date;
	}
	public void setContact_start_date(Date contact_start_date) {
		this.contact_start_date = contact_start_date;
	}
	public Date getContact_end_date() {
		return contact_end_date;
	}
	public void setContact_end_date(Date contact_end_date) {
		this.contact_end_date = contact_end_date;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getChurch_name() {
		return church_name;
	}
	public void setChurch_name(String church_name) {
		this.church_name = church_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPage_url() {
		return page_url;
	}
	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
	public String getLecture_name() {
		return lecture_name;
	}
	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getSample_url() {
		return sample_url;
	}
	public void setSample_url(String sample_url) {
		this.sample_url = sample_url;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getInst_name() {
		return inst_name;
	}
	public void setInst_name(String inst_name) {
		this.inst_name = inst_name;
	}
	public String getVisit_log() {
		return visit_log;
	}
	public void setVisit_log(String visit_log) {
		this.visit_log = visit_log;
	}
	public Date getVisit_reg_date() {
		return visit_reg_date;
	}
	public void setVisit_reg_date(Date visit_reg_date) {
		this.visit_reg_date = visit_reg_date;
	}
	
	
	public String getNew_name() {
		return new_name;
	}
	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}
	public String getNew_city() {
		return new_city;
	}
	public void setNew_city(String new_city) {
		this.new_city = new_city;
	}
	public String getNew_district() {
		return new_district;
	}
	public void setNew_district(String new_district) {
		this.new_district = new_district;
	}
	public String getNew_zip_code() {
		return new_zip_code;
	}
	public void setNew_zip_code(String new_zip_code) {
		this.new_zip_code = new_zip_code;
	}
	public String getNew_addr1() {
		return new_addr1;
	}
	public void setNew_addr1(String new_addr1) {
		this.new_addr1 = new_addr1;
	}
	public String getNew_addr2() {
		return new_addr2;
	}
	public void setNew_addr2(String new_addr2) {
		this.new_addr2 = new_addr2;
	}
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getIsVisiting() {
		return isVisiting;
	}
	public void setIsVisiting(int isVisiting) {
		this.isVisiting = isVisiting;
	}
	
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	@Override
	public String toString() {
		return "ContactApplication [id=" + id + ", user_id=" + user_id + ", lecture_id=" + lecture_id
				+ ", lecture_date_id=" + lecture_date_id + ", church_id=" + church_id + ", memo=" + memo
				+ ", admin_phone=" + admin_phone + ", admin_name=" + admin_name + ", attendee_number=" + attendee_number
				+ ", attendee_target=" + attendee_target + ", status=" + status + ", contact_start_date="
				+ contact_start_date + ", contact_end_date=" + contact_end_date + ", reg_date=" + reg_date + ", date="
				+ date + ", start_date=" + start_date + ", end_date=" + end_date + ", church_name=" + church_name
				+ ", city=" + city + ", district=" + district + ", zip_code=" + zip_code + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", phone=" + phone + ", email=" + email + ", page_url=" + page_url
				+ ", lecture_name=" + lecture_name + ", intro=" + intro + ", sample_url=" + sample_url + ", timezone="
				+ timezone + ", inst_name=" + inst_name + ", visit_log=" + visit_log + ", visit_reg_date="
				+ visit_reg_date + "]";
	}
	
	
}
