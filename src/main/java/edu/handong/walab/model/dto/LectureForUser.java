package edu.handong.walab.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LectureForUser {
	int id;
	String instructor_name;
	String instructor_intro;
	String instructor_memo;
	String instructor_image;
	String instructor_email;
	String instructor_position;
	String name;
	String intro;
	String sample_url;
	String topic;
	String region;
	String date;
	String topic_name;
	int morning;
	int afternoon;
	int evening;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date reg_date;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date del_date;
	
	public LectureForUser() {}
	
	public LectureForUser(int id, String instructor_name, String instructor_email, String name, String intro, String sample_url, String topic,
			String region,String date, Date reg_date, int morning, int afternoon, int evening) {
		super();
		this.id = id;
		this.instructor_name = instructor_name;
		this.instructor_email = instructor_email;
		this.name = name;
		this.intro = intro;
		this.sample_url = sample_url;
		this.topic = topic;
		this.region = region;
		this.date = date;
		this.reg_date = reg_date;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public String getInstructor_email() {
		return instructor_email;
	}

	public void setInstructor_email(String instructor_email) {
		this.instructor_email = instructor_email;
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
	
	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Date getDel_date() {
		return del_date;
	}

	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}

	public String getInstructor_intro() {
		return instructor_intro;
	}

	public void setInstructor_intro(String instructor_intro) {
		this.instructor_intro = instructor_intro;
	}

	public String getInstructor_image() {
		return instructor_image;
	}

	public void setInstructor_image(String instructor_image) {
		this.instructor_image = instructor_image;
	}

	public String getInstructor_memo() {
		return instructor_memo;
	}

	public void setInstructor_memo(String instructor_memo) {
		this.instructor_memo = instructor_memo;
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

	public String getInstructor_position() {
		return instructor_position;
	}

	public void setInstructor_position(String instructor_position) {
		this.instructor_position = instructor_position;
	}

	@Override
	public String toString() {
		return "LectureForUser [id=" + id + ", instructor_name=" + instructor_name + ", instructor_intro="
				+ instructor_intro + ", instructor_memo=" + instructor_memo + ", instructor_image=" + instructor_image
				+ ", instructor_email=" + instructor_email + ", instructor_position=" + instructor_position + ", name="
				+ name + ", intro=" + intro + ", sample_url=" + sample_url + ", topic=" + topic + ", region=" + region
				+ ", date=" + date + ", morning=" + morning + ", afternoon=" + afternoon + ", evening=" + evening
				+ ", reg_date=" + reg_date + ", del_date=" + del_date + "]";
	}
	
}
