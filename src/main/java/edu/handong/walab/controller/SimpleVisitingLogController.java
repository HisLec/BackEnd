package edu.handong.walab.controller;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.ApplicationForm;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.ApplicationService;
import edu.handong.walab.service.VisitingLogService;

@Controller
@RequestMapping("/visiting_log")
public class SimpleVisitingLogController {

	
	@Autowired
	VisitingLogService vistingLogService;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "feedback/file/{feedback_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackFile(@PathVariable int feedback_id, HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		
		return vistingLogService.readFeedbackFile(feedback_id);
	}
	
	@RequestMapping(value = "file/{visiting_log_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readVisitingLogFile(@PathVariable int visiting_log_id, HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		
		return vistingLogService.readVisitingLogFile(visiting_log_id);
	}
	
	@RequestMapping(value = "feedback/instructor", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackByInstructor(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		
		String instructor_id = httpServletRequest.getParameter("instructor_id");
		
		return vistingLogService.readFeedbackByInstructor(instructor_id);
	}
	
	@RequestMapping(value = "feedback/file/instructor", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackFileByInstructor(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {	
		String instructor_id = httpServletRequest.getParameter("instructor_id");
		
		return vistingLogService.readFeedbackFileByInstructor(instructor_id);
	}
	
	@RequestMapping(value = "feedback/topic", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackByTopic(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		String topicAll = httpServletRequest.getParameter("topic");
		String [] topic;
		if(topicAll != null) {
			topic = topicAll.split(",");
		}
		else
			topic = null;
		
		return vistingLogService.readFeedbackByTopic(topic);
	}
	
	@RequestMapping(value = "feedback/file/topic", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackFileByTopic(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		String topicAll = httpServletRequest.getParameter("topic");
		String [] topic;
		if(topicAll != null) {
			topic = topicAll.split(",");
		}
		else
			topic = null;
		
		return vistingLogService.readFeedbackFileByTopic(topic);
	}
	
	@RequestMapping(value = "feedback/file/date", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackFileByDate(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		String date = httpServletRequest.getParameter("date");
		
		return vistingLogService.readFeedbackFileByDate(date);
	}
	@RequestMapping(value = "feedback/file/lecture", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackFileByLecture(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		
		String lecture_id = httpServletRequest.getParameter("lecture_id");
		return vistingLogService.readFeedbackFileByLecture(lecture_id);
	}
	
	@RequestMapping(value = "feedback/lecture", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readFeedbackByLecture(HttpServletRequest httpServletRequest) throws ParseException, JsonProcessingException {
		
		String lecture_id = httpServletRequest.getParameter("lecture_id");
		return vistingLogService.readFeedbackByLecture(lecture_id);
	}
	
	@RequestMapping(value = "feedback/{application_form_id}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String writeFeedback(@PathVariable int application_form_id, @RequestParam("file") List<MultipartFile> file, 
			@RequestParam("content") String content, @RequestParam("lecture_rating") int lectureRating, @RequestParam("instructor_rating") int instructorRating, @RequestParam("manageID") int manageID,
			HttpServletRequest request) throws ParseException {
		System.out.println("=============================================");
		HashMap<String,Integer> param = new HashMap<>();
//		param.put("", null)
		System.out.println(manageID);
		// manageID가 작성한 신청서가 맞는지
		int isApplication = applicationService.readByUserID(manageID).getId();
		System.out.println(isApplication);
		
		if(isApplication == application_form_id) {
			List<String> fileData = new ArrayList<String>();
			Calendar calendar = Calendar.getInstance();
			String filePath = request.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"; //파일 저장 경로, 설정파일로 따로 관리한다.
		    File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
		    if (!dir.exists()) {
		        dir.mkdirs();
		    }
		    for(MultipartFile f: file) {
		    	try {
		    		int count = 1;
		    		File newFile = new File(filePath+calendar.getTimeInMillis());
		    		String path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis();
		    		while(newFile.exists()) {
		    			newFile = new File(filePath+calendar.getTimeInMillis()+"("+count+")");
		    			path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis()+"("+count+")";
		    			count++;
		    		}
		    		if (!newFile.exists()) {
		    			newFile.mkdirs();
		    	    }
					f.transferTo(newFile);
					fileData.add(path);
				} catch (Exception e) {
					int count = 1;
		            e.printStackTrace();
				}
		    }
		    
			
			return vistingLogService.writeFeedbackLog(application_form_id, content, lectureRating, instructorRating, fileData);
		}
		return null;	
	}
	
	@RequestMapping(value = "application_form/{application_form_id}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String writeVisitLog(@PathVariable int application_form_id, @RequestParam("file") List<MultipartFile> file, 
			@RequestParam("content") String content, @RequestParam("manageID") int manageID, HttpServletRequest request) throws ParseException {
		
		Administrator admin = adminService.readAdminInfoByUserID(manageID);
		List<String> fileData = new ArrayList<String>();
		
		Calendar calendar = Calendar.getInstance();
		String filePath = request.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"; //파일 저장 경로, 설정파일로 따로 관리한다.
	    File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    for(MultipartFile f: file) {
	    	try {
	    		int count = 1;
	    		File newFile = new File(filePath+calendar.getTimeInMillis());
	    		String path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis();
	    		while(newFile.exists()) {
	    			newFile = new File(filePath+calendar.getTimeInMillis()+"("+count+")");
	    			path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis()+"("+count+")";
	    			count++;
	    		}
	    		if (!newFile.exists()) {
	    			newFile.mkdirs();
	    	    }
				f.transferTo(newFile);
				fileData.add(path);
			} catch (Exception e) {
				int count = 1;
	            e.printStackTrace();
			}
	    }
	    
	    if(admin != null) {
	    	ApplicationForm app = applicationService.readByID(application_form_id);
	    	if(app.getUser_id() == manageID)
	    		return vistingLogService.writeVisitingLog(application_form_id, content, fileData);
	    } else {
	    	return vistingLogService.writeVisitingLog(application_form_id, content, fileData);
	    }
	    
	    return null;
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteVisitLog(@RequestBody Map<String,Object> param) {
		int application_form_id = Integer.parseInt(param.get("application_form_id").toString());
		int id = Integer.parseInt(param.get("id").toString());
		int manageID = Integer.parseInt(param.get("manageID").toString());
		Administrator admin = adminService.readAdminInfoByUserID(manageID);

		if(admin == null) {
			int creator_id = vistingLogService.readVisitingCreator(application_form_id);
			System.out.println(param.get("id").toString()+":"+application_form_id + ":"+manageID+":"+creator_id);
			if(manageID == creator_id) {
				vistingLogService.delete(id);
			}
		} else {
			vistingLogService.delete(application_form_id);
		}
	}
	
	@RequestMapping(value = "feedback", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteFeedback(@RequestBody Map<String,Object> param) {
		vistingLogService.deleteFeedback(
			Integer.parseInt(param.get("id").toString())
		);
	}
}
