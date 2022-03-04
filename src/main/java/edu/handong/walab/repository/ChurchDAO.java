package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Church;

public interface ChurchDAO {

	void createChurch(int administrator_id_create, int administrator_id_update, String name, int region_id, String city,
			String district, String zip_code, String addr1, String addr2, String phone, String email, String page_url);

	int getLastId();

	Church readChurchById(int church_id);

	void updateChurch(int administrator_id_update, int id, String name, String city, String district, String zip_code,
			String addr1, String addr2, String pastor, String email, String phone);

	List<Church> readChurch(String keyword);

	int createChurch(int user_id, String name, int region_id, String nation, String city, String district, String zip_code,
			String addr1, String addr2, String phone, String email, String page_url, String fax, String size,
			String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo, String writer_name,
			String memo);

	void updateChurch(int church_id, int user_id, String name, int region_id, String nation, String city, String district,
			String zip_code, String addr1, String addr2, String phone, String email, String page_url, String fax,
			String size, String denomination, String pastor, String admin_name, String hgu_yn, String hgu_memo,
			String writer_name, String memo);

	void deleteChurch(int church_id);

	void recoverChurch(int church_id);
}
