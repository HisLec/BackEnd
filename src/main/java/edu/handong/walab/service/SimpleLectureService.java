package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.Lecture;
import edu.handong.walab.model.domain.Region;
import edu.handong.walab.model.domain.Topic;
import edu.handong.walab.model.dto.LectureForInstructor;
import edu.handong.walab.model.dto.LectureForMainCaledar;
import edu.handong.walab.model.dto.LectureForUser;
import edu.handong.walab.model.dto.StatByLecture;
import edu.handong.walab.repository.InstructorInfoDAO;
import edu.handong.walab.repository.LectureDAO;
import edu.handong.walab.repository.LectureDateDAO;
import edu.handong.walab.repository.LectureRegionDAO;
import edu.handong.walab.repository.LectureTopicDAO;

@Service
public class SimpleLectureService implements LectureService{

	@Autowired
	LectureDAO lectureDAO;
	@Autowired
	LectureTopicDAO lectureTopicDAO;
	@Autowired
	LectureRegionDAO lectureRegionDAO;
	@Autowired
	InstructorInfoDAO instructorInfoDAO;
	@Autowired
	LectureDateDAO lectureDateDAO;
	
	@Override
	public String getLectureJsonData(String keyword) throws JsonProcessingException {
		
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<LectureForUser> lectureDATA = lectureDAO.getLecture(keyword);
		
		for(LectureForUser data: lectureDATA) {
			if(data.getDate() != null && data.getDate() != "" && data.getDate().length() != 0) {
				String value = data.getDate().replace(')', ' ');
				boolean status = false;
				if(data.getMorning() == 1) {
					status =true;
					value += "| 오전";
				}
				
				if(data.getAfternoon() == 1 && !status) {
					status =true;
					value += "| 오후";
				}else if(data.getAfternoon() == 1) {
					status =true;
					value += ", 오후";
				}
				
				if(data.getEvening() == 1 && !status) {
					status =true;
					value += "| 저녁";
				}else if(data.getEvening() == 1) {
					status =true;
					value += ", 저녁";
				}
				value += ")";
				data.setDate(value);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}
	
	@Override
	public String getAdminLectureJsonData(String keyword) throws JsonProcessingException {
		
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<LectureForUser> lectureDATA = lectureDAO.getAdminLecture(keyword);
		
		for(LectureForUser data: lectureDATA) {
			if(data.getDate() != null && data.getDate() != "" && data.getDate().length() != 0) {
				String value = data.getDate().replace(')', ' ');
				boolean status = false;
				
				if(data.getMorning() == 1) {
					status =true;
					value += "| 오전";
				}
				
				if(data.getAfternoon() == 1 && !status) {
					status =true;
					value += "| 오후";
				}else if(data.getAfternoon() == 1) {
					status =true;
					value += ", 오후";
				}
				
				if(data.getEvening() == 1 && !status) {
					status =true;
					value += "| 저녁";
				}else if(data.getEvening() == 1) {
					status =true;
					value += ", 저녁";
				}
				value += ")";
				data.setDate(value);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}

	@Override
	public String getAllLectureJsonData() throws JsonProcessingException {
		
		List<LectureForUser> lectureDATA = lectureDAO.getAllLecture();

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}
	
	@Override
	public String getLectureJsonDataBySubject(String[] subject) throws JsonProcessingException {
		List<LectureForUser> lectureDATA;
		
		if(subject != null) {
			int[] subjectId = new int[subject.length];
			
			for(int i=0; i<subject.length; i++) {
				subjectId[i] = Integer.parseInt(subject[i]);
			}
			
			lectureDATA =  lectureDAO.getLectureBySubject(subjectId);
		}else {
			lectureDATA =  lectureDAO.getLectureBySubject(null);

		}
		for(LectureForUser data: lectureDATA) {
			if(data.getDate() != null && data.getDate() != "" && data.getDate().length() != 0) {
				String value = data.getDate().replace(')', ' ');
				boolean status = false;
				
				if(data.getMorning() == 1) {
					status =true;
					value += "| 오전";
				}
				
				if(data.getAfternoon() == 1 && !status) {
					status =true;
					value += "| 오후";
				}else if(data.getAfternoon() == 1) {
					status =true;
					value += ", 오후";
				}
				
				if(data.getEvening() == 1 && !status) {
					status =true;
					value += "| 저녁";
				}else if(data.getEvening() == 1) {
					status =true;
					value += ", 저녁";
				}
				value += ")";
				data.setDate(value);
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}

	@Override
	public String getLectureJsonDataByInstructor(int instructorId) throws JsonProcessingException {

		List<LectureForUser> lectureDATA =  lectureDAO.getLectureByInstructor(instructorId);
		
		for(LectureForUser data: lectureDATA) {
			if(data.getDate() == "" || data.getDate().length() == 0) {
				continue;
			}
			boolean status = false;
			String value = data.getDate().replace(')', ' ');
			
			if(data.getMorning() == 1) {
				status =true;
				value += "| 오전";
			}
			
			if(data.getAfternoon() == 1 && !status) {
				status =true;
				value += "| 오후";
			}else if(data.getAfternoon() == 1) {
				status =true;
				value += ", 오후";
			}
			
			if(data.getEvening() == 1 && !status) {
				status =true;
				value += "| 저녁";
			}else if(data.getEvening() == 1) {
				status =true;
				value += ", 저녁";
			}
			value += ")";
			data.setDate(value);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}

	@Override
	public String getLectureJsonDataByDate(String date) throws JsonProcessingException {

		List<LectureForUser> lectureDATA =  lectureDAO.getLectureByDate(date);
		
		for(LectureForUser data: lectureDATA) {
			if(data.getDate() == "" || data.getDate().length() == 0) {
				continue;
			}
			boolean status = false;
			String value = data.getDate().replace(')', ' ');
			
			if(data.getMorning() == 1) {
				status =true;
				value += "| 오전";
			}
			
			if(data.getAfternoon() == 1 && !status) {
				status =true;
				value += "| 오후";
			}else if(data.getAfternoon() == 1) {
				status =true;
				value += ", 오후";
			}
			
			if(data.getEvening() == 1 && !status) {
				status =true;
				value += "| 저녁";
			}else if(data.getEvening() == 1) {
				status =true;
				value += ", 저녁";
			}
			value += ")";
			data.setDate(value);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}

	@Override
	public String getLectureDetailJsonData(int lectureId) throws JsonProcessingException {

		List<LectureForUser> lectureDATA =  lectureDAO.getLectureDetail(lectureId);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lectureDATA);

		return jsonString;
	}

	@Override
	public void insertLecture(Lecture lectureData, String[] dateData, String[] topicValue, String[] regionValue) throws JsonProcessingException {
		InstructorInfo instructor = instructorInfoDAO.read(lectureData.getInstructor_id());
		lectureData.setInstructor_id(instructor.getId());
		
		lectureData.setId(lectureDAO.insertLecture(lectureData));
		
		int[] topicData = new int[topicValue.length];
		for(int i=0; i< topicValue.length; i++) {
			topicData[i]=Integer.parseInt(topicValue[i]);
		}
		lectureTopicDAO.insertLectureTopic(lectureData.getId(), topicData);
		
		int[] regionData = new int[regionValue.length];
		
		for(int i=0; i< regionValue.length; i++) {
			regionData[i]=Integer.parseInt(regionValue[i]);
		}
		lectureRegionDAO.insertLectureRegion(lectureData.getId(), regionData);
		if(lectureData.getStart_date() != null) {
			lectureDAO.insertLectureDate(lectureData.getId(), dateData);
		}
	}

	@Override
	public String readMainCalendar(int instructor_id, String date) throws JsonProcessingException {
		if(date == null) {
			date = "%%";
		} else {
			date = "%".concat(date).concat("%");
		}
		
		List<LectureForMainCaledar> list =  lectureDAO.getMainCalendarLecture(instructor_id, date);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(list);

		return jsonString;
	}

	@Override
	public String readLectureCalendar(String lecture_id, String date) throws JsonProcessingException {
		if(date == null) {
			date = "%%";
		} else {
			date = "%".concat(date).concat("%");
		}
		
		List<LectureForMainCaledar> list =  lectureDAO.readLectureCalendar(lecture_id, date);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(list);

		return jsonString;
	}

	@Override
	public void recoverLecture(int id) {
		lectureDAO.recoverLecture(id);
	}

	@Override
	public void deleteLecture(int id) {
		lectureDAO.deleteLecture(id);
	}

	@Override
	public String getLectureDetailByLectureId(int lectureId) throws JsonProcessingException {
		Lecture lecture = lectureDAO.getLectureDetailByLectureId(lectureId);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(lecture);

		return jsonString;
	}

	@Override
	public void update(String id, String name, String intro, String sample_url, String start_date, String end_date,
			String day_week, String morning, String afternoon, String evening) {
		lectureDAO.update(id, name, intro, sample_url, start_date, end_date, day_week, morning, afternoon, evening);
		if(start_date == null || end_date == null) {
			lectureDateDAO.deleteByChange(id);
		}
		
	}

	@Override
	public String getStatsByLecture(int period) throws JsonProcessingException {
		StatByLecture data = lectureDAO.getStatsByLecture(period);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(data);

		return jsonString;
	}

	@Override
	public void deleteLectureByLectureId(int instructor_id) {
		lectureDAO.deleteLectureByLectureId(instructor_id);
	}

	@Override
	public Lecture getLectureByLectureId(int lecture_id) {
		return lectureDAO.getLectureByLectureId(lecture_id);
	}


}

