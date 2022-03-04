package edu.handong.walab.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.dto.Administrator;

public interface AdminService {
	public String readAdminByKeyword(String keyword) throws JsonProcessingException;
	
	public String readAdminByUserId(int userID) throws JsonProcessingException;

	public void patchEmailYN(int id, int editValue);

	public Administrator readAdminInfoByUserID(int user_id);
	
	public void delete(int id, String email);
	
	public String add(Administrator admin);
	
	public List<String> readEmailByemailYN();
}
