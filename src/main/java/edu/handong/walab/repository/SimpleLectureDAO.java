package edu.handong.walab.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.handong.walab.model.domain.Lecture;
import edu.handong.walab.model.dto.LectureForInstructor;
import edu.handong.walab.model.dto.LectureForMainCaledar;
import edu.handong.walab.model.dto.LectureForUser;
import edu.handong.walab.model.dto.StatByLecture;

@Repository
public class SimpleLectureDAO implements LectureDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "lecture";
	
	@Override
	public List<LectureForUser> getLectureBySubject(int[] subject) {
		if(subject[0] == -1) return sqlSession.selectList(namespace+".readLectureForUser");
		else {
			Map<String, Object> param = new HashMap<String, Object>();
		    param.put("topic_id", subject);

			return sqlSession.selectList(namespace+".readLectureForUserBySubject", param);

		}
	}
	
	
	@Override
	public List<LectureForUser> getLectureTopicBySubject() {
		return sqlSession.selectList(namespace+".readLectureTopicForUserBySubject");
	}
	
	@Override
	public List<LectureForUser> getAllLecture() {
		
	    
		return sqlSession.selectList(namespace+".readAllLecture");
	}
	
	@Override
	public List<LectureForUser> getLecture(String keyword) {
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
	    
		return sqlSession.selectList(namespace+".readLecture", param);
	}
	
	@Override
	public List<LectureForUser> getAdminLecture(String keyword) {
		
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("keyword", keyword);
	    
		return sqlSession.selectList(namespace+".readAdminLecture", param);
	}

	@Override
	public List<LectureForUser> getLectureByInstructor(int instructorId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructorId);

		return sqlSession.selectList(namespace+".readLectureByInstructor", param);
	}

	@Override
	public List<LectureForUser> getLectureByDate(String date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("select_date", date);

		return sqlSession.selectList(namespace+".readLectureForUserByDate", param);
	}

	@Override
	public List<LectureForUser> getLectureDetail(int lectureId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);

		return sqlSession.selectList(namespace+".readLectureDateDetail", param);
	}
	
	@Override
	public List<LectureForMainCaledar> getMainCalendarLecture(int instructor_id, String date) {
		Map<String, Object> param = new HashMap<String, Object>();
		if(instructor_id == 0)
			param.put("instructor_id", null);
		else
			param.put("instructor_id", instructor_id);
	    param.put("date", date);
		return sqlSession.selectList(namespace+".readLectureForMainCalendar", param);
	}

	@Override
	public List<LectureForMainCaledar> readLectureCalendar(String lecture_id, String date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);
	    param.put("date", date);
	    
		return sqlSession.selectList(namespace+".readLectureCalendar", param);
	}

	@Override
	public int insertLecture(Lecture lectureData) {
	    sqlSession.insert(namespace+".insertLecture", lectureData);

	    return lectureData.getId();
	}

	@Override
	public void insertLectureDate(int lectureId, String[] date) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    param.put("date", date);
	    

		sqlSession.insert(namespace+".insertLectureDate", param);
	}

	@Override
	public void recoverLecture(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    sqlSession.insert(namespace+".recoverLecture", param);
	}

	@Override
	public void deleteLecture(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", id);
	    sqlSession.insert(namespace+".deleteLecture", param);
	}

	@Override
	public Lecture getLectureDetailByLectureId(int lectureId) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lectureId);
	    return sqlSession.selectOne(namespace+".getLectureDetailByLectureId", param);
	}

	@Override
	public void update(String id, String name, String intro, String sample_url, String start_date, String end_date,
			String day_week, String morning, String afternoon, String evening) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("id", id);
	    param.put("name", name);
	    param.put("intro", intro);
	    param.put("sample_url", sample_url);
	    param.put("start_date", start_date);
	    param.put("end_date", end_date);
	    param.put("day_week", day_week);
	    param.put("morning", morning);
	    param.put("afternoon", afternoon);
	    param.put("evening", evening);
	    
	    sqlSession.update(namespace+".update", param);
	    
	    
	}

	@Override
	public StatByLecture getStatsByLecture(int period) {
		Map<String, Object> param = new HashMap<String, Object>();
		if(period == 0)
			param.put("period", null);
		else
			param.put("period", -period);
				
	    return sqlSession.selectOne(namespace+".getStatsByLecture", param);
	}

	@Override
	public void deleteLectureByLectureId(int instructor_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("instructor_id", instructor_id);
	    
	    sqlSession.update(namespace+".deleteLectureByLectureId", param);
		
	}

	@Override
	public Lecture getLectureByLectureId(int lecture_id) {
		Map<String, Object> param = new HashMap<String, Object>();
	    param.put("lecture_id", lecture_id);

		return sqlSession.selectOne(namespace+".getLectureByLectureId", param);
	}
}
