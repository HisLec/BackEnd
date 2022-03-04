package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.Position;
import edu.handong.walab.model.domain.User;
import edu.handong.walab.model.dto.AdminInstructor;
import edu.handong.walab.model.dto.StatByInstPosition;
import edu.handong.walab.repository.AdminDAO;
import edu.handong.walab.repository.InstructorInfoDAO;
import edu.handong.walab.repository.UserDAO;

@Service
public class SimpleInstructorInfoService implements InstructorInfoService {
	
	@Autowired
	InstructorInfoDAO instructorInfoDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public String read(int user_id) {
		InstructorInfo info = instructorInfoDAO.read(user_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(info);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public InstructorInfo readInstructorInfoByUserId(int user_id) {
		return instructorInfoDAO.read(user_id);
	}

	@Override
	public String update(int user_id, int position_id, String name, String phone, String image, String intro,
			String memo) {
		
		instructorInfoDAO.update(user_id, position_id, name, phone, image, intro, memo);
		
		return "success";
	}

	@Override
	public String createInstructor(String email, int position_id, String name, String phone, String image, String intro,
			String memo) {
		User user = new User();
		int user_id;
		
		if(userDAO.getUserByEmail(email.trim()) != null) {
			user = userDAO.getUserByEmail(email.trim());
			if(instructorInfoDAO.readByEmail(email.trim()) != null) {
				return "이미 등록된 강사입니다.";
			}
			if(adminDAO.readAdminByEmail(email.trim()) != null) {
				return "이미 관리자로 등록되어 있습니다.";
			}
			userDAO.updateUserStatus(1, user.getId());
			user_id = user.getId();
		} else {
			user.setEmail(email.trim());
			user.setStatus(1);
			userDAO.insertUser(user);
			user_id = userDAO.getLastId();
		}		
		instructorInfoDAO.createInstructor(user_id, email, position_id, name, phone, image, intro, memo);
		return "강사가 추가되었습니다.";
	}

	@Override
	public String readInstructors(String keyword) {
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<AdminInstructor> insts = instructorInfoDAO.readInstructors(keyword);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		
		try {
			jsonString = mapper.writeValueAsString(insts);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String readAllInstructors() {
		
		List<AdminInstructor> insts = instructorInfoDAO.readAllInstructors();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		
		try {
			jsonString = mapper.writeValueAsString(insts);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(int instructor_id) {
		InstructorInfo inst = instructorInfoDAO.readByInstructorId(instructor_id);
		userDAO.updateDelDateByUserId(inst.getUser_id());
		instructorInfoDAO.delete(instructor_id);
	}

	@Override
	public int readPositionID(String name) {
		return instructorInfoDAO.readPositionID(name);
	}

	@Override
	public String readPosition() {
		List<Position> info = instructorInfoDAO.readPosition();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(info);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String recover(int instructor_id, String email) {
		if(instructorInfoDAO.readByEmail(email.trim()) != null) {
			return "이미 존재하는 강사입니다. 복구할 수 없습니다.";
		}
		instructorInfoDAO.recover(instructor_id);
		return "강사 정보 복구가 완료되었습니다.";
	}

	@Override
	public String readByInstructorId(int instructor_id) {
		InstructorInfo inst = instructorInfoDAO.readByInstructorId(instructor_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		
		try {
			jsonString = mapper.writeValueAsString(inst);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InstructorInfo readInstructorByUserID(int userId) {
		return instructorInfoDAO.readInstructorByUserID(userId);
	}

	@Override
	public String readStatByPosition(int period) {
		List<StatByInstPosition> data = instructorInfoDAO.readStatByPosition(period);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(data);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public InstructorInfo readInstructorById(int id) {
		return instructorInfoDAO.readInstructorById(id);
	}

}
