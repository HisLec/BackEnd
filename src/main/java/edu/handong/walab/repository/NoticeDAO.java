package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Notice;

public interface NoticeDAO {

	List<Notice> readNotice(String keyword);

	void createNotice(int administrator_id, String title, String content, int important);

	void updateNotice(int id, int administrator_id, String title, String content, int important, int manageID);

	void deleteNotice(int id, int manageID);

}
