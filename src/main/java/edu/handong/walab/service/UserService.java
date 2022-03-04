package edu.handong.walab.service;

import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.User;

public interface UserService {
	public String setUserTokenJsonData(String email, String token, Date expire_token) throws JsonProcessingException;
	
	public Boolean getUserData(String token);
	
	public String deleteUserToken(String email) throws JsonProcessingException;

	public String readAllUser(String keyword);

	public void updateUserStatus(int status, int id);
	
	public User getUserByEmail(String email);
}
