package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Topic;
import edu.handong.walab.model.dto.LectureTopicInfo;

public interface LectureTopicDAO {
	public void insertLectureTopic(int lectureId, int[]topicId);

	List<Topic> getLectureCategory();

	public void createTopic(String name, int status, int disable, int priority);

	public List<Topic> readTopic(String keyword, int status);

	public void updateTopic(String name, int id, int status, int disable, int priority);

	public void statusTopic(int status, int category_id);

	public void disableTopic(int disable, int category_id);

	public List<LectureTopicInfo> getLectureTopicByLectureId(int lectureId);

	public void deleteByLectureId(String id);

	public void createLectureTopic(String id, int topic_id);

	public Topic readTopicByName(String name);
}
