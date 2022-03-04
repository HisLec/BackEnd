package edu.handong.walab.repository;

import java.util.List;

import edu.handong.walab.model.domain.Region;
import edu.handong.walab.model.dto.LectureTopicInfo;

public interface LectureRegionDAO {
	
	public void insertLectureRegion(int lectureId, int[]regionId);

	List<Region> getLectureRegion();

	public List<LectureTopicInfo> getLectureRegionByLectureId(int lectureId);

	public void deleteByLectureId(String id);

	public void createLectureRegion(String id, int region_id);
}
