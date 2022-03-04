package edu.handong.walab.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Region;
import edu.handong.walab.model.dto.LectureTopicInfo;
import edu.handong.walab.repository.LectureRegionDAO;

@Service
public class SimpleLectureRegionService implements LectureRegionService{
	
	@Autowired
	LectureRegionDAO lectureRegionDAO;
	
	@Autowired
	public String getLectureRegionJsonData() throws JsonProcessingException {
		List<Region> lectureRegion =  lectureRegionDAO.getLectureRegion();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureRegion);
		return jsonString;
	}

	@Override
	public String getLectureRegionByLectureId(int lectureId) throws JsonProcessingException {
		List<LectureTopicInfo> lectureRegion =  lectureRegionDAO.getLectureRegionByLectureId(lectureId);
		
		if(lectureRegion.get(0).getStatus() == 1) {
			for(LectureTopicInfo lti : lectureRegion) {
				lti.setStatus(1);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureRegion);
		return jsonString;
	
	}

	@Override
	public void updateLectureRegion(String id, List<Map<String, Object>> regionMap) {
		lectureRegionDAO.deleteByLectureId(id);
		for(int i=0 ; i<regionMap.size() ; i++) {
			int region_id = Integer.parseInt(regionMap.get(i).get("id").toString());
			if(regionMap.get(i).get("status").toString().equals("1")) {
				lectureRegionDAO.createLectureRegion(id, region_id);
			}
		}
	}
}

