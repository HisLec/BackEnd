package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Church;
import edu.handong.walab.model.domain.ChurchTemp;
import edu.handong.walab.model.dto.compareChurchWithTemp;

@Repository
public class SimpleChurchTempDAO implements ChurchTempDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "churchTemp";
	@Override
	public void createChurchTemp(int application_form_id, int church_id, String church_name, String city, String district, String zip_code,
			String addr1, String addr2, String writer_name, String pastor, String phone, String email) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("application_form_id", application_form_id);
		param.put("church_id", church_id);
		param.put("name", church_name);
	    param.put("city", city);
	    param.put("district", district);
	    param.put("zip_code", zip_code);
	    param.put("addr1", addr1);
	    param.put("addr2", addr2);
	    param.put("writer_name", writer_name);
	    param.put("pastor", pastor);
	    param.put("phone", phone);
	    param.put("email", email);
	    
		sqlSession.insert(namespace+".createChurchTemp", param);
	}
	@Override
	public void confirmChurchTemp(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		
		sqlSession.update(namespace+".confirmChurchTemp", param);
	}
	@Override
	public ChurchTemp readChurchTempById(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		return sqlSession.selectOne(namespace+".readChurchTempById", param);
	}
	
	@Override
	public List<compareChurchWithTemp> readAllChurchTemp(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("keyword", keyword);
		return sqlSession.selectList(namespace+".readAllChurchTempData", param);
	}
	@Override
	public void deleteChurchTemp(String application_form_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("application_form_id", application_form_id);
		sqlSession.delete(namespace+".delete", param);
	}
	@Override
	public void rejectChurchTemp(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		
		sqlSession.update(namespace+".rejectChurchTemp", param);	
	}
	
}
