package com.ams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ams.repository.CourseDao;
import com.ams.entity.CourseEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.queryutil.ErrorMessageUtil;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(CourseEntity courseEntity) {
		courseDao.save(courseEntity);
		return courseEntity.getCourseId();
	}

	// updating a record
	@Override
	public void update(CourseEntity courseEntity) throws RecordNotFoundException {
		if (courseDao.findById(courseEntity.getCourseId()) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.ENTITY_NOT_FOUND);
		}
		courseDao.save(courseEntity);

	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	@Override
	public void deleteByCourseId(Long courseId) throws RecordNotFoundException {
		if (courseDao.findById(courseId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		courseDao.deleteById(courseId);
	}

	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public CourseEntity getCourseById(Long courseId) throws RecordNotFoundException {
		Optional<CourseEntity> course = courseDao.findById(courseId);
		if (course.isEmpty()) {
			throw new RecordNotFoundException(ErrorMessageUtil.ATT_RECORD_NOT_FOUND);
		}
		return course.get();
	}

	// getting all attendance records by using the method findAll() ofCrudRepository
	@Override
	public List<CourseEntity> findAllCourse() throws RecordNotFoundException {
		List<CourseEntity> course = new ArrayList<CourseEntity>();
		courseDao.findAll().forEach(course1 -> course.add((CourseEntity) course1));
		return course;
	}

}
