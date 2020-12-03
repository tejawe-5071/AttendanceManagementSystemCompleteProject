package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.entity.AssignFacultyEntity;
import com.ams.queryutil.QueryUtil;

public interface AssignFacultyDao extends JpaRepository<AssignFacultyEntity , Long> {
	
	
	// Query to find record of faculty by id
		@Query(QueryUtil.VIEW_FACU_BY_ID) 
		public List<AssignFacultyEntity> findBySubjectId(Long subjectId);
	
}
