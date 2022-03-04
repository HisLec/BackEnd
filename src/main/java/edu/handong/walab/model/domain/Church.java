package edu.handong.walab.model.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Church {
	int id;
	int administrator_id_create;
	int administrator_id_update;
	String name;
	int region_id;
	String nation;
	String city;
	String district;
	String zip_code;
	String addr1;
	String addr2;
	String phone;
	String email;
	String page_url;
	String fax;
	String size;
	String denomination;
	String pastor;
	String admin_name;
	String hgu_yn;
	String hgu_memo;
	String writer_name;
	String memo;
	String creater_name;
	String updater_name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date update_date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date confirm_date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date reg_date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date del_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdministrator_id_create() {
		return administrator_id_create;
	}
	public void setAdministrator_id_create(int administrator_id_create) {
		this.administrator_id_create = administrator_id_create;
	}
	public int getAdministrator_id_update() {
		return administrator_id_update;
	}
	public void setAdministrator_id_update(int administrator_id_update) {
		this.administrator_id_update = administrator_id_update;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPage_url() {
		return page_url;
	}
	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getPastor() {
		return pastor;
	}
	public void setPastor(String pastor) {
		this.pastor = pastor;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getHgu_yn() {
		return hgu_yn;
	}
	public void setHgu_yn(String hgu_yn) {
		this.hgu_yn = hgu_yn;
	}
	public String getHgu_memo() {
		return hgu_memo;
	}
	public void setHgu_memo(String hgu_memo) {
		this.hgu_memo = hgu_memo;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Date getConfirm_date() {
		return confirm_date;
	}
	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public Date getDel_date() {
		return del_date;
	}
	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public String getCreater_name() {
		return creater_name;
	}
	public void setCreater_name(String creater_name) {
		this.creater_name = creater_name;
	}
	public String getUpdater_name() {
		return updater_name;
	}
	public void setUpdater_name(String updater_name) {
		this.updater_name = updater_name;
	}
	@Override
	public String toString() {
		return "Church [id=" + id + ", administrator_id_create=" + administrator_id_create
				+ ", administrator_id_update=" + administrator_id_update + ", name=" + name + ", region_id=" + region_id
				+ ", city=" + city + ", district=" + district + ", zip_code=" + zip_code + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", phone=" + phone + ", email=" + email + ", page_url=" + page_url + ", fax="
				+ fax + ", size=" + size + ", denomination=" + denomination + ", pastor=" + pastor + ", admin_name="
				+ admin_name + ", hgu_yn=" + hgu_yn + ", hgu_memo=" + hgu_memo + ", writer_name=" + writer_name
				+ ", memo=" + memo + ", update_date=" + update_date + ", confirm_date=" + confirm_date + ", reg_date="
				+ reg_date + "]";
	}
	
	
	

}
