package com.ams.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ams.entity.StudentEntity;
import com.ams.queryutil.QueryUtil;

public interface StudentDao extends JpaRepository<StudentEntity,Long> {
	// Query to find record of student by rollNo
	@Query(QueryUtil.VIEW_STUD_BY_ROLLNO)
	public StudentEntity findByRollNo(Long rollNo);

	// Query to find record of student by courseId
	@Query(QueryUtil.VIEW_STUD_BY_COURSEID)
	public List<StudentEntity> findByCourseId(Long courseId);

	// Query to delete a record of student using id
	@Query(QueryUtil.DEL_STD_BY_ID)
	@Transactional
	@Modifying
	public void deleteByStudentId(Long StudentId);

}
