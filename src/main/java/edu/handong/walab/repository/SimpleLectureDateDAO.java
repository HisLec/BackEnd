package edu.handong.walab.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.LectureDate;

@Repository
public class SimpleLectureDateDAO implements LectureDateDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "lectureDate";
	
	@Override
	public List<LectureDate> readByLectureId(int lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    
		return sqlSession.selectList(namespace+".readByLectureId", param);
	}
	
	@Override
	public int readByDate(int lecture_id, String date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    param.put("date", date);
	    
		return sqlSession.selectOne(namespace+".readByDate", param);
	}

	@Override
	public void insertDate(int lecture_id, String selectDate) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("selectDate", selectDate);
	    param.put("lecture_id", lecture_id);
	    
	    sqlSession.insert(namespace+".insertDate", param);
	}

	@Override
	public int readLastId() {
		return sqlSession.selectOne(namespace+".readLastId");
	}

	@Override
	public void create(String lecture_id, String date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("selectDate", date);
	    param.put("lecture_id", lecture_id);
	    
	    sqlSession.insert(namespace+".insertDate", param);
	}

	@Override
	public void update(String id, String lecture_id, String date) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("lecture_id", lecture_id);
	    param.put("date", date);
	    
	    sqlSession.update(namespace+".update", param);
	}

	@Override
	public void delete(String id, ArrayList<Integer> dateList) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("dateList", dateList);
	    
	    sqlSession.delete(namespace+".delete", param);
	}

	@Override
	public void deleteByChange(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("lecture_id", id);
		sqlSession.delete(namespace+".deleteByChange", param);
	}

}
