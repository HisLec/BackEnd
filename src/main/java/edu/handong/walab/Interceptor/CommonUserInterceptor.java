package edu.handong.walab.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.User;
import edu.handong.walab.repository.UserDAO;

public class CommonUserInterceptor  extends HandlerInterceptorAdapter{
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod() == "POST") {
			String token = request.getParameter("token");
			System.out.println(request.getRequestURI());
			System.out.println(request.getPathInfo());
			int id = Integer.parseInt(request.getParameter("manageID"));
			
			RestTemplate restTemplate = new RestTemplate();
			String requestUrl;
			try{
				requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
						.queryParam("id_token", token).build().toUriString();
			}catch (Exception e){
			    return false;
			}
			
			String resultJson = restTemplate.getForObject(requestUrl, String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
			
			User user = userDAO.getUserByEmail(userInfo.get("email"));
			if(id != user.getId()) {
				return false;
			}
		}
		
		return super.preHandle(request, response, handler);
	}

}
