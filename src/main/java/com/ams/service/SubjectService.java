package com.ams.service;

import java.util.List;

import com.ams.entity.SubjectEntity;
import com.ams.exception.RecordNotFoundException;

/*
 * @author NagaRaj
 */
public interface SubjectService {

	public Long add(SubjectEntity entity);

	public void update(SubjectEntity entity);

	public void deleteBySubjectId(Long subjectId) throws RecordNotFoundException;

	public SubjectEntity getSubjectById(Long subjectId) throws RecordNotFoundException;

	public List<SubjectEntity> findAllSubjects() throws RecordNotFoundException;

}
