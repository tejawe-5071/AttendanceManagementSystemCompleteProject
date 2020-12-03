package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ams.queryutil.QueryUtil;
import com.ams.entity.AttendanceEntity;

/*
 * @author SaiDurga
 */
public interface AttendanceDao extends JpaRepository<AttendanceEntity, Long> {

	// Query to find record of student by id
	@Query(QueryUtil.VIEW_STUD_BY_ID)
	public List<AttendanceEntity> findByStudentId(Long studentId);

}
