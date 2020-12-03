package com.ams.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.ResponseEntity;

import com.ams.entity.SubjectEntity;
import com.ams.repository.SubjectDao;
import com.ams.controller.SubjectController;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.SubjectServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SubjectControllerTest {
	@InjectMocks
	private SubjectController subjectController;
	@Mock
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
		subjectEntity.setSubjectCode("16uecs01");
		
		when(subjectDao.save(subjectEntity)).thenReturn(subjectEntity);
		
		Long subjectId = subjectController.create(subjectEntity);
		
		assertEquals("Nagaraj", subjectEntity.getName());
	}
	
	@Test
	public void updateSubjectTest() throws RecordNotFoundException {
		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setCourseId((long) 111);
		subjectEntity.setCourseName("IT");
		subjectEntity.setSemester("VII");
		subjectEntity.setName("Naga");
		subjectEntity.setSubjectId((long) 1695);
		subjectEntity.setSubjectCode("16uecs01");
		
		Long subjectId = subjectEntity.getSubjectId();
		Optional<SubjectEntity> subjectEntity1 = subjectDao.findById(subjectId);
		
		when(subjectDao.findById(subjectId)).thenReturn(subjectEntity1);
		when(subjectDao.save(subjectEntity)).thenReturn(subjectEntity);
		
		subjectEntity.setCourseId((long) 112);;
		
		subjectController.update(subjectEntity);
		
		assertEquals(112, subjectEntity.getCourseId());
	}
	@Test
	public void viewSubjectByIdTest() throws RecordNotFoundException {
			SubjectEntity subjectEntity = new SubjectEntity();
			subjectEntity.setCourseId((long) 111);
			subjectEntity.setCourseName("Ece");
			subjectEntity.setSemester("VIII");
			subjectEntity.setName("Teja");
			subjectEntity.setSubjectId((long) 1695);
			subjectEntity.setSubjectCode("16uecs02");
			Long subjectId = subjectEntity.getSubjectId();
			when(subjectController.getSubjectById(subjectId).getBody()).thenReturn(subjectEntity);
			ResponseEntity<SubjectEntity> viewSubject = subjectController.getSubjectById(subjectId);
			assertEquals(111, viewSubject.getBody().getCourseId());

		}
	
@Test
public void viewSubjectListTest() throws RecordNotFoundException {
	List<SubjectEntity> subjectList = new ArrayList<SubjectEntity>();
	SubjectEntity subjectEntity = new SubjectEntity();
	subjectEntity.setCourseId((long) 111);
	subjectEntity.setCourseName("IT");
	subjectEntity.setSemester("VII");
	subjectEntity.setName("Raj");
	subjectEntity.setSubjectId((long) 1695);
	subjectEntity.setSubjectCode("16uecs01");
	
	SubjectEntity subjectEntity1 = new SubjectEntity();
	subjectEntity1.setCourseId((long) 1112);
	subjectEntity1.setCourseName("CSE");
	subjectEntity1.setSemester("VIII");
	subjectEntity1.setName("present");
	subjectEntity1.setSubjectId((long) 1696);
	subjectEntity1.setSubjectCode("16uecs02");
	subjectList.add(subjectEntity);
	subjectList.add(subjectEntity1);
	System.out.println(subjectList);
	System.out.println(subjectList.size());
	when(subjectController.getAllSubject()).thenReturn(subjectList);
	List<SubjectEntity> subjectList2 = subjectController.getAllSubject();
	assertThat(subjectList2).contains(subjectEntity);

}
}
