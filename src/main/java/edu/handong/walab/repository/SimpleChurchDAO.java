package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Church;

@Repository
public class SimpleChurchDAO implements ChurchDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "church";
	
	@Override
	public void createChurch(int administrator_id_create, int administrator_id_update, String name, int region_id,
			String city, String district, String zip_code, String addr1, String addr2, String phone, String email,
			String page_url) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("administrator_id_create", administrator_id_create);
		param.put("administrator_id_update", administrator_id_update);
	    param.put("name", name);
	    param.put("region_id", region_id);
	    param.put("city", city);
		param.put("district", district);
	    param.put("zip_code", zip_code);
	    param.put("addr1", addr1);
	    param.put("addr2", addr2);
	    param.put("phone", phone);
	    param.put("email", email);
	    param.put("page_url", page_url);
	    
		sqlSession.insert(namespace+".createChurch", param);
		
	}
	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getLastId");
	}
	@Override
	public Church readChurchById(int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", church_id);
		
		return sqlSession.selectOne(namespace+".readChurchById", param);
	}
	@Override
	public void updateChurch(int administrator_id_update, int id, String name, String city, String district,
			String zip_code, String addr1, String addr2, String pastor, String email, String phone) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("administrator_id_update", administrator_id_update);
	    param.put("id", id);
	    param.put("city", city);
		param.put("district", district);
	    param.put("zip_code", zip_code);
	    param.put("addr1", addr1);
	    param.put("addr2", addr2);
	    param.put("name", name);
	    param.put("pastor", pastor);
	    param.put("email", email);
	    param.put("phone", phone);
	    
		sqlSession.update(namespace+".updateChurchAddr", param);
	}
	@Override
	public List<Church> readChurch(String keyword) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("keyword", keyword);
		
		return sqlSession.selectList(namespace+".readChurch", param);
	}
	
	@Override
	public int createChurch(int user_id, String name, int region_id, String nation, String city, String district, String zip_code,
			String addr1, String addr2, String phone, String email, String page_url, String fax, String size,
			String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo, String writer_name,
			String memo) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("administrator_id_create", user_id);
		param.put("administrator_id_update", user_id);
	    param.put("name", name);
	    param.put("region_id", region_id);
	    param.put("nation", nation);
	    param.put("city", city);
		param.put("district", district);
	    param.put("zip_code", zip_code);
	    param.put("addr1", addr1);
	    param.put("addr2", addr2);
	    param.put("phone", phone);
	    param.put("email", email);
	    param.put("page_url", page_url);
	    param.put("fax", fax);
	    param.put("size", size);
		param.put("denomination", denomination);
	    param.put("pastor", pastor);
	    param.put("admin_name", admin_name);
	    param.put("hgu_yn", hgu_yn);
	    param.put("hgu_memo", hgu_memo);
	    param.put("writer_name", writer_name);
	    param.put("memo", memo);
	    
		return sqlSession.insert(namespace+".createChurch", param);
		
	}
	
	@Override
	public void updateChurch(int church_id, int user_id, String name, int region_id, String nation, String city, String district,
			String zip_code, String addr1, String addr2, String phone, String email, String page_url, String fax,
			String size, String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo,
			String writer_name, String memo) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("church_id", church_id);
		param.put("administrator_id_update", user_id);
	    param.put("name", name);
	    param.put("region_id", region_id);
	    param.put("nation", nation);
	    param.put("city", city);
		param.put("district", district);
	    param.put("zip_code", zip_code);
	    param.put("addr1", addr1);
	    param.put("addr2", addr2);
	    param.put("phone", phone);
	    param.put("email", email);
	    param.put("page_url", page_url);
	    param.put("fax", fax);
	    param.put("size", size);
		param.put("denomination", denomination);
	    param.put("pastor", pastor);
	    param.put("admin_name", admin_name);
	    param.put("hgu_yn", hgu_yn);
	    param.put("hgu_memo", hgu_memo);
	    param.put("writer_name", writer_name);
	    param.put("memo", memo);
	    
		sqlSession.update(namespace+".updateChurch", param);

	}
	
	@Override
	public void deleteChurch(int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("church_id", church_id);
		
		sqlSession.update(namespace+".deleteChurch", param);
	}
	@Override
	public void recoverChurch(int church_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("church_id", church_id);
		
		sqlSession.update(namespace+".recoverChurch", param);
	}
}
