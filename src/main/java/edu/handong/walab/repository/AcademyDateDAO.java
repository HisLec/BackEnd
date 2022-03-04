package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.AcademyDate;

public interface AcademyDateDAO {

	void create(String name, String date, String category_id);

	List<AcademyDate> read(int[] categoryId);

	void update(int id, String name, String date, String category_id);

	void delete(int id);

	List<AcademyDate> readpreviousYear();

	void deleteByCategory(String category_id);

}
