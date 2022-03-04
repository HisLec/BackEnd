package edu.handong.walab.model.domain;

import java.util.Date;

public class Setting {
	String key;
	String value;
	String memo;
	Date reg_date;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "Setting [key=" + key + ", value=" + value + ", memo=" + memo + ", reg_date=" + reg_date + "]";
	}
	
}
