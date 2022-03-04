package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.ChurchTemp;
import edu.handong.walab.model.dto.compareChurchWithTemp;

public interface ChurchTempDAO {

	void createChurchTemp(int application_form_id, int church_id, String church_name, String city, String district, String zip_code,
			String addr1, String addr2, String writer_name, String pastor, String phone, String email);

	void confirmChurchTemp(int id);

	ChurchTemp readChurchTempById(int id);
	
	public List<compareChurchWithTemp> readAllChurchTemp(String keyword);

	void deleteChurchTemp(String application_form_id);

	void rejectChurchTemp(int id);

}
