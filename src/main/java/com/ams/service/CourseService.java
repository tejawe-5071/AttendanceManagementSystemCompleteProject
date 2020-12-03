package com.ams.service;

import java.util.List;

import com.ams.entity.CourseEntity;
import com.ams.exception.RecordNotFoundException;
/*
 * @author SaiDurga
 */
public interface CourseService {

	public Long add(CourseEntity entity);

	public void update(CourseEntity  entity) throws RecordNotFoundException;

	public void deleteByCourseId(Long id) throws RecordNotFoundException;

	public CourseEntity getCourseById(Long courseId) throws RecordNotFoundException;

	public List<CourseEntity > findAllCourse() throws RecordNotFoundException;
	

}
