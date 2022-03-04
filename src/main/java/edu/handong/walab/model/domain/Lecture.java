package edu.handong.walab.model.domain;

import java.sql.Date;

public class Lecture {
	int id;
	int instructor_id;
	String name;
	String intro;
	String sample_url;
	String start_date;
	String end_date;
	String day_week;
	int morning;
	int afternoon;
	int evening;
	Date regDate;
	
	public Lecture() {}

	public Lecture(int instructor_id, String name, String intro, String sample_url, String start_date, String end_date, String day_week, int morning,
			int afternoon, int evening, Date regDate) {
		super();
		this.instructor_id = instructor_id;
		this.name = name;
		this.intro = intro;
		this.sample_url = sample_url;
		this.start_date = start_date;
		this.end_date = end_date;
		this.day_week = day_week;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.regDate = regDate;
	}

	
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

	public String getSample_url() {
		return sample_url;
	}

	public void setSample_url(String sample_url) {
		this.sample_url = sample_url;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDay_week() {
		return day_week;
	}

	public void setDay_week(String day_week) {
		this.day_week = day_week;
	}

	public int getMorning() {
		return morning;
	}

	public void setMorning(int morning) {
		this.morning = morning;
	}

	public int getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(int afternoon) {
		this.afternoon = afternoon;
	}

	public int getEvening() {
		return evening;
	}

	public void setEvening(int evening) {
		this.evening = evening;
	}

	@Override
	public String toString() {
		return "Lecture [instructor_id=" + instructor_id + ", name=" + name + ", intro=" + intro
				+ ", sample_url=" + sample_url + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", day_week=" + day_week + ", morning=" + morning + ", afternoon=" + afternoon + ", evening="
				+ evening + ", regDate=" + regDate + "]";
	}
}
