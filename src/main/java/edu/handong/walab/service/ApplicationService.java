package edu.handong.walab.service;

import java.util.List;

import edu.handong.walab.model.domain.ApplicationForm;
import edu.handong.walab.model.dto.Statistics;
import edu.handong.walab.model.dto.StatisticsByInstructor;

public interface ApplicationService {
	
	public String read(int instructor_id);

	public String completeContact(int application_form_id, String selectDate, int lecture_id, String contact_start_date, String contact_end_date, String contact_memo, int status);

	public void createApplication(int user_id, int lecture_id, int lecture_date_id, int church_id,
			String memo, String admin_phone, String admin_name, String admin_email, int attendee_number, String attendee_target, String timezone);
	
	public void writeEmail(String instEmail, String date, String subject, String church, String link);

	public int getLastId();

	public String updateStatus(int application_form_id, int status);

	public String readAll(String keyword, String status);
	
	public String readApplicationForVisitingLog(int instructor_id);
	
	public String readApplicationForFeedback(int user_id);
	
	public String readContactedApplicationForFeedback(int user_id);
	
	public String readAllApplicationForFeedback(String keyword);
	
	public String readAllApplicationForVisitingLog (String keyword);

	public void updateChurchId(String application_form_id, int church_id);
	
	public String statisticsBasedOnReligiousBody(String period);
	
	public String statisticsBasedOnRegion(String period);
	
	public String statisticsBasedOnInstructor(String period);

	public void cancelNotFinishByInstructor(int instructor_id);

	public void cancelFinishByInstructor(int instructor_id);

	public void cancelNotFinishByLecture(int lecture_id);

	public void cancelFinishByLecture(int lecture_id);

	public String readStatAllData();

	public ApplicationForm readByUserID(int userID);

	public ApplicationForm readByID(int application_form_id);
}

