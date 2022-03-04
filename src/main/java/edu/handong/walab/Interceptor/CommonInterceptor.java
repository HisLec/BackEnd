package edu.handong.walab.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter("token");
		System.out.println(request.getRequestURI());
		System.out.println(request.getPathInfo());
		if(token != null){		
			System.out.println("token != null");
			RestTemplate restTemplate = new RestTemplate();
			String requestUrl;
			try{
				requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
						.queryParam("id_token", token).build().toUriString();
			}catch (Exception e){
			    return false;
			}
			
			System.out.println(requestUrl);
			
			String resultJson = restTemplate.getForObject(requestUrl, String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
			
			HttpSession session = request.getSession();
			
			System.out.println(userInfo.get("email"));
		}else {
			System.out.println("token is null");
//			if(request.getMethod() != "GET") {
//				return false;
//			}
			System.out.println(request.getMethod());
			//return false; //test 후 변경 예정!
		}
//		UserDTO ud = new UserDTO();
//		ud.setEmail(userInfo.get("email"));
//		ud.setName(userInfo.get("name"));
//		session.setAttribute("tempUser", ud);
//		session.setAttribute("token", result.getAccessToken());
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("in postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
}
