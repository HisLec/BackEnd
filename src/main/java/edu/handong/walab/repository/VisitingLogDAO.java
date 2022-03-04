package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Feedback;
import edu.handong.walab.model.dto.FeedbackByLecture;

public interface VisitingLogDAO {
	
	public Feedback writeFeedbackLog(Feedback feedback);
	
	public void writeFeedbackLogFile(int feedback_id, List<String> file);
	
	public List<String> readFeedbackFile(int feedback_id);
	
	public Feedback writeVisitingLog(Feedback visiting_log);
	
	public void writeVisitingLogFile(int visiting_log_id, List<String> file);
	
	public List<String> readVisitingLogFile(int visiting_id);

	public List<FeedbackByLecture> readFeedbackByInstructor(String instructor_id);

	public List<FeedbackByLecture> readFeedbackByTopic(String[] topic);
	
	public List<String> readFeedbackFileByTopic(String[] topic);
	
	public List<String> readFeedbackFileByLecture(String lecture_id);
	
	public List<String> readFeedbackFileByInstructor(String instructor_id);
	
	public List<String> readFeedbackFileByDate(String date);

	public List<FeedbackByLecture> readFeedbackByLecture(String lecture_id);

	public void delete(int id);

	public void deleteFile(int id);
	
	public void deleteFeedback(int id);
	
	public void deleteFeedbackFile(int id);

	public int readVisitingCreator(int application_form_id);
}
