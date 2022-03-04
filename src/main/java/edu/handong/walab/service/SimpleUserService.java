package edu.handong.walab.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.User;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.repository.AdminDAO;
import edu.handong.walab.repository.InstructorInfoDAO;
import edu.handong.walab.repository.UserDAO;

@Service
public class SimpleUserService implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	InstructorInfoDAO instDAO;
	

	@Override
	public String setUserTokenJsonData(String email, String token, Date expire_token) throws JsonProcessingException {
		User user = userDAO.getUserByEmail(email);
		//Map<String, Object> mapperParam = new HashMap<String, Object>();
		
		if(user == null) {
			user = new User(0,email, 0, token, expire_token);
			userDAO.insertUser(user);
			user.setId(userDAO.getUserByEmail(email).getId());
		}
	    
		user.setExpire_token(expire_token);
	    user.setToken(token);
	    
	    userDAO.updateUserByToken(user);
	    user = userDAO.getUserByEmail(email);
	    
	    //mapperParam.put("status", "success");
	    if(user.getStatus() == 2) {
	    	Administrator admin = adminDAO.readAdminByUserId(user.getId());
	    	if(admin.getDel_date() != null) {
	    		return "fail";
	    	}
	    	
	    }else if(user.getStatus() == 1) {
	    	InstructorInfo inst = instDAO.read(user.getId());
	    	
	    	if(inst.getDel_date() != null) {
	    		return "fail";
	    	}
	    }else if(user.getStatus() == -1) {
	    	return "fail";
	    }
	    
	    ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(user);
		
		
		return jsonString;
	}

	@Override
	public Boolean getUserData(String token) {
		User user = userDAO.getUserByToken(token);
		if(user != null) {
			return true;
		}
		return false;
	}
	
	public String deleteUserToken(String email) throws JsonProcessingException {
		userDAO.deleteUserTokenByEmail(email);
		
		Map<String, Object> mapperParam = new HashMap<String, Object>();
		
		mapperParam.put("status", "success");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(mapperParam);
		
		
		return jsonString;
	}

	@Override
	public String readAllUser(String keyword) {
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<User> userList = userDAO.readAllUser(keyword);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(userList);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateUserStatus(int status, int id) {
		userDAO.updateUserStatus(status, id);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}
}
