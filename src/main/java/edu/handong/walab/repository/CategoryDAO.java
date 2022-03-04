package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Category;

public interface CategoryDAO {

	List<Category> readAdminCategory();

	void disableCategory(int disable, int category_id);

	void updateCategory(String name, int id, int status, int disable, int priority);

	void statusCategory(int status, int category_id);

	void createCategory(String name);

	int readIdByName(String name);

	void deleteCategory(String id);

}
