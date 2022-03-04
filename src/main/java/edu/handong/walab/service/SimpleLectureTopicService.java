package edu.handong.walab.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Category;
import edu.handong.walab.model.domain.Topic;
import edu.handong.walab.model.dto.LectureTopicInfo;
import edu.handong.walab.repository.LectureTopicDAO;

@Service
public class SimpleLectureTopicService implements LectureTopicService{
	
	@Autowired
	LectureTopicDAO lectureTopicDAO;

	@Override
	public String getLectureTopicJsonData() throws JsonProcessingException {
		List<Topic> lectureCategory =  lectureTopicDAO.getLectureCategory();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureCategory);
		return jsonString;
	}

	@Override
	public String createTopic(String name, int status, int disable, int priority) {
		if(lectureTopicDAO.readTopicByName(name) != null)
			return "중복된 주제입니다.";
		lectureTopicDAO.createTopic(name, status, disable, priority);
		return "주제가 추가되었습니다.";
	}

	@Override
	public String readTopic(String keyword, String status) {
		
		int statusValue = -2;
		
		if(keyword != null) {
			keyword = "%".concat(keyword).concat("%");
		}else {
			keyword = "%%";
		}
		
		if(status != null) {
			statusValue = Integer.parseInt(status);
		}
		
		List<Topic> category = lectureTopicDAO.readTopic(keyword, statusValue);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(category);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateTopic(String name, int id, int status, int disable, int priority) {
		lectureTopicDAO.updateTopic(name, id, status, disable, priority);	
	}

	@Override
	public void statusTopic(int status, int category_id) {
		lectureTopicDAO.statusTopic(status, category_id);
	}

	@Override
	public void disableTopic(int disable, int category_id) {
		lectureTopicDAO.disableTopic(disable, category_id);
	}

	@Override
	public String getLectureTopicByLectureId(int lectureId) throws JsonProcessingException {
		List<LectureTopicInfo> lectureCategory =  lectureTopicDAO.getLectureTopicByLectureId(lectureId);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureCategory);
		return jsonString;
	}

	@Override
	public void updateLectureTopic(String id, List<Map<String, Object>> topicMap) {
		lectureTopicDAO.deleteByLectureId(id);
		for(int i=0 ; i<topicMap.size() ; i++) {
			int topic_id = Integer.parseInt(topicMap.get(i).get("id").toString());
			if(topicMap.get(i).get("status").toString().equals("1"))
				lectureTopicDAO.createLectureTopic(id, topic_id);
		}
	}

	
}
