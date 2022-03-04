package edu.handong.walab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface VisitingLogService {
	
	String readFeedbackFile(int feedback_id) throws JsonProcessingException;
	
	String readVisitingLogFile(int visiting_log_id) throws JsonProcessingException;
	
	String writeFeedbackLog(int application_form_id, String content, int lectureRating, int instructorRating, List<String> file);
	
	String writeVisitingLog(int application_form_id, String content, List<String> fileData);

	String readFeedbackByInstructor(String instructor_id) throws JsonProcessingException;
	
	public String readFeedbackFileByInstructor(String instructor_id) throws JsonProcessingException;

	String readFeedbackByTopic(String[] topic) throws JsonProcessingException;
	
	String readFeedbackFileByTopic(String[] topic) throws JsonProcessingException;

	String readFeedbackByLecture(String lecture_id) throws JsonProcessingException;
	
	public String readFeedbackFileByDate(String date) throws JsonProcessingException;
	
	public String readFeedbackFileByLecture(String lecture_id) throws JsonProcessingException;

	void delete(int parseInt);

	void deleteFeedback(int id);

	int readVisitingCreator(int application_form_id);
}
