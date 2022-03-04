package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.AcademyDate;

@Repository
public class SimpleAcademyDateDAO implements AcademyDateDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "academyDate";
	
	@Override
	public void create(String name, String date, String category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    param.put("date", date);
	    param.put("category_id", category_id);
	    
	    sqlSession.insert(namespace+".create", param);
	}

	@Override
	public List<AcademyDate> read(int [] categoryId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("category_id", categoryId);

		return sqlSession.selectList(namespace+".read", param);
	}

	@Override
	public void update(int id, String name, String date, String category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    param.put("date", date);
	    param.put("id", id);
	    param.put("category_id", category_id);
	    
		sqlSession.update(namespace+".update", param);
	}

	@Override
	public void delete(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".delete", param);
	}

	@Override
	public List<AcademyDate> readpreviousYear() {
		return sqlSession.selectList(namespace+".readPreviousYear");
	}

	@Override
	public void deleteByCategory(String category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("category_id", category_id);
	    sqlSession.delete(namespace+".deleteByCategory", param);
	}

}
