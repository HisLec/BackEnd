package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Category;

@Repository
public class SimpleCategoryDAO implements CategoryDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "category";
	
	

	@Override
	public void createCategory(String name) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    sqlSession.insert(namespace+".create", param);
	}
	
	@Override
	public List<Category> readAdminCategory() {
		return sqlSession.selectList(namespace+".read");
	}
	

	@Override
	public int readIdByName(String name) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    
	    return sqlSession.selectOne(namespace+".readIdByName", param);
	}

	@Override
	public void disableCategory(int disable, int category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("disable", disable);
	    param.put("id", category_id);
	    
		sqlSession.update(namespace+".updateDisable", param);
	}

	@Override
	public void updateCategory(String name, int id, int status, int disable, int priority) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("name", name);
	    param.put("id", id);
	    param.put("status", status);
	    param.put("disable", disable);
	    param.put("priority", priority);
	    
	    sqlSession.update(namespace+".update", param);
	}

	@Override
	public void statusCategory(int status, int category_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", category_id);
	    param.put("status", status);
	    
	    sqlSession.update(namespace+".updateStatus", param);
	}

	@Override
	public void deleteCategory(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    sqlSession.delete(namespace+".delete", param);
	}
	
	
}
