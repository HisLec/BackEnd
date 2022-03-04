package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Region;
import edu.handong.walab.model.dto.LectureTopicInfo;

@Repository
public class SimpleLectureRegionDAO implements LectureRegionDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "lectureRegion";
	
	@Override
	public List<Region> getLectureRegion() {
		
		return sqlSession.selectList(namespace+".readLectureRegion");
	}
	
	@Override
	public void insertLectureRegion(int lectureId, int[] regionId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    param.put("region_id", regionId);
	    
		sqlSession.insert(namespace+".insertLectureRegion",param);
		
	}

	@Override
	public List<LectureTopicInfo> getLectureRegionByLectureId(int lectureId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    
	    return sqlSession.selectList(namespace+".readRegionByLectureId", param);
	}

	@Override
	public void deleteByLectureId(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    sqlSession.delete(namespace+".delete", param);
	}

	@Override
	public void createLectureRegion(String id, int region_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    param.put("region_id", region_id);
	    sqlSession.delete(namespace+".create", param);
	}
}
