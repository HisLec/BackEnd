package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.ApplicationForm;
import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.model.dto.ApplicationWithFeedback;

import edu.handong.walab.model.dto.StatAllData;
import edu.handong.walab.model.dto.Statistics;
import edu.handong.walab.model.dto.StatisticsByInstructor;

public interface ApplicationDAO {

	public List<ContactApplication> read(int instructor_id);

	public void updateApplication(int application_form_id, String contact_start_date, String contact_end_date, String contact_memo, int lecture_date_id, int status);

	public void createApplication(int user_id, int lecture_id, int lecture_date_id, int church_id,
			String memo, String admin_phone, String admin_name, String admin_email, int attendee_number, String attendee_target, String timezone);

	public int getLastId();

	public String updateStatus(int application_form_id, int status);

	public List<ContactApplication> readAll(String keyword, int status);

	public List<ApplicationWithFeedback> readApplicationForVisitingLog(int instructor_id);

	public List<ApplicationWithFeedback> readApplicationForFeedback(int user_id);
	
	public List<ApplicationWithFeedback> readContactedApplicationForFeedback(int user_id);

	public List<ApplicationWithFeedback> readAllApplicationForFeedback(String keyword);

	public List<ApplicationWithFeedback>  readAllApplicationForVisitingLog(String keyword);

	public void updateChurchId(String application_form_id, int church_id);

	public List<Statistics> statisticsBasedOnReligiousBody(String period);

	public List<Statistics> statisticsBasedOnRegion(String period);

	public List<StatisticsByInstructor> statisticsBasedOnInstructor(String period);

	public void cancelNotFinishByInstructor(int instructor_id);

	public void cancelFinishByInstructor(int instructor_id);

	public void cancelNotFinishByLecture(int lecture_id);

	public void cancelFinishByLecture(int lecture_id);
	
	public void cancelFinishByChurch(int church_id);
	
	public void cancelNotFinishByChurch(int church_id);

	public List<StatAllData> readStatAllData();

	public ApplicationForm readByUserID(int userID);

	public ApplicationForm readByID(int application_form_id);
}
