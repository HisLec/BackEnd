package edu.handong.walab.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.handong.walab.model.domain.Notice;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.NoticeService;


@Controller
@RequestMapping("/notice")
public class SimpleNoticeController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readNotice(HttpServletRequest httpServletRequest) {
		String keyword = httpServletRequest.getParameter("keyword");
		return noticeService.readNotice(keyword);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createNotice(@RequestBody Notice notice) throws NumberFormatException, JsonProcessingException {
		System.out.println("POST IN");
		int adminID = adminService.readAdminInfoByUserID(notice.getManageID()).getId();
		if(adminID == notice.getAdministrator_id())
			noticeService.createNotice(notice);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateNotice(@RequestBody Notice notice) {
		int adminID = adminService.readAdminInfoByUserID(notice.getManageID()).getId();
		if(adminID == notice.getAdministrator_id())
			noticeService.updateNotice(notice);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteNotice(@RequestBody Map<String,Object> param) {
		int id = Integer.parseInt(param.get("notice_id").toString());
		int manageID = adminService.readAdminInfoByUserID(Integer.parseInt(param.get("manageID").toString())).getId(); 
		noticeService.deleteNotice(id, manageID);
	}
	
	

}
