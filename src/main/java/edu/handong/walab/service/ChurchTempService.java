package edu.handong.walab.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.ChurchTemp;

public interface ChurchTempService {

	void createChurchTemp(int application_form_id, int church_id, String church_name, String city, String district, String zip_code,
			String addr1, String addr2, String writer_name, String pastor, String phone, String email);

	void confirmChurchTemp(int id);

	ChurchTemp readChurchTempById(int id);
	
	public String readAllChurchTempJsonData(String keyword) throws JsonProcessingException;

	void deleteChurchTemp(String string);

	void rejectChurchTemp(int id);


}
