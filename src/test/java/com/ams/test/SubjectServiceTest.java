package com.ams.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ams.entity.SubjectEntity;
import com.ams.repository.SubjectDao;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.SubjectServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SubjectServiceTest {
	@InjectMocks
	private SubjectServiceImpl subjectService;
	@Mock
	private SubjectDao subjectDao;
	
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void addSubjectTest() {
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setCourseId((long) 111);
		subjectEntity.setCourseName("Cse");
	    subjectEntity.setSemester("VII");
		subjectEntity.setName("Nagaraj");
		subjectEntity.setSubjectId((long) 1695);
		subjectEntity.setSubjectCode("16UECS01");
		
		when(subjectDao.save(subjectEntity)).thenReturn(subjectEntity);
		
		Long subjectId = subjectService.add(subjectEntity);
		
		assertEquals("Nagaraj", subjectEntity.getName());
		verify(subjectDao, times(1)).save(subjectEntity);
	}
	
	@Test
	public void updateSubjectTest() throws RecordNotFoundException {
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setCourseId((long) 111);
		subjectEntity.setCourseName("Cse");
		subjectEntity.setSemester("VII");
		subjectEntity.setName("Naga");
		subjectEntity.setSubjectId((long) 1695);
		subjectEntity.setSubjectCode("16uecs01");
		
		Long subjectId = subjectEntity.getSubjectId();
		Optional<SubjectEntity> subjectEntity1 = subjectDao.findById(subjectId);
		
		when(subjectDao.findById(subjectId)).thenReturn(subjectEntity1);
		when(subjectDao.save(subjectEntity)).thenReturn(subjectEntity);
		
		subjectEntity.setCourseId((long) 112);;
		
		subjectService.update(subjectEntity);;
		
		assertEquals(112, subjectEntity.getCourseId());
		verify(subjectDao, times(1)).save(subjectEntity);
	}
	
	@Test
	public void viewSubjectTest() throws RecordNotFoundException {
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setCourseId((long) 111);
		subjectEntity.setCourseName("Cse");
		subjectEntity.setSemester("VII");
		subjectEntity.setName("Naga");
		subjectEntity.setSubjectId((long) 1695);
	    subjectEntity.setSubjectCode("16uecs01");
		Long subjectId = subjectEntity.getSubjectId();
		Optional<SubjectEntity> subject = Optional.of(subjectEntity);
		when(subjectDao.findById(subjectId)).thenReturn(subject);
		
		SubjectEntity viewSubject = subjectService.getSubjectById(subjectId);
		
		assertEquals("Cse", viewSubject.getCourseName());;
		verify(subjectDao, times(2)).findById(subjectId);
	}
	
	@Test
	public void viewSubjectListTest() throws RecordNotFoundException {
		List<SubjectEntity> subjectList = new ArrayList<SubjectEntity>();
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setCourseId((long) 111);
		subjectEntity.setCourseName("Cse");
		subjectEntity.setSemester("VII");
		subjectEntity.setName("Naga");
		subjectEntity.setSubjectId((long) 1695);
		subjectEntity.setSubjectCode("16uecs01");
		
		
		SubjectEntity subjectEntity1 = new SubjectEntity();
		subjectEntity1.setCourseId((long) 1112);
		subjectEntity1.setCourseName("It");
		subjectEntity1.setSemester("VII");
		subjectEntity1.setName("Raj");
		subjectEntity1.setSubjectId((long) 1696);
		subjectEntity1.setSubjectCode("16uecs01");
		subjectList.add(subjectEntity);
		subjectList.add(subjectEntity1);
	
		when(subjectDao.findAll()).thenReturn(subjectList);
		
		List<SubjectEntity> subjectList2 = subjectService.findAllSubjects();
		
		assertEquals(2, subjectList2.size());
		verify(subjectDao, times(1)).findAll();
	}

}