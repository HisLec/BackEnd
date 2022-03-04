package edu.handong.walab.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LectureDateDetail {
	int id;
	String name;
	int status;
	int available_time;
	String church_name;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date start_time;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date end_time;
	
	public LectureDateDetail() {}
	
	public LectureDateDetail(int id, String name, int status, int available_time, String church_name, Date start_time,
			Date end_time) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.available_time = available_time;
		this.church_name = church_name;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getAvailable_time() {
		return available_time;
	}
	
	public void setAvailable_time(int available_time) {
		this.available_time = available_time;
	}
	
	public String getChurch_name() {
		return church_name;
	}
	
	public void setChurch_name(String church_name) {
		this.church_name = church_name;
	}
	
	public Date getStart_time() {
		return start_time;
	}
	
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
	public Date getEnd_time() {
		return end_time;
	}
	
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
}
