package edu.handong.walab.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.handong.walab.model.domain.ApplicationForm;
import edu.handong.walab.model.domain.ContactApplication;
import edu.handong.walab.model.domain.LectureDate;
import edu.handong.walab.model.dto.ApplicationWithFeedback;
import edu.handong.walab.model.dto.StatAllData;
import edu.handong.walab.repository.AdminDAO;
import edu.handong.walab.repository.ApplicationDAO;
import edu.handong.walab.repository.LectureDateDAO;

@Service
public class SimpleApplicationService implements ApplicationService {

	@Autowired
	ApplicationDAO applicationDAO;

	@Autowired
	LectureDateDAO lectureDateDAO;

	@Autowired
	AdminDAO adminDAO;

	@Value("${smtp.email}")
	String smtpEmail;
	@Value("${smtp.password}")
	String smtpPassword;

	@Override
//	application form read
	public String read(int instructor_id) {
		// TODO Auto-generated method stub
		List<ContactApplication> forms = applicationDAO.read(instructor_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readAll(String keyword, String status) {
		int statusValue = -2;

		if(keyword != null) {
			keyword = "%".concat(keyword).concat("%");
		}else {
			keyword = "%%";
		}

		if(status != null) {
			statusValue = Integer.parseInt(status);
		}

		List<ContactApplication> forms = applicationDAO.readAll(keyword, statusValue);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String completeContact(int application_form_id, String selectDate, int lecture_id, String contact_start_date, String contact_end_date, String contact_memo, int status) {
		List<LectureDate> lectureDate = lectureDateDAO.readByLectureId(lecture_id);
		int check = 0;
		int lecture_date_id = 0;

		for(int i=0 ; i<lectureDate.size() ; i++) {
			if(lectureDate.get(i).getDate().equals(selectDate)) {
				lecture_date_id = lectureDate.get(i).getId();
				check = 1;
				break;
			}
		}

		if(check == 0) {
			lectureDateDAO.insertDate(lecture_id, selectDate);
			lecture_date_id = lectureDateDAO.readLastId();
		}
		applicationDAO.updateApplication(application_form_id, contact_start_date, contact_end_date, contact_memo, lecture_date_id, status);
		return null;
	}

	@Override
	public void createApplication(int user_id, int lecture_id, int lecture_date_id, int church_id,
			String memo, String admin_phone, String admin_name, String admin_email, int attendee_number, String attendee_target, String timezone) {
		
		applicationDAO.createApplication(user_id, lecture_id, lecture_date_id, church_id, memo, admin_phone, admin_name, admin_email, attendee_number, attendee_target, timezone);
	}

	public void writeEmail(String instEmail, String date, String subject, String church, String link) {
		List<String> email = adminDAO.readEmailByemailYN();
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, null);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(smtpEmail));
			for(String mail: email) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			}
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(instEmail));
			
			
			message.setSubject("[비전특강] 새로운 신청서가 등록되었습니다. ("+date+")");

			message.setText("새로운 신청서가 등록되었습니다.\n\n" + 
					"연락처를 확인하셔서 신청자에게 연락해주세요.\n\n\n" + 
					"(※ 신청자는 교수님의 연락처를 알수없기때문에, \n\n" + 
					"    교수님께서 먼저 연락해주셔야 합니다.)\n\n\n" + 
					"▷강의일자:"+date+"\n\n" + 
					"▷강의주제:"+subject+"\n\n" + 
					"▷신청교회명:"+church+"\n\n\n" + 
					"연락처 확인하러가기("+link+")\n\n\n" + 
					"※반드시 연락처를 확인 후 강의 진행여부(수락 또는 취소)를 확정하여 주세요.\n");

			Transport.send(message, smtpEmail, smtpPassword);

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getLastId() {
		return applicationDAO.getLastId();
	}

	@Override
	public String updateStatus(int application_form_id, int status) {
		String result = applicationDAO.updateStatus(application_form_id, status);
		return result;
	}

	@Override
	public String readApplicationForVisitingLog(int instructor_id) {
		List<ApplicationWithFeedback> forms = applicationDAO.readApplicationForVisitingLog(instructor_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readAllApplicationForVisitingLog(String keyword) {

		if(keyword != null)
			keyword = "%".concat(keyword).concat("%");

		List<ApplicationWithFeedback> forms = applicationDAO.readAllApplicationForVisitingLog(keyword);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readApplicationForFeedback(int user_id) {
		List<ApplicationWithFeedback> forms = applicationDAO.readApplicationForFeedback(user_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readContactedApplicationForFeedback(int user_id) {
		List<ApplicationWithFeedback> forms = applicationDAO.readContactedApplicationForFeedback(user_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String readAllApplicationForFeedback(String keyword) {
		if(keyword != null) {
			keyword = "%".concat(keyword).concat("%");
		}
		List<ApplicationWithFeedback> forms = applicationDAO.readAllApplicationForFeedback(keyword);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateChurchId(String application_form_id, int church_id) {
		applicationDAO.updateChurchId(application_form_id, church_id);
	}

	@Override
	public String statisticsBasedOnReligiousBody(String period) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(applicationDAO.statisticsBasedOnReligiousBody(period));

			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String statisticsBasedOnRegion(String period) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(applicationDAO.statisticsBasedOnRegion(period));

			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String statisticsBasedOnInstructor(String period) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(applicationDAO.statisticsBasedOnInstructor(period));

			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void cancelNotFinishByInstructor(int instructor_id) {
		applicationDAO.cancelNotFinishByInstructor(instructor_id);
	}

	@Override
	public void cancelFinishByInstructor(int instructor_id) {
		applicationDAO.cancelFinishByInstructor(instructor_id);
	}

	@Override
	public void cancelNotFinishByLecture(int lecture_id) {
		applicationDAO.cancelNotFinishByLecture(lecture_id);
	}

	@Override
	public void cancelFinishByLecture(int lecture_id) {
		applicationDAO.cancelFinishByLecture(lecture_id);
	}

	@Override
	public String readStatAllData() {
		List<StatAllData> forms = applicationDAO.readStatAllData();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = mapper.writeValueAsString(forms);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ApplicationForm readByUserID(int userID) {
		return applicationDAO.readByUserID(userID);
	}

	@Override
	public ApplicationForm readByID(int application_form_id) {
		return applicationDAO.readByID(application_form_id);
	}
}
