package edu.handong.walab.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.handong.walab.service.LectureDateService;

@Controller
@RequestMapping("/lectureDate")
public class SimpleLectureDateController {
	
	@Autowired
	LectureDateService lectureDateService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String read(@RequestParam(value ="lecture_id") int lecture_id) {
		return lectureDateService.readByLectureId(lecture_id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void create(HttpServletRequest httpServletRequest) {
		lectureDateService.create(
			httpServletRequest.getParameter("lecture_id"),
			httpServletRequest.getParameter("date"));
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void update(@RequestBody Map<String, String> param) {
		lectureDateService.update(
				param.get("id"),
				param.get("lecture_id"),
				param.get("date"));
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void delete(@RequestBody Map<String, String> param) {
		lectureDateService.delete(param.get("id"));
	}

	
}
