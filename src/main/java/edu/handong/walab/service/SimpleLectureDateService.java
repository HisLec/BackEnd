package edu.handong.walab.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.LectureDate;
import edu.handong.walab.model.domain.Setting;
import edu.handong.walab.repository.LectureDateDAO;

@Service
public class SimpleLectureDateService implements LectureDateService {
	@Autowired
	LectureDateDAO lectureDateDAO;
	
	@Override
	public String readByLectureId(int lecture_id) {
		
		List<LectureDate> dates =  lectureDateDAO.readByLectureId(lecture_id);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(dates);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void create(String lecture_id, String date) {
		lectureDateDAO.create(lecture_id, date);
	}

	@Override
	public void update(String id, String lecture_id, String date) {
		lectureDateDAO.update(id, lecture_id, date);
	}

	@Override
	public void delete(String id) {
//		lectureDateDAO.delete(id);
	}

	@Override
	public void updateLectureDate(String id, List<Map<String, Object>> dateMap) {
		ArrayList<Integer> dateList = new ArrayList<Integer>();
		for(int i=0 ; i<dateMap.size() ; i++) {
			String date = dateMap.get(i).get("date").toString();
			if(!dateMap.get(i).get("form_id").toString().equals("0")) {
				int lecture_date_id = lectureDateDAO.readByDate(Integer.parseInt(id), date);
				dateList.add(lecture_date_id);
			}
		}
		if(dateList.size() == 0)
			dateList = null;
		
		lectureDateDAO.delete(id, dateList);
		for(int i=0 ; i<dateMap.size() ; i++) {
			String date = dateMap.get(i).get("date").toString();
			if(dateMap.get(i).get("form_id").toString().equals("0")) {
				lectureDateDAO.create(id, date);
			}
		}
	}

}
