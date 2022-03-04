package edu.handong.walab.service;

public interface CategoryService {

	String readCategory();

	void disableCategory(int disable, int category_id);

	void updateCategory(String name, int id, int status, int disable, int priority);

	void statusCategory(int status, int category_id);

	void createCategory(String name);

	int readIdByName(String name);

	void deleteCategory(String string);

}
