package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Notice;

@Repository
public class SimpleNoticeDAO implements NoticeDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "notice";
	
	@Override
	public List<Notice> readNotice(String keyword) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
		
		return sqlSession.selectList(namespace+".readNotice", param);
	}
	
	@Override
	public void createNotice(int administrator_id, String title, String content, int important) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("administrator_id", administrator_id);
	    param.put("title", title);
	    param.put("content", content);
	    param.put("important", important);
	    
	    sqlSession.insert(namespace+".createNotice", param);
	}
	
	@Override
	public void updateNotice(int id, int administrator_id, String title, String content, int important, int manageID) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("administrator_id", administrator_id);
	    param.put("title", title);
	    param.put("content", content);
	    param.put("important", important);
	    param.put("manageID", manageID);
	    
	    sqlSession.update(namespace+".updateNotice", param);
	}
	
	@Override
	public void deleteNotice(int id, int manageID) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("manageID", manageID);
		
		sqlSession.delete(namespace+".deleteNotice", param);
	}
	
	
}
