package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Lecture;
import edu.handong.walab.model.dto.LectureForInstructor;
import edu.handong.walab.model.dto.LectureForMainCaledar;
import edu.handong.walab.model.dto.LectureForUser;
import edu.handong.walab.model.dto.StatByLecture;

public interface LectureDAO {
	
	public List<LectureForUser> getLectureBySubject(int[] subject);

	public List<LectureForUser> getLectureTopicBySubject();

	public List<LectureForUser> getLectureByInstructor(int instructorId);

	public List<LectureForUser> getLectureByDate(String date);

	public List<LectureForUser> getLectureDetail(int lectureId);

	public int insertLecture(Lecture lectureData);

	public void insertLectureDate(int lectureDateGroupId, String[] dates);
	
	public List<LectureForUser> getAllLecture();
	
	public List<LectureForUser> getLecture(String keyword);

	public List<LectureForMainCaledar> getMainCalendarLecture(int instructor_id, String date);

	public List<LectureForMainCaledar> readLectureCalendar(String lecture_id, String date);

	public void recoverLecture(int id);

	public void deleteLecture(int id);

	public Lecture getLectureDetailByLectureId(int lectureId);

	public void update(String id, String name, String intro, String sample_url, String start_date, String end_date,
			String day_week, String morning, String afternoon, String evening);

	public StatByLecture getStatsByLecture(int period);

	public List<LectureForUser> getAdminLecture(String keyword);

	public void deleteLectureByLectureId(int instructor_id);

	public Lecture getLectureByLectureId(int lecture_id);

}
