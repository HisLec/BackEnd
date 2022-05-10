package edu.handong.walab.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.InstructorInfo;
import edu.handong.walab.model.domain.User;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.ApplicationService;
import edu.handong.walab.service.InstructorInfoService;
import edu.handong.walab.service.LectureService;
import edu.handong.walab.service.UserService;


@Controller
@RequestMapping("/instructor")
public class SimpleInstructorController {
	
	@Autowired
	InstructorInfoService instructorInfoService;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	LectureService lectureService;
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Value("${restAPI.crossOrigins}")
	String crossOrigins;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String createInstructor(HttpServletRequest httpServletRequest, MultipartHttpServletRequest multi) {
		MultipartFile file = multi.getFile("file");
		Calendar calendar = Calendar.getInstance();
		String path = "";
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"; //파일 저장 경로, 설정파일로 따로 관리한다.
	    if(file != null) {
	    	File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
		    if (!dir.exists()) {
		        dir.mkdirs();
		    }
		    try {
	    		int count = 1;
	    		File newFile = new File(filePath+calendar.getTimeInMillis());
	    		path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis();
	    		while(newFile.exists()) {
	    			newFile = new File(filePath+calendar.getTimeInMillis()+"("+count+")");
	    			path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis()+"("+count+")";
	    			count++;
	    		}
	    		if (!newFile.exists()) {
	    			newFile.mkdirs();
	    	    }
				file.transferTo(newFile);
			} catch (Exception e) {
				int count = 1;
//				System.out.println("postTempFile_ERROR======>"+filePath+calendar.getTimeInMillis()+"("+count+")");
	            e.printStackTrace();
			}
	    }
	    String result = instructorInfoService.createInstructor(
			httpServletRequest.getParameter("email").toString(),
			Integer.parseInt(httpServletRequest.getParameter("position_id").toString()),
			httpServletRequest.getParameter("name").toString(),
			httpServletRequest.getParameter("phone").toString(),
			path,
			httpServletRequest.getParameter("intro").toString(),
			httpServletRequest.getParameter("memo").toString());
	    System.out.println("&&&&&&&");
	    System.out.println(result);
	    return result;
	}
	
	@RequestMapping(value = "excel", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createExcelInstructor(HttpServletRequest httpServletRequest) throws JsonProcessingException {
		String excelJSON = httpServletRequest.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> excelData = mapper.readValue(excelJSON, new TypeReference<List<Map<String, Object>>>(){});
		
		for(int i=0 ; i<excelData.size() ; i++) {
			if(excelData.get(i).get("isValid").toString().equals("true")) {
				int position_id = instructorInfoService.readPositionID(excelData.get(i).get("position").toString());
				instructorInfoService.createInstructor(
						excelData.get(i).get("email").toString(),
						position_id,
						excelData.get(i).get("name").toString(),
						excelData.get(i).get("phone").toString(),
						null,
						excelData.get(i).get("intro").toString(),
						excelData.get(i).get("memo").toString());
			}
		}
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAllInstructors(HttpServletRequest httpServletRequest) {
		
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return instructorInfoService.readInstructors(keyword);
	}
	
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAllInstructorsByMainpage(HttpServletRequest httpServletRequest) {
		
		return instructorInfoService.readAllInstructors();
	}
	
	@RequestMapping(value = "position", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readPosition(HttpServletRequest httpServletRequest) {
		return instructorInfoService.readPosition();
	}
	
	@RequestMapping(value = "{user_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String read(@PathVariable int user_id) {
		//int user_id = 2; // 로그인 세션 값
		return instructorInfoService.read(user_id);
	}
	
	@RequestMapping(value = "instructorId/{instructor_id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readByInstructorId(@PathVariable int instructor_id) {
		//int user_id = 2; // 로그인 세션 값
		return instructorInfoService.readByInstructorId(instructor_id);
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String updateInstructor(HttpServletRequest httpServletRequest, MultipartHttpServletRequest multi) {
		int id = Integer.parseInt(httpServletRequest.getParameter("id"));
		int manageID = Integer.parseInt(httpServletRequest.getParameter("manageID"));
		int user_id = instructorInfoService.readInstructorById(id).getUser_id();
		Administrator admin = adminService.readAdminInfoByUserID(manageID);
		
		System.out.println(httpServletRequest.getParameter("phone")+"/"+httpServletRequest.getParameter("phone")+"/"+httpServletRequest.getParameter("intro")+"/"+httpServletRequest.getParameter("phone")+"/");
		MultipartFile file = multi.getFile("file");
		Calendar calendar = Calendar.getInstance();
		String path = httpServletRequest.getParameter("image");
		String filePath = httpServletRequest.getSession().getServletContext().getRealPath("/") + "resources/upload/"+calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"; //파일 저장 경로, 설정파일로 따로 관리한다.
		System.out.println(filePath);
	    if(file != null) {
	    	File dir = new File(filePath); //파일 저장 경로 확인, 없으면 만든다.
		    if (!dir.exists()) {
		        dir.mkdirs();
		    }
		    try {
	    		int count = 1;
	    		File newFile = new File(filePath+calendar.getTimeInMillis());
	    		path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis();
	    		while(newFile.exists()) {
	    			newFile = new File(filePath+calendar.getTimeInMillis()+"("+count+")");
	    			path = calendar.get(calendar.YEAR)+"/"+(calendar.get(calendar.MONTH)+1)+"/"+calendar.getTimeInMillis()+"("+count+")";
	    			count++;
	    			System.out.println(newFile.getPath());
	    		}
	    		if (!newFile.exists()) {
	    			newFile.mkdirs();
	    	    }
				file.transferTo(newFile);
				System.out.println(newFile.getPath());
				System.out.println(newFile.getAbsolutePath());
				System.out.println(path);
			} catch (Exception e) {
				int count = 1;
				System.out.println("postTempFile_ERROR======>"+filePath+calendar.getTimeInMillis()+"("+count+")");
	            e.printStackTrace();
			}
	    }
	    
		if(admin == null) {
			if(manageID == user_id) {
				return instructorInfoService.update(
						id,
						Integer.parseInt(httpServletRequest.getParameter("position_id")),
						httpServletRequest.getParameter("name"),
						httpServletRequest.getParameter("phone"),
						path,
						httpServletRequest.getParameter("intro"),
						httpServletRequest.getParameter("memo"));
			}
		} else {
			return instructorInfoService.update(
					id,
					Integer.parseInt(httpServletRequest.getParameter("position_id")),
					httpServletRequest.getParameter("name"),
					httpServletRequest.getParameter("phone"),
					path,
					httpServletRequest.getParameter("intro"),
					httpServletRequest.getParameter("memo"));
		}
		return null;
	}

	@RequestMapping(value = "delete", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteInstructor(@RequestBody Map<String,Object> param) throws JsonMappingException, JsonProcessingException {
		
		String token = param.get("token").toString();
		int id= 0;
		
		try{
			id = Integer.parseInt(param.get("manageID").toString());
		}catch (Exception e){
			System.out.println(e);
		    return;
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String requestUrl;
		try{
			requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
					.queryParam("id_token", token).build().toUriString();
		}catch (Exception e){
			System.out.println(e);
		    return;
		}
		
		String resultJson = restTemplate.getForObject(requestUrl, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
		User user = userService.getUserByEmail(userInfo.get("email"));
		if(id != user.getId() || user.getStatus() != 2) {
			return;
		}
		
		int instructor_id = Integer.parseInt(param.get("instructor_id").toString());
		instructorInfoService.delete(instructor_id);
		lectureService.deleteLectureByLectureId(instructor_id);
		applicationService.cancelNotFinishByInstructor(instructor_id);
		applicationService.cancelFinishByInstructor(instructor_id);
	}
	
	@RequestMapping(value = "recover", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public String recoverInstructor(@RequestBody Map<String,Object> param) throws JsonMappingException, JsonProcessingException {
		
		String token = param.get("token").toString();
		int id= 0;
		
		try{
			id = Integer.parseInt(param.get("manageID").toString());
		}catch (Exception e){
			System.out.println(e);
		    return null;
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String requestUrl;
		try{
			requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
					.queryParam("id_token", token).build().toUriString();
		}catch (Exception e){
			System.out.println(e);
		    return null;
		}
		
		String resultJson = restTemplate.getForObject(requestUrl, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
		User user = userService.getUserByEmail(userInfo.get("email"));
		if(id != user.getId() || user.getStatus() != 2) {
			return null;
		}
		return instructorInfoService.recover(
				Integer.parseInt(param.get("id").toString()),
				param.get("email").toString());
	}
	
	@RequestMapping(value = "stat/position/{period}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readStatByPosition(@PathVariable int period) {
		return instructorInfoService.readStatByPosition(period);
	}
	

}
