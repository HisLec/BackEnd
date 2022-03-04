package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.dto.Administrator;

@Repository
public class SimpleAdminDAO implements AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "administrator";

	@Override
	public List<Administrator> readAdminByKeyword(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);

		return sqlSession.selectList(namespace+".readAdminByKeyword", param);
	}
	
	@Override
	public Administrator readAdminByUserID(int userID) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", userID);

		return sqlSession.selectOne(namespace+".readAdminByUserID", param);
	}

	@Override
	public void patchEmailYN(int id, int editValue) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    param.put("email_yn", editValue);
	    
		sqlSession.update(namespace+".updateAdministrator", param);
	}

	@Override
	public Administrator readAdminByUserId(int user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", user_id);
	    
		return sqlSession.selectOne(namespace+".readAdminByUserId", param);
	}
	
	@Override
	public void delete(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    
		sqlSession.update(namespace+".deleteAdministrator", param);
	}
	
	@Override
	public void add(Administrator admin) {
		sqlSession.insert(namespace+".insertAdministrator", admin);
	}

	@Override
	public List<String> readEmailByemailYN() {
		return sqlSession.selectList(namespace+".readEmailByemailYN");
	}

	@Override
	public Administrator readAdminByEmail(String email) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("email", email);

		return sqlSession.selectOne(namespace+".readAdminByEmail", param);
	}
}
