package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Setting;

@Repository
public class SimpleSettingDAO implements SettingDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "setting";

	@Override
	public List<Setting> readSetting() {
		List<Setting> setting = sqlSession.selectList(namespace+".read");
		return setting;
	}
	
	@Override
	public void updateMainHomeSetting(String key, String value) {
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("key", key);
		if(value == null) {
			param.put("value", "");
		}else
			param.put("value", value);
		
		sqlSession.update(namespace+".updateSetting", param);
	}

}
