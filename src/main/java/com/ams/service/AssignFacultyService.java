package com.ams.service;

import java.util.List;
import com.ams.entity.AssignFacultyEntity;
import com.ams.exception.RecordNotFoundException;


public interface AssignFacultyService {

	public Long add(AssignFacultyEntity entity);

	public void update(AssignFacultyEntity entity) throws RecordNotFoundException;

	public void deleteByFacultyId(Long facultyId) throws RecordNotFoundException;

	public List<AssignFacultyEntity> findBySubjectId(Long facultyId) throws RecordNotFoundException;

	public AssignFacultyEntity getFacultyById(Long facultyId) throws RecordNotFoundException;

	public List<AssignFacultyEntity> findAllFaculty() throws RecordNotFoundException;
	
}
