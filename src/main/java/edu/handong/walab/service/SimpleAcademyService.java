package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.AcademyDate;
import edu.handong.walab.repository.AcademyDateDAO;

@Service
public class SimpleAcademyService implements AcademyService {
	
	@Autowired
	AcademyDateDAO academyDateDAO;
	
	@Override
	public void create(String name, String date, String category_id) {
		academyDateDAO.create(name, date, category_id);
	}

	@Override
	public String read(String [] category) {
		List<AcademyDate> academy;
		
		if(category != null) {
			int [] categoryId = new int[category.length];
			for(int i=0 ; i<category.length ; i++) {
				categoryId[i] = Integer.parseInt(category[i]);
			}
			academy = academyDateDAO.read(categoryId);
		} else {
			academy = academyDateDAO.read(null);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(academy);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(int id, String name, String date, String category_id) {
		academyDateDAO.update(id, name, date, category_id);
	}

	@Override
	public void delete(int id) {
		academyDateDAO.delete(id);
	}

	@Override
	public String readPreviousYear() {
		List<AcademyDate> academy = academyDateDAO.readpreviousYear();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(academy);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByCategory(String category_id) {
		academyDateDAO.deleteByCategory(category_id);
	}

}
