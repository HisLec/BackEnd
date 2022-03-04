package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.dto.Administrator;

public interface AdminDAO {
	List<Administrator> readAdminByKeyword (String Keyword);
	
	public Administrator readAdminByUserID(int userID);

	void patchEmailYN(int id, int editValue);

	Administrator readAdminByUserId(int user_id);
	
	public void delete(int id);
	
	public void add(Administrator admin);
	
	public List<String> readEmailByemailYN();

	Administrator readAdminByEmail(String email);
}
