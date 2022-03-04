package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Category;
import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.repository.CategoryDAO;

@Service
public class SimpleCategoryService implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public void createCategory(String name) {
		categoryDAO.createCategory(name);
	}
	
	@Override
	public String readCategory() {
		List<Category> category = categoryDAO.readAdminCategory();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(category);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int readIdByName(String name) {
		return categoryDAO.readIdByName(name);
	}

	@Override
	public void disableCategory(int disable, int category_id) {
		categoryDAO.disableCategory(disable, category_id);
	}

	@Override
	public void updateCategory(String name, int id, int status, int disable, int priority) {
		categoryDAO.updateCategory(name, id, status, disable, priority);
	}

	@Override
	public void statusCategory(int status, int category_id) {
		categoryDAO.statusCategory(status, category_id);
	}

	@Override
	public void deleteCategory(String id) {
		categoryDAO.deleteCategory(id);
	}

}
