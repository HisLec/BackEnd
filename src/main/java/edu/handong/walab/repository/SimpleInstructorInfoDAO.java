package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.Position;
import edu.handong.walab.model.dto.AdminInstructor;
import edu.handong.walab.model.dto.StatByInstPosition;

@Repository
public class SimpleInstructorInfoDAO implements InstructorInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "instructorInfo";

	@Override
	public InstructorInfo read(int user_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", user_id);

		return sqlSession.selectOne(namespace+".read", param);
	}

	@Override
	public void update(int id, int position_id, String name, String phone, String image, String intro,
			String memo) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("position_id", position_id);
	    param.put("name", name);
	    param.put("image", image);
	    param.put("phone", phone);
	    param.put("intro", intro);
	    param.put("memo", memo);
	    param.put("id", id);

	    sqlSession.update(namespace+".update", param);

	}

	@Override
	public void createInstructor(int user_id, String email, int position_id, String name, String phone, String image, String intro,
			String memo) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", user_id);
	    param.put("position_id", position_id);
	    param.put("name", name);
	    param.put("phone", phone);
	    param.put("image", image);
	    param.put("intro", intro);
	    param.put("memo", memo);

	    sqlSession.insert(namespace+".createInstructor", param);
	}

	@Override
	public List<AdminInstructor> readInstructors(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);

		return sqlSession.selectList(namespace+".readInstructors", param);
	}

	@Override
	public List<AdminInstructor> readAllInstructors() {

		return sqlSession.selectList(namespace+".readAllInstructors");
	}

	@Override
	public void delete(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);

		sqlSession.delete(namespace+".delete", param);
	}

	@Override
	public int readPositionID(String name) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);

		return sqlSession.selectOne(namespace+".readPositionID", param);
	}

	@Override
	public List<Position> readPosition() {
		return sqlSession.selectList(namespace+".readPosition");
	}

	@Override
	public void recover(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);

		sqlSession.update(namespace+".recover", param);
	}

	@Override
	public InstructorInfo readByInstructorId(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);

		return sqlSession.selectOne(namespace+".readByInstructorId", param);
	}

	@Override
	public InstructorInfo readInstructorByUserID(int userId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("user_id", userId);
	    return sqlSession.selectOne(namespace+".readByUserId", param);

	}

	@Override
	public List<StatByInstPosition> readStatByPosition(int period) {
		Map<String, Object> param = new HashMap<String, Object>();
		if(period == 0)
			param.put("period", null);
		else
			param.put("period", -period);
		
		return sqlSession.selectList(namespace+".StatByInstPosition", param);
	}

	@Override
	public InstructorInfo readByEmail(String email) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
		return sqlSession.selectOne(namespace+".readByEmail", param);
	}

	@Override
	public InstructorInfo readInstructorById(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		return sqlSession.selectOne(namespace+".readInstructorById", param);
	}

}
