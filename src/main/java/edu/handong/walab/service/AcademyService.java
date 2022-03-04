package edu.handong.walab.service;

public interface AcademyService {

	void create(String name, String date, String category_id);

	String read(String[] category);

	void update(int id, String name, String date, String category_id);

	void delete(int id);

	String readPreviousYear();

	void deleteByCategory(String string);

}
