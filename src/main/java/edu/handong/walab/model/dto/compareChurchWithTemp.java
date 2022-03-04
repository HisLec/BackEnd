package edu.handong.walab.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class compareChurchWithTemp {
	int id;
	int application_form_id;
	int church_id;
	int status;
	String new_name;
	String new_city;
	String new_district;
	String new_zip_code;
	String new_addr1;
	String new_addr2;
	String new_pastor;
	String new_email;
	String new_phone;
	String admin_name;
	String admin_phone;
	String denomination;
	String name;
	String city;
	String district;
	String zip_code;
	String addr1;
	String addr2;
	String pastor;
	String phone;
	String email;
	String writer_name;
	@JsonFormat(pattern = "yyyy-MM-dd") 
	Date reg_date;
	
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
	public int getChurch_id() {
		return church_id;
	}
	public void setChurch_id(int church_id) {
		this.church_id = church_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_phone() {
		return admin_phone;
	}
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getNew_pastor() {
		return new_pastor;
	}
	public void setNew_pastor(String new_pastor) {
		this.new_pastor = new_pastor;
	}
	public String getNew_email() {
		return new_email;
	}
	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}
	public String getNew_phone() {
		return new_phone;
	}
	public void setNew_phone(String new_phone) {
		this.new_phone = new_phone;
	}
	public String getPastor() {
		return pastor;
	}
	public void setPastor(String pastor) {
		this.pastor = pastor;
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
}
