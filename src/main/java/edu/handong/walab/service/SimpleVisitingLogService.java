package edu.handong.walab.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Feedback;
import edu.handong.walab.model.dto.FeedbackByLecture;
import edu.handong.walab.repository.VisitingLogDAO;


@Service
public class SimpleVisitingLogService implements VisitingLogService {
	
	@Autowired
	VisitingLogDAO visitingLogDAO;

	@Override
	public String writeFeedbackLog(int application_form_id, String content, int lectureRating, int instructorRating,
			List<String> file) {
		Feedback feedback = new Feedback();
		feedback.setApplication_form_id(application_form_id);
		feedback.setContent(content);
		feedback.setLecture_star(lectureRating);
		feedback.setInstructor_star(instructorRating);
		
		feedback = visitingLogDAO.writeFeedbackLog(feedback);
		visitingLogDAO.writeFeedbackLogFile(feedback.getId(), file);
		return "success";
	}

	@Override
	public String readFeedbackFile(int feedback_id) throws JsonProcessingException {
		List<String> feedbackFile = visitingLogDAO.readFeedbackFile(feedback_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackFile);
		
		return jsonString;
	}

	@Override
	public String writeVisitingLog(int application_form_id, String content, List<String> fileData) {
		Feedback feedback = new Feedback();
		feedback.setApplication_form_id(application_form_id);
		feedback.setContent(content);
		
		feedback = visitingLogDAO.writeVisitingLog(feedback);
		visitingLogDAO.writeVisitingLogFile(feedback.getId(), fileData);
		
		return "success";
	}
	
	@Override
	public String readVisitingLogFile(int visiting_log_id) throws JsonProcessingException {
		List<String> visitingLogFile = visitingLogDAO.readVisitingLogFile(visiting_log_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(visitingLogFile);
		
		return jsonString;
	}

	@Override
	public String readFeedbackByInstructor(String instructor_id) throws JsonProcessingException {
		List<FeedbackByLecture> feedbackList = visitingLogDAO.readFeedbackByInstructor(instructor_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}
	
	@Override
	public String readFeedbackFileByInstructor(String instructor_id) throws JsonProcessingException {
		List<String> feedbackList = visitingLogDAO.readFeedbackFileByInstructor(instructor_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}

	@Override
	public String readFeedbackByTopic(String[] topic) throws JsonProcessingException {
		List<FeedbackByLecture> feedbackList = visitingLogDAO.readFeedbackByTopic(topic);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}
	
	@Override
	public String readFeedbackFileByTopic(String[] topic) throws JsonProcessingException {
		List<String> feedbackList = visitingLogDAO.readFeedbackFileByTopic(topic);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}

	@Override
	public String readFeedbackByLecture(String lecture_id) throws JsonProcessingException {
		List<FeedbackByLecture> feedbackList = visitingLogDAO.readFeedbackByLecture(lecture_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}
	
	@Override
	public String readFeedbackFileByLecture(String lecture_id) throws JsonProcessingException {
		List<String> feedbackList = visitingLogDAO.readFeedbackFileByLecture(lecture_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}
	
	@Override
	public String readFeedbackFileByDate(String date) throws JsonProcessingException {
		List<String> feedbackList = visitingLogDAO.readFeedbackFileByDate(date);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(feedbackList);
		
		return jsonString;
	}

	@Override
	public void delete(int id) {
		visitingLogDAO.deleteFile(id);
		visitingLogDAO.delete(id);
	}

	@Override
	public void deleteFeedback(int id) {
		visitingLogDAO.deleteFeedbackFile(id);
		visitingLogDAO.deleteFeedback(id);
	}

	@Override
	public int readVisitingCreator(int application_form_id) {
		return visitingLogDAO.readVisitingCreator(application_form_id);
	}

}
