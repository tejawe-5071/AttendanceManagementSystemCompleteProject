package com.ams.service;

import java.util.List;

import com.ams.entity.StudentEntity;
import com.ams.exception.RecordNotFoundException;

public interface StudentService {
	public Long add(StudentEntity student);

	public void update(StudentEntity student);

	public void deleteByStudentId(Long studentId) throws RecordNotFoundException;

	public StudentEntity getByStudentId(Long studentId) throws RecordNotFoundException;

	public List<StudentEntity> findByCourseId(Long courseId) throws RecordNotFoundException;
	public List<StudentEntity> findAllStudents() throws RecordNotFoundException;

}
