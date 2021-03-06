package edu.handong.walab.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;

@Controller
@RequestMapping("/administrator")
public class SimpleAdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readData(HttpServletRequest httpServletRequest) throws IOException, ParseException {
		
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
	    return adminService.readAdminByKeyword(keyword);
	}
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readDataByUserId(HttpServletRequest httpServletRequest, @PathVariable int id) throws IOException, ParseException {
		return adminService.readAdminByUserId(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public String patchEmailYN(@PathVariable int id, @RequestBody Map<String,Object> param) throws IOException, ParseException {
		int editValue = Integer.parseInt(param.get("editValue").toString());
		adminService.patchEmailYN(id, editValue);
		return "success";
	}
	
	@RequestMapping(value = "del_date/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteAdministrator(@RequestBody Map<String,Object> param, @PathVariable int id) {
		String email = param.get("email").toString();
		adminService.delete(id, email);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String addAdministrator(HttpServletRequest httpServletRequest) {
		Administrator admin = new Administrator();
		admin.setEmail(httpServletRequest.getParameter("email"));
		admin.setName(httpServletRequest.getParameter("name"));
		admin.setPhone(httpServletRequest.getParameter("phone"));
		admin.setEmailYN(Integer.parseInt(httpServletRequest.getParameter("email_yn")));
		String result = adminService.add(admin);
		return result;
	}
	
}
