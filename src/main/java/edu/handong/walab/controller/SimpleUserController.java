package edu.handong.walab.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
import edu.handong.walab.service.UserService;


@Controller
@RequestMapping("/user")
public class SimpleUserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String login(HttpServletRequest httpServletRequest) throws IOException, ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		
		String token = httpServletRequest.getParameter("token");
		String email = httpServletRequest.getParameter("email");
		Date expire_token = new Date(Long.parseLong((httpServletRequest.getParameter("expire"))));
		
		RestTemplate restTemplate = new RestTemplate();
		String requestUrl;
		try{
			requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
					.queryParam("id_token", token).build().toUriString();
		}catch (Exception e){
		    return "fail";
		}
		
		String resultJson = restTemplate.getForObject(requestUrl, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
		
		if(email.equals(userInfo.get("email"))) {
			return userService.setUserTokenJsonData(email, token, expire_token);
		}else {
			return "fail";
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String logout(HttpServletRequest httpServletRequest) throws IOException, ParseException {
		
		String email = httpServletRequest.getParameter("email");
		
	    return userService.deleteUserToken(email);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAllUser(HttpServletRequest httpServletRequest) throws IOException, ParseException {
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    return userService.readAllUser(keyword);
	}
	
	
	@RequestMapping(value = "/status", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateUserStatus(@RequestBody Map<String,Object> param) throws JsonMappingException, JsonProcessingException {
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
		
		userService.updateUserStatus(
				Integer.parseInt(param.get("status").toString()),
				Integer.parseInt(param.get("id").toString()));
	}
}
