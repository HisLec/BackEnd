package edu.handong.walab.model.dto;

public class Phrase {
	String lecture_page_phrase;
	
	String application_page_phrase;
	String application_below_date_phrase;
	String application_list_phrase;
	
	String mypage_profile_phrase;
	String mypage_lecture_phrase;
	String mypage_contact_phrase;
	String mypage_visit_phrase;

	String agree_personal_information_1;
	String agree_personal_information_2;
	String agree_personal_information_3;
	
	
	public Phrase(String lecture_page_phrase, String application_page_phrase, String application_below_date_phrase,
			String application_list_phrase, String mypage_profile_phrase, String mypage_lecture_phrase,
			String mypage_contact_phrase, String mypage_visit_phrase, String agree_personal_information_1,
			String agree_personal_information_2, String agree_personal_information_3) {
		super();
		this.lecture_page_phrase = lecture_page_phrase;
		this.application_page_phrase = application_page_phrase;
		this.application_below_date_phrase = application_below_date_phrase;
		this.application_list_phrase = application_list_phrase;
		this.mypage_profile_phrase = mypage_profile_phrase;
		this.mypage_lecture_phrase = mypage_lecture_phrase;
		this.mypage_contact_phrase = mypage_contact_phrase;
		this.mypage_visit_phrase = mypage_visit_phrase;
		this.agree_personal_information_1 = agree_personal_information_1;
		this.agree_personal_information_2 = agree_personal_information_2;
		this.agree_personal_information_3 = agree_personal_information_3;
	}
	
	public String getLecture_page_phrase() {
		return lecture_page_phrase;
	}
	public void setLecture_page_phrase(String lecture_page_phrase) {
		this.lecture_page_phrase = lecture_page_phrase;
	}
	public String getApplication_page_phrase() {
		return application_page_phrase;
	}
	public void setApplication_page_phrase(String application_page_phrase) {
		this.application_page_phrase = application_page_phrase;
	}
	public String getApplication_below_date_phrase() {
		return application_below_date_phrase;
	}
	public void setApplication_below_date_phrase(String application_below_date_phrase) {
		this.application_below_date_phrase = application_below_date_phrase;
	}
	public String getApplication_list_phrase() {
		return application_list_phrase;
	}
	public void setApplication_list_phrase(String application_list_phrase) {
		this.application_list_phrase = application_list_phrase;
	}
	public String getMypage_profile_phrase() {
		return mypage_profile_phrase;
	}
	public void setMypage_profile_phrase(String mypage_profile_phrase) {
		this.mypage_profile_phrase = mypage_profile_phrase;
	}
	public String getMypage_lecture_phrase() {
		return mypage_lecture_phrase;
	}
	public void setMypage_lecture_phrase(String mypage_lecture_phrase) {
		this.mypage_lecture_phrase = mypage_lecture_phrase;
	}
	public String getMypage_contact_phrase() {
		return mypage_contact_phrase;
	}
	public void setMypage_contact_phrase(String mypage_contact_phrase) {
		this.mypage_contact_phrase = mypage_contact_phrase;
	}
	public String getMypage_visit_phrase() {
		return mypage_visit_phrase;
	}
	public void setMypage_visit_phrase(String mypage_visit_phrase) {
		this.mypage_visit_phrase = mypage_visit_phrase;
	}
	public String getAgree_personal_information_1() {
		return agree_personal_information_1;
	}
	public void setAgree_personal_information_1(String agree_personal_information_1) {
		this.agree_personal_information_1 = agree_personal_information_1;
	}
	public String getAgree_personal_information_2() {
		return agree_personal_information_2;
	}
	public void setAgree_personal_information_2(String agree_personal_information_2) {
		this.agree_personal_information_2 = agree_personal_information_2;
	}
	public String getAgree_personal_information_3() {
		return agree_personal_information_3;
	}
	public void setAgree_personal_information_3(String agree_personal_information_3) {
		this.agree_personal_information_3 = agree_personal_information_3;
	}
}
