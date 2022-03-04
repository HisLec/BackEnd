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
@RequestMapping("/test")
public class TestController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String testPage() {
		System.out.println("test 안입니다 ");
		return "home";
	}
}
