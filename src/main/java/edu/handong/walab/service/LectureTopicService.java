package edu.handong.walab.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LectureTopicService {

	String getLectureTopicJsonData() throws JsonProcessingException;

	String createTopic(String name, int status, int disable, int priority);

	String readTopic(String keyword, String status);

	void updateTopic(String name, int id, int status, int disable, int priority);

	void statusTopic(int status, int category_id);

	void disableTopic(int disable, int category_id);

	String getLectureTopicByLectureId(int lectureId) throws JsonProcessingException;

	void updateLectureTopic(String id, List<Map<String, Object>> topicMap);
}

