package edu.handong.walab.service;

import java.util.List;
import java.util.Map;

public interface LectureDateService {
	String readByLectureId(int lecture_id);

	void create(String lecture_id, String date);

	void update(String id, String lecture_id, String date);

	void delete(String id);

	void updateLectureDate(String id, List<Map<String, Object>> dateMap);
}
