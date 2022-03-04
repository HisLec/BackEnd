package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Feedback;
import edu.handong.walab.model.dto.FeedbackByLecture;

@Repository
public class SimpleVisitingLogDAO implements VisitingLogDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "visitingLog";

	@Override
	public Feedback writeFeedbackLog(Feedback feedback) {
		sqlSession.insert(namespace+".writeFeedback", feedback);
		return feedback;
	}

	@Override
	public void writeFeedbackLogFile(int feedback_id, List<String> file) {
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("feedback_id", feedback_id);
	    param.put("fileData", file.toArray(new String[file.size()]));
	    
		sqlSession.insert(namespace+".writeFeedbackFile", param);
	}

	@Override
	public List<String> readFeedbackFile(int feedback_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("feedback_id", feedback_id);
	    
		return sqlSession.selectList(namespace+".readFeedbackFile", param);
	}

	@Override
	public Feedback writeVisitingLog(Feedback visiting_log) {
		
		sqlSession.insert(namespace+".writeVisitingLog", visiting_log);
		
		return visiting_log;
	}

	@Override
	public void writeVisitingLogFile(int visiting_log_id, List<String> file) {
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("visiting_log_id", visiting_log_id);
	    param.put("fileData", file.toArray(new String[file.size()]));
	    
		sqlSession.insert(namespace+".writeVisitingLogFile", param);
	}

	@Override
	public List<String> readVisitingLogFile(int visiting_log_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("visiting_log_id", visiting_log_id);
	    
		return sqlSession.selectList(namespace+".readVisitingLogFile", param);
	}

	@Override
	public List<FeedbackByLecture> readFeedbackByInstructor(String instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);
	    return sqlSession.selectList(namespace+".readFeedbackByInstructor", param);
	}
	
	@Override
	public List<String> readFeedbackFileByInstructor(String instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);
	    return sqlSession.selectList(namespace+".readFeedbackFileByInstructor", param);
	}

	@Override
	public List<FeedbackByLecture> readFeedbackByTopic(String[] topic) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("topic_id", topic);
	    return sqlSession.selectList(namespace+".readFeedbackByTopic", param);
	}
	
	@Override
	public List<String> readFeedbackFileByTopic(String[] topic) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("topic_id", topic);
	    return sqlSession.selectList(namespace+".readFeedbackFileByTopic", param);
	}
	
	@Override
	public List<String> readFeedbackFileByLecture(String lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    return sqlSession.selectList(namespace+".readFeedbackFileByLecture", param);
	}
	
	@Override
	public List<String> readFeedbackFileByDate(String date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("date", date);
	    return sqlSession.selectList(namespace+".readFeedbackFileByDate", param);
	}

	@Override
	public List<FeedbackByLecture> readFeedbackByLecture(String lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    return sqlSession.selectList(namespace+".readFeedbackByLecture", param);
	}

	@Override
	public void delete(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".delete", param);
	}
	
	@Override
	public void deleteFile(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".deleteFile", param);
	}

	@Override
	public void deleteFeedback(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".deleteFeedback", param);
	}
	
	@Override
	public void deleteFeedbackFile(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".deleteFeedbackFile", param);
	}

	@Override
	public int readVisitingCreator(int application_form_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("application_form_id", application_form_id);
	    return sqlSession.selectOne(namespace+".readVisitingCreator", param);
	}

}
