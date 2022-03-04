package edu.handong.walab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.Notice;
import edu.handong.walab.repository.NoticeDAO;

@Service
public class SimpleNoticeService implements NoticeService {
	
	@Autowired
	NoticeDAO noticeDAO;

	@Override
	public String readNotice(String keyword) {
		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");
		
		List<Notice> noticeList = noticeDAO.readNotice(keyword);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		
		try {
			jsonString = mapper.writeValueAsString(noticeList);
			
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createNotice(Notice notice) {
		noticeDAO.createNotice(
				notice.getAdministrator_id(),
				notice.getTitle(),
				notice.getContent(),
				notice.getImportant());
	}

	@Override
	public void updateNotice(Notice notice) {
		noticeDAO.updateNotice(
				notice.getId(),
				notice.getAdministrator_id(),
				notice.getTitle(),
				notice.getContent(),
				notice.getImportant(),
				notice.getManageID());
	}

	@Override
	public void deleteNotice(int id, int manageID) {
		noticeDAO.deleteNotice(id, manageID);
	}
	
	
}
