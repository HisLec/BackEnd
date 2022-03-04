package edu.handong.walab.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.handong.walab.model.domain.LectureDate;

public interface LectureDateDAO {
	
	public List<LectureDate> readByLectureId(int lecture_id);

	public int readByDate(int lecture_id, String date);
	
	public void insertDate(int lecture_id, String selectDate);

	public int readLastId();

	public void create(String lecture_id, String date);

	public void update(String id, String lecture_id, String date);

	public void delete(String id, ArrayList<Integer> dateList);

	public void deleteByChange(String id);
	
}

