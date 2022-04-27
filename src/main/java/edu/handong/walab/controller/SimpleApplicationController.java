package edu.handong.walab.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Church;
import edu.handong.walab.model.domain.ChurchTemp;
import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.ApplicationService;
import edu.handong.walab.service.ChurchService;
import edu.handong.walab.service.ChurchTempService;
import edu.handong.walab.service.InstructorInfoService;

@Controller
@RequestMapping("/application")
public class SimpleApplicationController {

	@Autowired
	ApplicationService applicationService;
	@Autowired
	InstructorInfoService instructorInfoservice;
	@Autowired
	ChurchService churchService;
	@Autowired
	ChurchTempService churchTempService;
	@Autowired
	AdminService adminService;
	@Value("${restAPI.crossOrigins}")
	String crossOrigins;


	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String createApplication(HttpServletRequest httpServletRequest) {
		int user_id = Integer.parseInt(httpServletRequest.getParameter("user_id").toString()); // section값
		int manageID = Integer.parseInt(httpServletRequest.getParameter("manageID").toString());
		
		InstructorInfo inst = instructorInfoservice.readInstructorInfoByUserId(manageID);
		System.out.println("====================");
		int church_id = Integer.parseInt(httpServletRequest.getParameter("church_id").toString());
		System.out.println("====================");
		if(church_id != 0) {
			Church church = churchService.readChurchById(church_id);
			System.out.println("====================");
			if(!church.getZip_code().equals(httpServletRequest.getParameter("zip_code").toString()) || !church.getAddr1().equals(httpServletRequest.getParameter("addr1").toString()) || !church.getAddr2().equals(httpServletRequest.getParameter("addr2").toString())
					|| !church.getPastor().equals(httpServletRequest.getParameter("pastor").toString()) || !church.getEmail().equals(httpServletRequest.getParameter("email").toString()) || !church.getPhone().equals(httpServletRequest.getParameter("phone").toString())) {
				church_id = 0;
				System.out.println("====================");
			}
		}
		
		if(inst == null) {
			applicationService.createApplication(
					user_id,
					Integer.parseInt(httpServletRequest.getParameter("lecture_id").toString()),
					Integer.parseInt(httpServletRequest.getParameter("lecture_date_id").toString()),
					church_id,
					httpServletRequest.getParameter("memo").toString().replaceAll("\n", "<br/>"),
					httpServletRequest.getParameter("admin_phone").toString(),
					httpServletRequest.getParameter("admin_name").toString(),
					httpServletRequest.getParameter("admin_email").toString(),
					Integer.parseInt(httpServletRequest.getParameter("attendee_number").toString()),
					httpServletRequest.getParameter("attendee_target").toString(),
					httpServletRequest.getParameter("timezone").toString());
			System.out.println("=======Before Email");
//			applicationService.writeEmail(httpServletRequest.getParameter("inst_email").toString(), httpServletRequest.getParameter("date").toString(), httpServletRequest.getParameter("lecture_name").toString(), httpServletRequest.getParameter("church_name").toString(), httpServletRequest.getParameter("link").toString());
			System.out.println("=======After Email");
			int application_form_id = applicationService.getLastId();
	
			if(church_id == 0)
				churchTempService.createChurchTemp(
							application_form_id, 
							Integer.parseInt(httpServletRequest.getParameter("church_id").toString()), 
							httpServletRequest.getParameter("church").toString(), 
							httpServletRequest.getParameter("city").toString(), 
							httpServletRequest.getParameter("district").toString(), 
							httpServletRequest.getParameter("zip_code").toString(), 
							httpServletRequest.getParameter("addr1").toString(), 
							httpServletRequest.getParameter("addr2").toString(), 
							httpServletRequest.getParameter("admin_name").toString(),
							httpServletRequest.getParameter("pastor").toString(),
							httpServletRequest.getParameter("phone").toString(),
							httpServletRequest.getParameter("email").toString()
							);
		}
		return "끝남";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAllApplication(HttpServletRequest httpServletRequest) {

		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String status = httpServletRequest.getParameter("statusSelect");

		return applicationService.readAll(keyword, status);

	}

	@RequestMapping(value = "read", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readApplicationFormByInstructor(HttpServletRequest httpServletRequest) {

		InstructorInfo inst = instructorInfoservice.readInstructorByUserID(Integer.parseInt(httpServletRequest.getParameter("user_id")));
		return applicationService.read(inst.getId());

	}

	@RequestMapping(value = "feedback", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAllApplicationForFeedback(HttpServletRequest httpServletRequest) {
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return applicationService.readAllApplicationForFeedback(keyword);
	}

	@RequestMapping(value = "visiting_log", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readApplicationForVisitingLog(HttpServletRequest httpServletRequest) {
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return applicationService.readAllApplicationForVisitingLog(keyword);
	}

	@RequestMapping(value = "user/{user_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readApplicationByUser(@PathVariable int user_id, HttpServletRequest httpServletRequest) {

		return applicationService.readApplicationForFeedback(user_id);
	}
	
	@RequestMapping(value = "user/{user_id}/contacted", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readApplicationByUserContacted(@PathVariable int user_id, HttpServletRequest httpServletRequest) {

		return applicationService.readContactedApplicationForFeedback(user_id);
	}

	@RequestMapping(value = "instructor/{instructor_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readApplicationByInstructor(@PathVariable int instructor_id, HttpServletRequest httpServletRequest) {
		return applicationService.readApplicationForVisitingLog(instructor_id);
	}

	@RequestMapping(value = "status", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public String updateApplicationStatus(@RequestBody Map<String,Object> param) {
//		int manageID = Integer.parseInt(param.get("manageID").toString());
//		Administrator admin = adminService.readAdminInfoByUserID(manageID);
//		InstructorInfo inst = instructorInfoservice.readInstructorByUserID(manageID);
//		// 관리자나 강사의 경우 
//		if(admin != null || inst != null) {
//			applicationService.updateStatus(Integer.parseInt(param.get("application_form_id").toString()), Integer.parseInt(param.get("status").toString()));
//		}
		return applicationService.updateStatus(Integer.parseInt(param.get("application_form_id").toString()), Integer.parseInt(param.get("status").toString()));
	}

	@RequestMapping(value = "complete", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public String completeContact(@RequestBody Map<String, Object> param) throws ParseException {
		return applicationService.completeContact(
				Integer.parseInt(param.get("application_form_id").toString()),
				param.get("selectDate").toString(),
				Integer.parseInt(param.get("lecture_id").toString()),
				param.get("contact_start_date").toString(),
				param.get("contact_end_date").toString(),
				param.get("contact_memo").toString().replaceAll("\n", "<br/>"),
				Integer.parseInt(param.get("status").toString()));
	}


	@RequestMapping(value = "stat/all", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readStatAllData() {
		return applicationService.readStatAllData();
	}
	@RequestMapping(value = "statistics/religious-body", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String statisticsBasedOnReligiousBody(HttpServletRequest httpServletRequest) {
		String period = httpServletRequest.getParameter("period");

		return applicationService.statisticsBasedOnReligiousBody(period);
	}

	@RequestMapping(value = "statistics/region", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String statisticsBasedOnRegion(HttpServletRequest httpServletRequest) {
		String period = httpServletRequest.getParameter("period");

		return applicationService.statisticsBasedOnRegion(period);
	}

	@RequestMapping(value = "statistics/instructor", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String statisticsBasedOnInstructorPosition(HttpServletRequest httpServletRequest) {
		String period = httpServletRequest.getParameter("period");

		return applicationService.statisticsBasedOnInstructor(period);
	}
}