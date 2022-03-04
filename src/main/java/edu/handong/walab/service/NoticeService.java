package edu.handong.walab.service;

import edu.handong.walab.model.domain.Notice;

public interface NoticeService {

	String readNotice(String keyword);

	void createNotice(Notice notice);

	void updateNotice(Notice notice);

	void deleteNotice(int id, int manageID);

}
