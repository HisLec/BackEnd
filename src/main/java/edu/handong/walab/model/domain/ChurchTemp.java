package edu.handong.walab.model.domain;

import java.util.Date;

public class ChurchTemp {
	int id;
	int application_form_id;
	int church_id;
	String city;
	String district;
	String zip_code;
	String addr1;
	String addr2;
	String writer_name;
	int status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "ChurchTemp [id=" + id + ", application_form_id=" + application_form_id + ", church_id=" + church_id
				+ ", city=" + city + ", district=" + district + ", zip_code=" + zip_code + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", status=" + status + ", reg_date=" + reg_date + "]";
	}
	
	

}
