package edu.handong.walab.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.ApplicationForm;
import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.model.dto.ApplicationWithFeedback;

import edu.handong.walab.model.dto.StatAllData;

import edu.handong.walab.model.dto.Statistics;
import edu.handong.walab.model.dto.StatisticsByInstructor;

@Repository
public class SimpleApplicationDAO implements ApplicationDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "application";

	@Override
	public List<ContactApplication> read(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);

		return sqlSession.selectList(namespace+".read", param);
	}


	@Override
	public List<ContactApplication> readAll(String keyword, int status) {

		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
	    param.put("status", status);

		return sqlSession.selectList(namespace+".readAll", param);
	}

	@Override
	public void updateApplication(int application_form_id, String contact_start_date, String contact_end_date, String contact_memo, int lecture_date_id, int status) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("application_form_id", application_form_id);
		param.put("contact_start_date", contact_start_date);
	    param.put("contact_end_date", contact_end_date);
	    param.put("contact_memo", contact_memo);
	    param.put("lecture_date_id", lecture_date_id);
	    param.put("status", status);

	    sqlSession.update(namespace+".updateApplication", param);

	}

	@Override
	public void createApplication(int user_id, int lecture_id, int lecture_date_id, int church_id,
			String memo, String admin_phone, String admin_name, String admin_email, int attendee_number, String attendee_target, String timezone) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", user_id);
		param.put("lecture_id", lecture_id);
	    param.put("lecture_date_id", lecture_date_id);
//	    if(church_id == 0)
//	    	param.put("church_id", null);
//	    else
	    	param.put("church_id", church_id);
	    param.put("memo", memo);
		param.put("admin_phone", admin_phone);
	    param.put("admin_name", admin_name);
	    param.put("admin_email", admin_email);
	    param.put("attendee_number", attendee_number);
	    param.put("attendee_target", attendee_target);
	    param.put("timezone", timezone);

		sqlSession.insert(namespace+".createApplication", param);

	}

	@Override
	public int getLastId() {
		return sqlSession.selectOne(namespace+".getLastId");
	}

	@Override
	public String updateStatus(int application_form_id, int status) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("application_form_id", application_form_id);
	    param.put("status", status);

		int result = sqlSession.update(namespace+".updateStatus", param);
		if(result == 1) {
			return "success";
		}
		return "error";
	}


	@Override
	public List<ApplicationWithFeedback> readApplicationForVisitingLog(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);

		return sqlSession.selectList(namespace+".readApplicationForVisitingLog", param);
	}

	@Override
	public List<ApplicationWithFeedback> readApplicationForFeedback(int user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", user_id);

		return sqlSession.selectList(namespace+".readApplicationForFeedback", param);
	}
	
	@Override
	public List<ApplicationWithFeedback> readContactedApplicationForFeedback(int user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", user_id);

		return sqlSession.selectList(namespace+".readContactedApplicationForFeedback", param);
	}

	@Override
	public List<ApplicationWithFeedback> readAllApplicationForVisitingLog(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);

		return sqlSession.selectList(namespace+".readAllApplicationForVisitingLog", param);
	}

	@Override
	public List<ApplicationWithFeedback> readAllApplicationForFeedback(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);

		return sqlSession.selectList(namespace+".readAllApplicationForFeedback", param);
	}


	@Override
	public void updateChurchId(String application_form_id, int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("application_form_id", application_form_id);
	    param.put("church_id", church_id);

		sqlSession.update(namespace+".updateChurchId", param);
	}


	@Override
	public List<Statistics> statisticsBasedOnReligiousBody(String period) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("period", period);

		return sqlSession.selectList(namespace+".statisticsBasedOnReligiousBody", param);
	}


	@Override
	public List<Statistics> statisticsBasedOnRegion(String period) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("period", period);

		return sqlSession.selectList(namespace+".statisticsBasedOnRegion", param);
	}


	@Override
	public List<StatisticsByInstructor> statisticsBasedOnInstructor(String period) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("period", period);

		return sqlSession.selectList(namespace+".statisticsBasedOnInstructor", param);
	}

	@Override
	public void cancelNotFinishByInstructor(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);
	    sqlSession.update(namespace+".cancelNotFinishByInstructor", param);
	}



	@Override
	public void cancelFinishByInstructor(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);
	    sqlSession.update(namespace+".cancelFinishByInstructor", param);
	}


	@Override
	public void cancelNotFinishByLecture(int lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    sqlSession.update(namespace+".cancelNotFinishByLecture", param);
	}


	@Override
	public void cancelFinishByLecture(int lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    sqlSession.update(namespace+".cancelFinishByLecture", param);
	}
	
	@Override
	public void cancelFinishByChurch(int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("church_id", church_id);
	    sqlSession.update(namespace+".cancelFinishByChurch", param);
	}
	
	@Override
	public void cancelNotFinishByChurch(int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("church_id", church_id);
	    sqlSession.update(namespace+".cancelNotFinishByChurch", param);
	}


	@Override
	public List<StatAllData> readStatAllData() {
		return sqlSession.selectList(namespace+".statAllData");
	}


	@Override
	public ApplicationForm readByUserID(int userID) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", userID);		
	    return sqlSession.selectOne(namespace+".readByUserID", param);
	}


	@Override
	public ApplicationForm readByID(int application_form_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("application_form_id", application_form_id);		
	    return sqlSession.selectOne(namespace+".readByID", param);
	}
}
