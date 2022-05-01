package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.Position;
import edu.handong.walab.model.dto.AdminInstructor;
import edu.handong.walab.model.dto.StatByInstPosition;

public interface InstructorInfoDAO {

	InstructorInfo read(int user_id);

	void update(int user_id, int position_id, String name, String phone, String image, String intro, String memo);

	void createInstructor(int user_id, String email, int position_id, String name, String phone, String image, String intro,
			String memo);

	List<AdminInstructor> readInstructors(String keyword);
	
	List<AdminInstructor> readAllInstructors();

	void delete(int instructor_id);

	int readPositionID(String name);

	List<Position> readPosition();

	void recover(int instructor_id);

	InstructorInfo readByInstructorId(int instructor_id);

	InstructorInfo readInstructorByUserID(int userId);

	List<StatByInstPosition> readStatByPosition(int period);

	InstructorInfo readByEmail(String email);

	InstructorInfo readInstructorById(int id);
	

}
