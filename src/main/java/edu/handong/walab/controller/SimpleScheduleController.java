package edu.handong.walab.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.service.InstructorInfoService;
import edu.handong.walab.service.LectureService;


@Controller
@RequestMapping("/calendar")
public class SimpleScheduleController {
	
	@Autowired
	LectureService lectureService;
	
	@Autowired
	InstructorInfoService instructorInfoservice;
	
	@RequestMapping(value = "main", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String mainCalendar(HttpServletRequest httpServletRequest) throws JsonProcessingException {
		InstructorInfo inst;
		String date = httpServletRequest.getParameter("date");
		if(httpServletRequest.getParameter("user_id") != null) {
			inst = instructorInfoservice.readInstructorByUserID(Integer.parseInt(httpServletRequest.getParameter("user_id")));
			return lectureService.readMainCalendar(inst.getId(), date);
		}
		else
			return lectureService.readMainCalendar(0, date);
	}
	
	@RequestMapping(value = "lecture", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String lectureCalendar(HttpServletRequest httpServletRequest) throws JsonProcessingException {
		String lecture_id = httpServletRequest.getParameter("lecture_id");
		String date = httpServletRequest.getParameter("date");
		
		return lectureService.readLectureCalendar(lecture_id, date);
	}
}
