package com.ams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ams.entity.StudentEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.queryutil.ErrorMessageUtil;
import com.ams.repository.StudentDao;

/***
 * 
 * @author puspha
 *
 */
//defining business logic
@Service("studentservice")
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao dao;

	// saving a specific record by using method of save() CrudRepository
	@Override
	public Long add(StudentEntity student) {
		dao.save(student);
		return student.getStudentId();
	}

	// Updating
	@Override
	public void update(StudentEntity student) {
		dao.save(student);

	}

	// deleting a specific record
	@Override
	public void deleteByStudentId(Long studentId) throws RecordNotFoundException {
		if (dao.findById(studentId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		dao.deleteById(studentId);
	}

	// getting a specific record by using getBystudentId() of CrudRepository
	@Override
	public StudentEntity getByStudentId(Long studentId) throws RecordNotFoundException {
		Optional<StudentEntity> student = dao.findById(studentId);
		if (student.isEmpty()) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		return student.get();
	}

	// getting a records by using findByCourseId() of CrudRepository
	@Override
	public List<StudentEntity> findByCourseId(Long courseId) throws RecordNotFoundException {
		if (dao.findByCourseId(courseId) == null) {
			throw new RecordNotFoundException(ErrorMessageUtil.STU_RECORD_NOT_FOUND);
		}
		return dao.findByCourseId(courseId);
	}

	@Override
	public List<StudentEntity> findAllStudents() throws RecordNotFoundException {
		List<StudentEntity> student = new ArrayList<StudentEntity>();

		dao.findAll().forEach(student1 -> student.add(student1));

		return student;
	
	}


}
