package edu.handong.walab.model.dto;

public class StatByLecture {
	int all_lecture;
	int finish_lecture;
	int not_finish_lecture;
	int inst_count;
	int church_count;
	public int getAll_lecture() {
		return all_lecture;
	}
	public void setAll_lecture(int all_lecture) {
		this.all_lecture = all_lecture;
	}
	public int getFinish_lecture() {
		return finish_lecture;
	}
	public void setFinish_lecture(int finish_lecture) {
		this.finish_lecture = finish_lecture;
	}
	public int getNot_finish_lecture() {
		return not_finish_lecture;
	}
	public void setNot_finish_lecture(int not_finish_lecture) {
		this.not_finish_lecture = not_finish_lecture;
	}
	public int getInst_count() {
		return inst_count;
	}
	public void setInst_count(int inst_count) {
		this.inst_count = inst_count;
	}
	public int getChurch_count() {
		return church_count;
	}
	public void setChurch_count(int church_count) {
		this.church_count = church_count;
	}
}
