package edu.handong.walab.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.service.AcademyService;
import edu.handong.walab.service.CategoryService;

@Controller
@RequestMapping("/academyDate")
public class SimpleAcademyDateController {
	
	@Autowired
	AcademyService academyService;
	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createAcademyDate(HttpServletRequest httpServletRequest) {
		academyService.create(
			httpServletRequest.getParameter("name"),
			httpServletRequest.getParameter("date"),
			httpServletRequest.getParameter("category_id")
		);
	}
	
	@RequestMapping(value = "category", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createCategory(HttpServletRequest httpServletRequest) {
		categoryService.createCategory(httpServletRequest.getParameter("name"));
	}
	
	@RequestMapping(value = "category", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteCategory(@RequestBody Map<String,Object> param) {
		categoryService.deleteCategory(param.get("id").toString());
		academyService.deleteByCategory(param.get("id").toString());
	}
	
	@RequestMapping(value = "excel", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public void createAcademyDateByExcel(HttpServletRequest httpServletRequest) throws JsonProcessingException {
		System.out.println(httpServletRequest.getParameter("data"));
		String excelJSON = httpServletRequest.getParameter("data");
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> excelData = mapper.readValue(excelJSON, new TypeReference<List<Map<String, Object>>>(){});
		System.out.println(excelJSON);
		for(int i=0 ; i<excelData.size() ; i++) {
			System.out.println(excelData.get(i).get("isValid").toString() + excelData.get(i).get("category_name").toString() + excelData.get(i).get("name").toString());
			if(excelData.get(i).get("isValid").toString().equals("true")) {
				System.out.println("if문 안!");
				String category_id = ""+categoryService.readIdByName(excelData.get(i).get("category_name").toString());				
				academyService.create(
					excelData.get(i).get("name").toString(),
					excelData.get(i).get("date").toString(),
					excelData.get(i).get("category_id").toString()
				);
			}
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readAcademyDate(HttpServletRequest httpServletRequest) {
		String categoryAll = httpServletRequest.getParameter("category");
		String [] category;
		if(categoryAll != null)
			category = categoryAll.split(",");
		else
			category = null;

		return academyService.read(category);
	}
	
	@RequestMapping(value = "previous", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readPreviousYearAcademyDate() {
		return academyService.readPreviousYear();
	}
	
	@RequestMapping(value = "category", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String readCategory() {
		return categoryService.readCategory();
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json; charset=utf8")
	@ResponseBody
	public void updateAcademyDate(@RequestBody Map<String,Object> param) {
		academyService.update(
			Integer.parseInt(param.get("id").toString()),
			param.get("name").toString(),
			param.get("date").toString(),
			param.get("category_id").toString()
		);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json; charset=utf8")
	@ResponseBody
	public void deleteAcademyDate(@RequestBody Map<String,Object> param) {
		academyService.delete(
			Integer.parseInt(param.get("id").toString())
		);
	}
	
}
