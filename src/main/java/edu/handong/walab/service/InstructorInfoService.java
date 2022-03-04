package edu.handong.walab.service;

import edu.handong.walab.model.domain.InstructorInfo;

public interface InstructorInfoService {

	String read(int user_id);

	String update(int user_id, int position_id, String name, String phone, String image, String intro, String memo);

	String createInstructor(String email, int position_id, String name, String phone, String image, String intro,
			String memo);

	String readInstructors(String keyword);
	
	String readAllInstructors();

	void delete(int instructor_id);

	int readPositionID(String string);

	String readPosition();

	String recover(int instructor_id, String email);

	String readByInstructorId(int instructor_id);
	
	public InstructorInfo readInstructorInfoByUserId(int user_id);

	InstructorInfo readInstructorByUserID(int userId);

	String readStatByPosition(int period);

	InstructorInfo readInstructorById(int id);

}
