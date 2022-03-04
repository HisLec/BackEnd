package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Church;
import edu.handong.walab.model.domain.ChurchTemp;
import edu.handong.walab.model.dto.LectureForUser;
import edu.handong.walab.model.dto.compareChurchWithTemp;
import edu.handong.walab.repository.ChurchTempDAO;

@Service
public class SimpleChurchTempService implements ChurchTempService{
	@Autowired
	ChurchTempDAO churchTempDAO;

	
	@Override
	public void createChurchTemp(int application_form_id, int church_id, String church_name, String city,
			String district, String zip_code, String addr1, String addr2, String writer_name, String pastor, String phone, String email) {
		churchTempDAO.createChurchTemp(application_form_id, church_id, church_name, city, district, zip_code, addr1, addr2, writer_name, pastor, phone, email);	
	}
	

	@Override
	public void confirmChurchTemp(int id) {
		churchTempDAO.confirmChurchTemp(id);
	}
	
	@Override
	public void rejectChurchTemp(int id) {
		churchTempDAO.rejectChurchTemp(id);
	}

	@Override
	public ChurchTemp readChurchTempById(int id) {
		return churchTempDAO.readChurchTempById(id);
	}

	@Override
	public String readAllChurchTempJsonData(String keyword) throws JsonProcessingException {
		
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<compareChurchWithTemp> churchTempDATA = churchTempDAO.readAllChurchTemp(keyword);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(churchTempDATA);
		
		return jsonString;
	}


	@Override
	public void deleteChurchTemp(String application_form_id) {
		churchTempDAO.deleteChurchTemp(application_form_id);
	}



}
