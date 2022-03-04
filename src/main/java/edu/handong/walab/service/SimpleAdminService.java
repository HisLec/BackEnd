package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.User;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.repository.AdminDAO;
import edu.handong.walab.repository.InstructorInfoDAO;
import edu.handong.walab.repository.UserDAO;

@Service
public class SimpleAdminService implements AdminService{
	
	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	InstructorInfoDAO instructorInfoDAO;
	
	@Override
	public String readAdminByKeyword(String keyword) throws JsonProcessingException {
		if(keyword != null) {
			keyword = "%".concat(keyword).concat("%");
		}
		List<Administrator> adminDATA = adminDAO.readAdminByKeyword(keyword);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(adminDATA);

		return jsonString;
	}
	
	@Override
	public String readAdminByUserId(int userID) throws JsonProcessingException {

		Administrator adminDATA = adminDAO.readAdminByUserID(userID);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(adminDATA);

		return jsonString;
	}

	@Override
	public void patchEmailYN(int id, int editValue) {
		adminDAO.patchEmailYN(id, editValue);
	}

	@Override
	public Administrator readAdminInfoByUserID(int user_id) {
		return adminDAO.readAdminByUserId(user_id);
	}
	
	@Override
	public void delete(int id, String email) {
		userDAO.updateDelDate(email);
		adminDAO.delete(id);
	}
	
	@Override
	public String add(Administrator admin) {
		User user = new User();
		if(userDAO.getUserByEmail(admin.getEmail().trim()) != null) {
			user = userDAO.getUserByEmail(admin.getEmail().trim());
			if(adminDAO.readAdminByEmail(admin.getEmail().trim()) != null) {
				return "이미 존재하는 관리자입니다.";
			}
			if(instructorInfoDAO.readByEmail(admin.getEmail().trim()) != null) {
				return "이미 강사로 등록되어 있습니다.";
			}
			userDAO.updateUserStatus(2, user.getId());
		} else {
			user = userDAO.insertUserForAdmin(new User(admin.getEmail().trim(), 2));
		}
		admin.setUser_id(user.getId());
		adminDAO.add(admin);
		return("관리자가 추가되었습니다.");
	}

	@Override
	public List<String> readEmailByemailYN() {
		
		return adminDAO.readEmailByemailYN();
		
	}
}
