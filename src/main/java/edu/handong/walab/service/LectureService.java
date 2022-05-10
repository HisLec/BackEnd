package edu.handong.walab.service;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.Lecture;
import edu.handong.walab.model.domain.LectureDate;

public interface LectureService {
	
	public String getLectureJsonData(String keyword) throws JsonProcessingException;
	
	public String getAllLectureJsonData() throws JsonProcessingException;
	
	public String getLectureJsonDataBySubject(String[] subject) throws JsonProcessingException;
	
	public String getLectureTopicJsonDataBySubject() throws JsonProcessingException;

	public String getLectureJsonDataByInstructor(int instructorId) throws JsonProcessingException;

	public String getLectureJsonDataByDate(String date) throws JsonProcessingException;

	public String getLectureDetailJsonData(int lectureId) throws JsonProcessingException;

	public void insertLecture(Lecture lectureData, String[] dateData, String[] topicValue, String[] regionValue) throws JsonProcessingException;

	public String readMainCalendar(int instructor_id, String date) throws JsonProcessingException;

	public String readLectureCalendar(String lecture_id, String date) throws JsonProcessingException;

	public void recoverLecture(int parseInt);

	public void deleteLecture(int parseInt);

	public String getLectureDetailByLectureId(int lectureId) throws JsonProcessingException;

	public void update(String id, String name, String intro, String sample_url, String start_date, String end_date,
			String day_week, String morning, String afternoon, String evening);

	public String getStatsByLecture(int period) throws JsonProcessingException;

	public String getAdminLectureJsonData(String keyword) throws JsonProcessingException;

	public void deleteLectureByLectureId(int instructor_id);

	public Lecture getLectureByLectureId(int lecture_id);

}
