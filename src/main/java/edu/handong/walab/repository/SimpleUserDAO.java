package edu.handong.walab.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.User;

@Repository
public class SimpleUserDAO implements UserDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "user";
	
	@Override
	public void insertUser(User user) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("email", user.getEmail());
	    param.put("status", user.getStatus());
	    
		sqlSession.insert(namespace+".insertUser", param);
	}
	
	@Override
	public User insertUserForAdmin(User user) {
	    
		sqlSession.insert(namespace+".insertUserForAdmin", user);
		
		return user;
	}
	
	@Override
	public User getUserByToken(String token) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("token", token);
	    
		return sqlSession.selectOne(namespace+".getUserDataByToken", param);
	}
	
	@Override
	public User getUserByEmail(String email) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("email", email);
	    
		return sqlSession.selectOne(namespace+".getUserDataByEmail", param);
	}
	
	@Override
	public User getUserByID(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    
		return sqlSession.selectOne(namespace+".getUserDataById", param);
	}

	@Override
	public void updateUserByToken(User user) {
		DateFormat df = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", user.getId());
	    param.put("token", user.getToken());
	    param.put("expire_token", df.format(user.getExpire_token()));
	    
	    sqlSession.update(namespace+".updateUserToken", param);
	}

	@Override
	public void deleteUserTokenByEmail(String email) {
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("email", email);
	    
		sqlSession.update(namespace+".deleteUserToken", param);
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getLastId");
	}

	@Override
	public List<User> readAllUser(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
	    
		return sqlSession.selectList(namespace+".readAllUser", param);
	}

	@Override
	public void updateUserStatus(int status, int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("status", status);
	    param.put("id", id);
	    
	    sqlSession.update(namespace+".updateUserStatus", param);
		
	}
	
	@Override
	public void deleteUser(String email) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("email", email);
	    
	    sqlSession.delete(namespace+".deleteUser", param);
		
	}

	@Override
	public void updateDelDate(String email) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
	    sqlSession.update(namespace+".updateDelDate", param);
	}
	
	@Override
	public void updateDelDateByUserId(int user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_id", user_id);
	    sqlSession.update(namespace+".updateDelDateByUserId", param);
	}

}
