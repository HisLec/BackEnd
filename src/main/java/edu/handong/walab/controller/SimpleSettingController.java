package edu.handong.walab.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.handong.walab.model.dto.Phrase;
import edu.handong.walab.service.SettingService;

@Controller
@RequestMapping("/setting")
public class SimpleSettingController {
	
	@Autowired
	SettingService settingService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String read() {
		return settingService.readSetting();
	}
	
	@RequestMapping(value = "admin", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readByAdmin() {
		return settingService.readSettingByAdmin();
	}
	
	@RequestMapping(value = "mainHome", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editMainPage(HttpServletRequest httpServletRequest, @RequestParam("file") List<MultipartFile> file) {
		
		//List<MultipartFile> file = multi.getFiles("file");
		Calendar calendar = Calendar.getInstance();
		String[] values = httpServletRequest.getParameter("values").split(",");
		String delay = httpServletRequest.getParameter("delay");
		String[] fileCount = httpServletRequest.getParameter("fileCount").split(",");
		
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/";
		int index = 0;
		
		for(MultipartFile f: file) {
	    	if(f != null) {
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
					values[Integer.parseInt(fileCount[index])] = path;
					index++;
				} catch (Exception e) {
					int count = 1;
		            e.printStackTrace();
				}
	    	}
	    }
		settingService.updateMainHome(values, delay);
	}
	
	
	@RequestMapping(value = "explainSite", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editExplainSitePage(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) {
		Calendar calendar = Calendar.getInstance();
		String value = httpServletRequest.getParameter("value");
		String content = httpServletRequest.getParameter("content");
		
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/";

		if(file != null) {
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
				file.transferTo(newFile);
				value = path;
			} catch (Exception e) {
				int count = 1;
	            e.printStackTrace();
			}
    	}
		settingService.updateExplainSite(value, content);
	}
	
	@RequestMapping(value = "explainInstructor", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editExplainInstructorPage(HttpServletRequest httpServletRequest, @RequestParam("file") List<MultipartFile> file) {
		Calendar calendar = Calendar.getInstance();
		String[] values = httpServletRequest.getParameter("values").split(",");
		String[] fileCount = httpServletRequest.getParameter("fileCount").split(",");
		String[] instructorId = httpServletRequest.getParameter("instructor_id").split(",");
		String[] finalValues = new String[4];
		
		
		for(int i=0; i<4; i++) {
			finalValues[i] = values[i];
		}
		
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/";
		int index = 0;
		
		for(MultipartFile f: file) {
	    	if(f != null) {
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
					finalValues[Integer.parseInt(fileCount[index])] = path;
					index++;
				} catch (Exception e) {
					int count = 1;
		            e.printStackTrace();
				}
	    	}
	    }
		
		settingService.updateMainInstructorPage(finalValues, instructorId);
	}
	
	@RequestMapping(value = "explainLecture", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editExplainLecturePage(HttpServletRequest httpServletRequest, @RequestParam("file") List<MultipartFile> file) {
		Calendar calendar = Calendar.getInstance();
		String[] values = httpServletRequest.getParameter("values").split(",");
		String[] fileCount = httpServletRequest.getParameter("fileCount").split(",");
		String[] lectureId = httpServletRequest.getParameter("lecture_id").split(",");
		String[] finalValues = new String[8];
		String[] finalId = new String[8];
		
		for(int i=0; i<8; i++) {
			if(i<values.length)
				finalValues[i] = values[i];
		}
		
		
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/";
		int index = 0;
		
		for(MultipartFile f: file) {
	    	if(f != null) {
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
					finalValues[Integer.parseInt(fileCount[index])] = path;
					index++;
				} catch (Exception e) {
					int count = 1;
		            e.printStackTrace();
				}
	    	}
	    }
		
		settingService.updateMainLecturePage(finalValues, lectureId);
	}
	
	@RequestMapping(value = "phrase1", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editPhrasePage1(HttpServletRequest httpServletRequest) {
		Phrase phrase = 
				new Phrase(
					httpServletRequest.getParameter("lecture_page_phrase"),
					
					httpServletRequest.getParameter("application_page_phrase"),
					httpServletRequest.getParameter("application_below_date_phrase"),
					httpServletRequest.getParameter("application_list_phrase"),
					
					httpServletRequest.getParameter("mypage_profile_phrase"),
					httpServletRequest.getParameter("mypage_lecture_phrase"),
					httpServletRequest.getParameter("mypage_contact_phrase"),
					httpServletRequest.getParameter("mypage_visit_phrase"),
					
					httpServletRequest.getParameter("agree_personal_information_1"),
					httpServletRequest.getParameter("agree_personal_information_2"),
					httpServletRequest.getParameter("agree_personal_information_3")
				);
		
		settingService.updatePhrasePage1(phrase);
	}
	
	@RequestMapping(value = "phrase2", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void editPhrasePage2(HttpServletRequest httpServletRequest) {
		Phrase phrase = 
				new Phrase(
					httpServletRequest.getParameter("lecture_page_phrase"),
					
					httpServletRequest.getParameter("application_page_phrase"),
					httpServletRequest.getParameter("application_below_date_phrase"),
					httpServletRequest.getParameter("application_list_phrase"),
					
					httpServletRequest.getParameter("mypage_profile_phrase"),
					httpServletRequest.getParameter("mypage_lecture_phrase"),
					httpServletRequest.getParameter("mypage_contact_phrase"),
					httpServletRequest.getParameter("mypage_visit_phrase"),
					
					httpServletRequest.getParameter("agree_personal_information_1"),
					httpServletRequest.getParameter("agree_personal_information_2"),
					httpServletRequest.getParameter("agree_personal_information_3")
				);
		settingService.updatePhrasePage2(phrase);
	}
	
}
