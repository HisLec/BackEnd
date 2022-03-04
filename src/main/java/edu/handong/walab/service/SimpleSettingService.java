package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Setting;
import edu.handong.walab.model.dto.Phrase;
import edu.handong.walab.repository.SettingDAO;

@Service
public class SimpleSettingService implements SettingService {
	
	@Autowired
	SettingDAO settingDAO;

	@Override
	public String readSetting() {
		List<Setting> settings =  settingDAO.readSetting();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(settings);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public String readSettingByAdmin() {
		List<Setting> settings =  settingDAO.readSetting();
		
		for(Setting s: settings) {
			s.setValue(s.getValue().replaceAll("<br/>", "\n"));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(settings);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public void updateMainHome(String[] value, String delay) {
		String[] keys = {"section1_img1", "section1_img2", "section1_img3", "section1_img4", "section1_delay","section1_title"};
		String[] values = new String[6];
		for(int i=0; i<4; i++) {
			settingDAO.updateMainHomeSetting(keys[i], value[i]);
		}
		
		values[4] = delay;
		settingDAO.updateMainHomeSetting(keys[4], delay);
		settingDAO.updateMainHomeSetting(keys[5], value[4]);

	}
	
	@Override
	public void updateExplainSite(String value, String content) {
		content = content.replaceAll("\n", "<br/>");
		settingDAO.updateMainHomeSetting("section2_img", value);
		settingDAO.updateMainHomeSetting("section2_text", content);

	}
	
	@Override
	public void updateMainInstructorPage(String[] value, String[] instructorId) {
		
		for(int i=0; i<4; i++) {
			settingDAO.updateMainHomeSetting("section3_img"+(i+1), value[i]);
			settingDAO.updateMainHomeSetting("section3_id"+(i+1), instructorId[i]);
		}
	}
	
	@Override
	public void updateMainLecturePage(String[] value, String[] lectureId) {
		for(int i=0; i<8; i++) {
			if(value.length > i) {
				settingDAO.updateMainHomeSetting("section5_img"+(i+1), value[i]);
			}else {
				settingDAO.updateMainHomeSetting("section5_img"+(i+1), null);
			}
			
			if(lectureId.length > i) {
				settingDAO.updateMainHomeSetting("section5_id"+(i+1), lectureId[i]);
			}else {
				settingDAO.updateMainHomeSetting("section5_id"+(i+1), "-1");
			}
		}
	}
	
	@Override
	public void updatePhrasePage1(Phrase phrase) {
		
		settingDAO.updateMainHomeSetting("lecture_page_phrase", phrase.getLecture_page_phrase());
		
		settingDAO.updateMainHomeSetting("application_page_phrase", phrase.getApplication_page_phrase());
		settingDAO.updateMainHomeSetting("application_below_date_phrase", phrase.getApplication_below_date_phrase());
		settingDAO.updateMainHomeSetting("application_list_phrase", phrase.getApplication_list_phrase());
		
		settingDAO.updateMainHomeSetting("mypage_profile_phrase", phrase.getMypage_profile_phrase());
		settingDAO.updateMainHomeSetting("mypage_lecture_phrase", phrase.getMypage_lecture_phrase());
		settingDAO.updateMainHomeSetting("mypage_contact_phrase", phrase.getMypage_contact_phrase());
		settingDAO.updateMainHomeSetting("mypage_visit_phrase", phrase.getMypage_visit_phrase());
	}
	
	@Override
	public void updatePhrasePage2(Phrase phrase) {
		
		settingDAO.updateMainHomeSetting("agree_personal_information_1", phrase.getAgree_personal_information_1());
		settingDAO.updateMainHomeSetting("agree_personal_information_2", phrase.getAgree_personal_information_2());
		settingDAO.updateMainHomeSetting("agree_personal_information_3", phrase.getAgree_personal_information_3());
	}
}
