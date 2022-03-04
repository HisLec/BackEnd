package edu.handong.walab.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Church;
import edu.handong.walab.model.domain.ChurchTemp;
import edu.handong.walab.model.dto.Administrator;
import edu.handong.walab.service.AdminService;
import edu.handong.walab.service.ApplicationService;
import edu.handong.walab.service.ChurchService;
import edu.handong.walab.service.ChurchTempService;
import edu.handong.walab.service.UserService;

@Controller
@RequestMapping("/church")
public class SimpleChurchController {
	
	@Autowired
	ChurchService churchService;
	@Autowired
	ChurchTempService churchTempService;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createChurch(HttpServletRequest httpServletRequest) {
		int user_id = Integer.parseInt(httpServletRequest.getParameter("userId").toString());
		Administrator admin = adminService.readAdminInfoByUserID(user_id);
		churchService.createChurch(
				admin.getId(),
				httpServletRequest.getParameter("name"),
				0,
				httpServletRequest.getParameter("nation"),
				httpServletRequest.getParameter("city"),
				httpServletRequest.getParameter("district"),
				httpServletRequest.getParameter("zip_code"),
				httpServletRequest.getParameter("addr1"),
				httpServletRequest.getParameter("addr2"),
				httpServletRequest.getParameter("phone"),
				httpServletRequest.getParameter("email"),
				httpServletRequest.getParameter("page_url"),
				httpServletRequest.getParameter("fax"),
				httpServletRequest.getParameter("size"),
				httpServletRequest.getParameter("denomination"),
				httpServletRequest.getParameter("pastor"),
				httpServletRequest.getParameter("admin_name"),
				httpServletRequest.getParameter("hgu_yn"),
				httpServletRequest.getParameter("hgu_memo"),
				admin.getName(),
				httpServletRequest.getParameter("memo"));
	}

	
	@RequestMapping(value = "excel/{userId}", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createChurchByExcel(@PathVariable int userId, HttpServletRequest httpServletRequest) throws JsonMappingException, JsonProcessingException {
		String excelJSON = httpServletRequest.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> excelData = mapper.readValue(excelJSON, new TypeReference<List<Map<String, Object>>>(){});
		
		Administrator admin = adminService.readAdminInfoByUserID(userId);
		for(int i=0 ; i<excelData.size() ; i++) {
			if(excelData.get(i).get("isValid").toString().equals("true")) {
				churchService.createChurch(
				admin.getId(),
				excelData.get(i).get("name").toString(),
				0,
				excelData.get(i).get("nation").toString(),
				excelData.get(i).get("city").toString(),
				excelData.get(i).get("district").toString(),
				excelData.get(i).get("zip_code").toString(),
				excelData.get(i).get("addr1").toString(),
				excelData.get(i).get("addr2").toString(),
				excelData.get(i).get("phone").toString(),
				excelData.get(i).get("email").toString(),
				excelData.get(i).get("page_url").toString(),
				excelData.get(i).get("fax").toString(),
				excelData.get(i).get("size").toString(),
				excelData.get(i).get("denomination").toString(),
				excelData.get(i).get("pastor").toString(),
				excelData.get(i).get("admin_name").toString(),
				excelData.get(i).get("hgu_yn").toString(),
				excelData.get(i).get("hgu_memo").toString(),
				admin.getName(),
				excelData.get(i).get("memo").toString());
			}
		}
	}
	
	@RequestMapping(value = "temp", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createNewChurch(HttpServletRequest httpServletRequest) {
		int user_id = Integer.parseInt(httpServletRequest.getParameter("userId"));
		Administrator admin = adminService.readAdminInfoByUserID(user_id);
		churchService.createChurch(
				admin.getId(),
				httpServletRequest.getParameter("name").toString(),
				0,
				"대한민국",
				httpServletRequest.getParameter("city").toString(),
				httpServletRequest.getParameter("district").toString(),
				httpServletRequest.getParameter("zip_code").toString(),
				httpServletRequest.getParameter("addr1").toString(),
				httpServletRequest.getParameter("addr2").toString(),
				httpServletRequest.getParameter("phone").toString(),
				httpServletRequest.getParameter("email").toString(),
				"","","","",
				httpServletRequest.getParameter("pastor").toString(),"","","",
				httpServletRequest.getParameter("writer_name").toString(),
				"");
		int church_id = churchService.getLastId();
		applicationService.updateChurchId(httpServletRequest.getParameter("application_form_id").toString(), church_id);
		churchTempService.deleteChurchTemp(httpServletRequest.getParameter("id").toString());
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readChurch(HttpServletRequest httpServletRequest) {
		
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return churchService.readChurch(keyword);
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readChurchUser(HttpServletRequest httpServletRequest) {
		
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return churchService.readChurch(keyword);
	}
	
	@RequestMapping(value = "churchId/{user_id}", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateChurch(@RequestBody Church church, @PathVariable int user_id) {
		
		Administrator admin = adminService.readAdminInfoByUserID(user_id);
		
		churchService.updateChurch(
				church.getId(), 
				admin.getId(),
				church.getName(),
				church.getRegion_id(),
				church.getNation(),
				church.getCity(),
				church.getDistrict(),
				church.getZip_code(),
				church.getAddr1(),
				church.getAddr2(),
				church.getPhone(),
				church.getEmail(),
				church.getPage_url(),
				church.getFax(),
				church.getSize(),
				church.getDenomination(),
				church.getPastor(),
				church.getAdmin_name(),
				church.getHgu_yn(),
				church.getHgu_memo(),
				church.getWriter_name(),
				church.getMemo());	
	}
	
	
	@RequestMapping(value = "confirmChurchTemp", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public String confirmChurchTemp(HttpServletRequest httpServletRequest) {
		
		Administrator admin = adminService.readAdminInfoByUserID(Integer.parseInt(httpServletRequest.getParameter("user_id").toString()));
		int administrator_id_update = admin.getId(); // user_id
		int id = Integer.parseInt(httpServletRequest.getParameter("id").toString());
		ChurchTemp church = churchTempService.readChurchTempById(id);
		
		churchService.updateChurch(
				administrator_id_update, 
				church.getChurch_id(), 
				httpServletRequest.getParameter("new_name").toString(), 
				httpServletRequest.getParameter("new_city").toString(), 
				httpServletRequest.getParameter("new_district").toString(), 
				httpServletRequest.getParameter("new_zip_code").toString(), 
				httpServletRequest.getParameter("new_addr1").toString(), 
				httpServletRequest.getParameter("new_addr2").toString(),
				httpServletRequest.getParameter("new_pastor").toString(),
				httpServletRequest.getParameter("new_email").toString(),
				httpServletRequest.getParameter("new_phone").toString());
		churchTempService.deleteChurchTemp(httpServletRequest.getParameter("id").toString());
		
		return "success";
	}
	
	@RequestMapping(value = "temp", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public String deleteChurchTemp(@RequestBody Map<String,Object> param) {		
		if(Integer.parseInt(param.get("church_id").toString()) == 0) {
			applicationService.updateStatus(Integer.parseInt(param.get("application_form_id").toString()), -1);
		}
		churchTempService.rejectChurchTemp(Integer.parseInt(param.get("id").toString()));
		return "success";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteChurch(@RequestBody Map<String,Object> param) {
		churchService.deleteChurch(Integer.parseInt(param.get("church_id").toString()));
	}
	
	@RequestMapping(value = "recover", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void recoverChurch(@RequestBody Map<String,Object> param) {
		churchService.recoverChurch(Integer.parseInt(param.get("church_id").toString()));
	}
	
	@RequestMapping(value = "temp", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readChurchTemp(HttpServletRequest httpServletRequest) throws JsonProcessingException {
		
		String keyword = null;
		try {
			if(httpServletRequest.getParameter("keyword") != null) {
				keyword = URLDecoder.decode(httpServletRequest.getParameter("keyword"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return churchTempService.readAllChurchTempJsonData(keyword);
	}
	
}
