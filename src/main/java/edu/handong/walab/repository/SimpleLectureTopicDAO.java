package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Topic;
import edu.handong.walab.model.dto.LectureTopicInfo;

@Repository
public class SimpleLectureTopicDAO implements LectureTopicDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "lectureTopic";
	
	@Override
	public List<Topic> getLectureCategory() {
		
		return sqlSession.selectList(namespace+".readLectureCategory");
	}
	
	@Override
	public void insertLectureTopic(int lectureId, int[] topicId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    param.put("topic_id", topicId);
	    
		sqlSession.insert(namespace+".insertLectureTopic",param);
	}

	@Override
	public void createTopic(String name, int status, int disable, int priority) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    param.put("status", status);
	    param.put("disable", disable);
	    param.put("priority", priority);
	    
	    sqlSession.insert(namespace+".create", param);
	}

	@Override
	public List<Topic> readTopic(String keyword, int status) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
	    param.put("status", status);
	    
		return sqlSession.selectList(namespace+".readAdmin", param);
	}

	@Override
	public void updateTopic(String name, int id, int status, int disable, int priority) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    param.put("id", id);
	    param.put("status", status);
	    param.put("disable", disable);
	    param.put("priority", priority);
	    
	    sqlSession.update(namespace+".update", param);
	}

	@Override
	public void statusTopic(int status, int category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", category_id);
	    param.put("status", status);
	    
	    sqlSession.update(namespace+".updateStatus", param);
	}

	@Override
	public void disableTopic(int disable, int category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("disable", disable);
	    param.put("id", category_id);
	    
		sqlSession.update(namespace+".updateDisable", param);
	}

	@Override
	public List<LectureTopicInfo> getLectureTopicByLectureId(int lectureId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    
		return sqlSession.selectList(namespace+".readTopicByLectureId", param);
	}

	@Override
	public void deleteByLectureId(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    sqlSession.delete(namespace+".deleteLectureTopic", param);
	}

	@Override
	public void createLectureTopic(String id, int topic_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    param.put("topic_id", topic_id);
	    sqlSession.delete(namespace+".createLectureTopic", param);
	}

	@Override
	public Topic readTopicByName(String name) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    return sqlSession.selectOne(namespace+".readTopicByName", param);
	}
}
