package edu.handong.walab.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LectureForInstructor {
	int id;
	String name;
	String intro;
	String sample_url;
	String topic;
	String region;
	String date;
	int morning;
	int afternoon;
	int evening;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date reg_date;
	
	public LectureForInstructor() {}
	
	public LectureForInstructor(int id, String name, String intro, String sample_url, String topic, String region,
			Date reg_date, int morning, int afternoon, int evening) {
		super();
		this.id = id;
		this.name = name;
		this.intro = intro;
		this.sample_url = sample_url;
		this.topic = topic;
		this.region = region;
		this.reg_date = reg_date;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening=evening;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
		return "LectureForInstructor [id=" + id + ", name=" + name + ", intro=" + intro + ", sample_url=" + sample_url
				+ ", topic=" + topic + ", region=" + region + ", date=" + date + ", morning=" + morning + ", afternoon="
				+ afternoon + ", evening=" + evening + ", reg_date=" + reg_date + "]";
	}
	
}
