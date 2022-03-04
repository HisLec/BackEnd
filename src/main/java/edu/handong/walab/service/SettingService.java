package edu.handong.walab.service;

import edu.handong.walab.model.dto.Phrase;

public interface SettingService {

	public String readSetting();
	
	public String readSettingByAdmin();
	
	public void updateMainHome(String[] value, String delay);
	
	public void updateExplainSite(String value, String content);
	
	public void updateMainInstructorPage(String[] value, String[] instructorId);
	
	public void updateMainLecturePage(String[] value, String[] lectureId);
	
	public void updatePhrasePage1(Phrase phrase);
	
	public void updatePhrasePage2(Phrase phrase);
}
