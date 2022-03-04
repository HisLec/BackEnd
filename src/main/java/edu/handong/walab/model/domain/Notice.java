package edu.handong.walab.model.domain;

public class Notice {
	int id;
	String admin_name;
	int administrator_id;
	String title;
	String content;
	int important;
	String reg_date;
	String del_date;
	String token;
	int manageID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public int getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(int administrator_id) {
		this.administrator_id = administrator_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImportant() {
		return important;
	}
	public void setImportant(int important) {
		this.important = important;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getDel_date() {
		return del_date;
	}
	public void setDel_date(String del_date) {
		this.del_date = del_date;
	}
	
	public int getManageID() {
		return manageID;
	}
	public void setManageID(int manageID) {
		this.manageID = manageID;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", admin_name=" + admin_name + ", administrator_id=" + administrator_id + ", title="
				+ title + ", content=" + content + ", important=" + important + ", reg_date=" + reg_date + ", del_date="
				+ del_date + ", manageID=" + manageID + "]";
	}
	
}
