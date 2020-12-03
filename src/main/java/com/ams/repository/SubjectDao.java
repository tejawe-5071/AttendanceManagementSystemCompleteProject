package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ams.entity.SubjectEntity;
import com.ams.queryutil.QueryUtil;

/*
 * @author NagaRaju
 */
public interface SubjectDao extends JpaRepository<SubjectEntity, Long> {

	// Query to find record of subject by id
	@Query(QueryUtil.VIEW_SUB_BY_ID)
	public List<SubjectEntity> findBySubjectId(Long subjectId);

}