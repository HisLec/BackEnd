package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Church;
import edu.handong.walab.repository.ApplicationDAO;
import edu.handong.walab.repository.ChurchDAO;

@Service
public class SimpleChurchService implements ChurchService {

	@Autowired
	ChurchDAO churchDAO;
	
	@Autowired
	ApplicationDAO applicationDAO;

	@Override
	public void createChurch(int administrator_id_create, int administrator_id_update, String name, int region_id,
			String city, String district, String zip_code, String addr1, String addr2, String phone, String email,
			String page_url) {
		churchDAO.createChurch(administrator_id_create, administrator_id_update, name, region_id, city, district, zip_code, addr1, addr2, phone, email, page_url);
	}

	@Override
	public int getLastId() {
		return churchDAO.getLastId();
	}

	@Override
	public Church readChurchById(int church_id) {
		Church church = churchDAO.readChurchById(church_id);
		
		return church;
	}

	@Override
	public void updateChurch(int administrator_id_update, int id, String name, String city, String district,
			String zip_code, String addr1, String addr2, String pastor, String email, String phone) {
		churchDAO.updateChurch(administrator_id_update, id, name, city, district, zip_code, addr1, addr2, pastor, email, phone);
	}

	@Override
	public String readChurch(String keyword) {
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<Church> churchList = churchDAO.readChurch(keyword);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(churchList);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createChurch(int user_id, String name, int region_id, String nation, String city, String district, String zip_code,
			String addr1, String addr2, String phone, String email, String page_url, String fax, String size,
			String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo, String writer_name,
			String memo) {
		// TODO Auto-generated method stub
		return churchDAO.createChurch(user_id, name, region_id, nation, city, district, zip_code, addr1, addr2, phone, email, page_url, fax, size, denomination, pastor, admin_name, hgu_yn, hgu_memo, writer_name, memo);
	}

	@Override
	public void updateChurch(int church_id, int user_id, String name, int region_id, String nation, String city, String district,
			String zip_code, String addr1, String addr2, String phone, String email, String page_url, String fax,
			String size, String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo,
			String writer_name, String memo) {
		churchDAO.updateChurch(church_id, user_id, name, region_id, nation, city, district, zip_code, addr1, addr2, phone, email, page_url, fax, size, denomination, pastor, admin_name, hgu_yn, hgu_memo, writer_name, memo);
	}

	@Override
	public void deleteChurch(int church_id) {
		churchDAO.deleteChurch(church_id);
		applicationDAO.cancelFinishByChurch(church_id);
		applicationDAO.cancelNotFinishByChurch(church_id);
	}

	@Override
	public void recoverChurch(int church_id) {
		churchDAO.recoverChurch(church_id);
	}
	
}
