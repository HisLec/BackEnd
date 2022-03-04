package edu.handong.walab.service;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LectureRegionService {
	public String getLectureRegionJsonData() throws JsonProcessingException;

	public String getLectureRegionByLectureId(int lectureId) throws JsonProcessingException;

	public void updateLectureRegion(String id, List<Map<String, Object>> regionMap);
}
