package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Setting;

public interface SettingDAO {

	List<Setting> readSetting();
	
	void updateMainHomeSetting(String key, String value);

}
