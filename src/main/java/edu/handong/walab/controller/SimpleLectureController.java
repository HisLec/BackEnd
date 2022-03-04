package edu.handong.walab.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.Lecture;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.ApplicationService;
import edu.handong.walab.service.InstructorInfoService;
import edu.handong.walab.service.LectureDateService;
import edu.handong.walab.service.LectureRegionService;
import edu.handong.walab.service.LectureService;
import edu.handong.walab.service.LectureTopicService;

@Controller
@RequestMapping("/lecture")
public class SimpleLectureController {

	@Autowired
	LectureService lectureService;

	@Autowired
	LectureTopicService lectureTopicService;

	@Autowired
	LectureRegionService lectureRegionService;

	@Autowired
	LectureDateService lectureDateService;

	@Autowired
	InstructorInfoService instructorInfoService;
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	AdminService adminService;
	
	
	@RequestMapping(value = "category", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureCategory(HttpServletRequest httpServletRequest) throws IOException, ParseException {

		return lectureTopicService.getLectureTopicJsonData();
	}

	@RequestMapping(value = "region", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureRegion(HttpServletRequest httpServletRequest) throws IOException, ParseException {

		return lectureRegionService.getLectureRegionJsonData();
	}

	@RequestMapping(value = "topic/{lectureId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureTopicByLectureId(@PathVariable int lectureId) throws IOException, ParseException {

		return lectureTopicService.getLectureTopicByLectureId(lectureId);
	}

	@RequestMapping(value = "lectureDetail/{lectureId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureDetailByLectureId(@PathVariable int lectureId) throws IOException, ParseException {

		return lectureService.getLectureDetailByLectureId(lectureId);
	}

	@RequestMapping(value = "region/{lectureId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureRegionByLectureId(@PathVariable int lectureId) throws IOException, ParseException {

		return lectureRegionService.getLectureRegionByLectureId(lectureId);
	}

	@RequestMapping(value = "subject", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureBySubject(HttpServletRequest httpServletRequest) throws IOException, ParseException {
		System.out.println("in subject");
		String subjectAll = httpServletRequest.getParameter("subject");
		String[] subject;
		if(subjectAll != null)
			subject = subjectAll.split(",");
		else {
			subject = null;
		}
		System.out.println("in subject end");
		return lectureService.getLectureJsonDataBySubject(subject);
	}

	@RequestMapping(value = "instructor/{userId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureByInstructor(@PathVariable int userId) throws IOException, ParseException {
		return lectureService.getLectureJsonDataByInstructor(userId);
	}

	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureByUserID(@PathVariable int userId) throws IOException, ParseException {

		InstructorInfo instructor = instructorInfoService.readInstructorInfoByUserId(userId);

		return lectureService.getLectureJsonDataByInstructor(instructor.getId());
	}


	@RequestMapping(value = "date/{date}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureByDate(@PathVariable String date) throws IOException, ParseException {
		if(date.equals("empty")) {
			date = null;
		}
		return lectureService.getLectureJsonDataByDate(date);
	}

	@RequestMapping(value = "detail/{lectureId}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureDetail(@PathVariable int lectureId) throws IOException, ParseException {
		return lectureService.getLectureDetailJsonData(lectureId);
	}

	@RequestMapping(value = "instructor/{instructorId}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void insertLecture(@PathVariable int instructorId, HttpServletRequest httpServletRequest) throws IOException, ParseException {
		int manageID = Integer.parseInt(httpServletRequest.getParameter("manageID"));
		Administrator admin = adminService.readAdminInfoByUserID(manageID);
		
		InstructorInfo inst = instructorInfoService.readInstructorInfoByUserId(manageID);
		if(inst != null || admin != null) {
			Lecture lectureData = new Lecture(instructorId, httpServletRequest.getParameter("name"), httpServletRequest.getParameter("intro").replaceAll("\n", "<br/>"), httpServletRequest.getParameter("sample_url"), httpServletRequest.getParameter("start_date"),httpServletRequest.getParameter("end_date"), httpServletRequest.getParameter("day_week"), Integer.parseInt(httpServletRequest.getParameter("morning")), Integer.parseInt(httpServletRequest.getParameter("afternoon")), Integer.parseInt(httpServletRequest.getParameter("evening")), null);
			String [] lectureDate = httpServletRequest.getParameter("dateData").split(",");

			String[] topicValue = httpServletRequest.getParameter("topic").split(",");
			String[] regionValue = httpServletRequest.getParameter("region").split(",");

			lectureService.insertLecture(lectureData, lectureDate, topicValue, regionValue);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLecture(HttpServletRequest httpServletRequest) throws IOException, ParseException {

		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return lectureService.getLectureJsonData(keyword);
	}
	
	@RequestMapping(value = "admin", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getLectureByAdmin(HttpServletRequest httpServletRequest) throws IOException, ParseException {

		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return lectureService.getAdminLectureJsonData(keyword);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getAllLecture(HttpServletRequest httpServletRequest) throws IOException, ParseException {

		return lectureService.getAllLectureJsonData();
	}

	@RequestMapping(value = "delete", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteLecture(@RequestBody Map<String,Object> param) {
		// 해당하는 강의의 신청서를 모두 거절처리함. -> 오늘 이후의 신청서에 대해서!
		int lecture_id = Integer.parseInt(param.get("id").toString());
		int manageID = Integer.parseInt(param.get("manageID").toString());
		Administrator admin = adminService.readAdminInfoByUserID(manageID);
		if(admin == null) {
			// 관리자가 아닐 경우 
			InstructorInfo inst = instructorInfoService.readInstructorInfoByUserId(manageID);
			int lec_creator = lectureService.getLectureByLectureId(lecture_id).getInstructor_id();
			if(inst != null && inst.getId() == lec_creator) {
				lectureService.deleteLecture(lecture_id);
				applicationService.cancelNotFinishByLecture(lecture_id);
				applicationService.cancelFinishByLecture(lecture_id);
			}
		} else {
			lectureService.deleteLecture(lecture_id);
			applicationService.cancelNotFinishByLecture(lecture_id);
			applicationService.cancelFinishByLecture(lecture_id);
		}
	}

	@RequestMapping(value = "recover", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void recoverLecture(@RequestBody Map<String,Object> param) {
		lectureService.recoverLecture(Integer.parseInt(param.get("id").toString()));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateAcademyDate(@RequestBody Map<String,Object> param) throws JsonProcessingException {
		String id = param.get("id").toString();
		String name = param.get("name").toString();
		String intro = param.get("intro").toString().replaceAll("\n", "<br/>");
		String sample_url = param.get("sample_url").toString();
		String start_date = null;
		if(param.get("start_date") != null)
			start_date = param.get("start_date").toString();
		String end_date = null;
		if(param.get("end_date") != null)
			end_date = param.get("end_date").toString();
		String morning = param.get("morning").toString();
		String evening = param.get("evening").toString();
		String afternoon = param.get("afternoon").toString();
		String day_week = param.get("day_week").toString();
		Object regionInfo = param.get("regionInfo");
		Object topicInfo = param.get("topicInfo");
		Object dateInfo = param.get("dateInfo");
		ObjectMapper mapper = new ObjectMapper();

		String regionJSON = mapper.writeValueAsString(regionInfo);
		String topicJSON = mapper.writeValueAsString(topicInfo);
		String dateJSON = mapper.writeValueAsString(dateInfo);
		List<Map<String, Object>> regionMap = mapper.readValue(regionJSON, new TypeReference<List<Map<String, Object>>>(){});
		List<Map<String, Object>> topicMap = mapper.readValue(topicJSON, new TypeReference<List<Map<String, Object>>>(){});
		List<Map<String, Object>> dateMap = mapper.readValue(dateJSON, new TypeReference<List<Map<String, Object>>>(){});
		
		int manageID = Integer.parseInt(param.get("manageID").toString());
		Administrator admin = adminService.readAdminInfoByUserID(manageID);
		
		if(admin == null) {
			InstructorInfo inst = instructorInfoService.readInstructorInfoByUserId(manageID);
			int lec_creator = lectureService.getLectureByLectureId(Integer.parseInt(id)).getInstructor_id();
			if(inst != null && inst.getId() == lec_creator) {
				lectureService.update(id, name, intro, sample_url, start_date, end_date, day_week, morning, afternoon, evening);
				lectureRegionService.updateLectureRegion(id, regionMap);
				lectureTopicService.updateLectureTopic(id, topicMap);
				if(start_date != null)
					lectureDateService.updateLectureDate(id, dateMap);
			}
		} else {
			lectureService.update(id, name, intro, sample_url, start_date, end_date, day_week, morning, afternoon, evening);
			lectureRegionService.updateLectureRegion(id, regionMap);
			lectureTopicService.updateLectureTopic(id, topicMap);
			if(start_date != null)
				lectureDateService.updateLectureDate(id, dateMap);
		}
	}
	
	@RequestMapping(value = "stat/{period}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String getStatsByLecture(@PathVariable int period) throws IOException, ParseException {
		return lectureService.getStatsByLecture(period);
	}
}
