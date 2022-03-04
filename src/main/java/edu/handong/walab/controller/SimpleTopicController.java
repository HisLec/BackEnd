package edu.handong.walab.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.User;
import edu.handong.walab.service.LectureTopicService;
import edu.handong.walab.service.UserService;


@Controller
@RequestMapping("/topic")
public class SimpleTopicController {
	
	@Autowired
	LectureTopicService lectureTopicService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String createTopic(HttpServletRequest httpServletRequest) {
		return lectureTopicService.createTopic(
				httpServletRequest.getParameter("name"),1,
			Integer.parseInt(httpServletRequest.getParameter("disable")),
			Integer.parseInt(httpServletRequest.getParameter("priority"))
		);
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readTopic(HttpServletRequest httpServletRequest) {
		
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
		return lectureTopicService.readTopic(keyword, status);
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateTopic(@RequestBody Map<String,Object> param) throws JsonMappingException, JsonProcessingException {
		
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
			System.out.println("test");
			return;
		}
		
		lectureTopicService.updateTopic(param.get("name").toString(), 
				Integer.parseInt(param.get("id").toString()),
				Integer.parseInt(param.get("status").toString()),
				Integer.parseInt(param.get("disable").toString()),
				Integer.parseInt(param.get("priority").toString())
		);
		//		
//		categoryService.updateCategory(category.getName(), category.getId(), category.getStatus(),category.getDisable() , category.getPriority());
	}
	
	
	@RequestMapping(value = "status", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateStatusTopic(@RequestBody Map<String,Object> param) throws JsonMappingException, JsonProcessingException {
		
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
			System.out.println("test");
			return;
		}
		lectureTopicService.statusTopic(
				Integer.parseInt(param.get("status").toString()),
				Integer.parseInt(param.get("id").toString()));
	}
	
	@RequestMapping(value = "disable", method = RequestMethod.PATCH, produces = "application/json; charset=utf8")
	@ResponseBody
	public void disableTopic(HttpServletRequest httpServletRequest) {
		int disable = Integer.parseInt(httpServletRequest.getParameter("disable"));
		int category_id = Integer.parseInt(httpServletRequest.getParameter("id"));
		
		lectureTopicService.disableTopic(disable, category_id);
	}
	
	
}
