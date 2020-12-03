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

import com.ams.controller.AssignFacultyController;
import com.ams.repository.AssignFacultyDao;
import com.ams.service.AssignFacultyServiceImpl;
import com.ams.entity.AssignFacultyEntity;
import com.ams.exception.RecordNotFoundException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FacultyControllerTest {
	
	@InjectMocks
	private AssignFacultyController facultyController;
	@Mock
	private AssignFacultyServiceImpl facultyService;
	@Mock
	private AssignFacultyDao facultyDao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addFacultyTest() {
		AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
		facultyEntity.setUserId((long) 161342);
		facultyEntity.setUserName("praveen");
		facultyEntity.setCourseId((long) 170);
		facultyEntity.setCourseName("CSE");
		facultyEntity.setSubjectId((long) 775);
		facultyEntity.setSubjectName("java");
		facultyEntity.setTotalClass("68");
		
		when(facultyDao.save(facultyEntity)).thenReturn(facultyEntity);
		
		Long facultyId = facultyController.create(facultyEntity);
		
		assertEquals("praveen", facultyEntity.getUserName());
	}
	
	@Test
	public void updateAttendanceTest() throws RecordNotFoundException {
		AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
		facultyEntity.setUserId((long) 161012);
		facultyEntity.setUserName("ravi");
		facultyEntity.setCourseId((long) 180);
		facultyEntity.setCourseName("ECE");
		facultyEntity.setSubjectId((long) 765);
		facultyEntity.setSubjectName("electronics");
		facultyEntity.setTotalClass("76");
		Long facultyId = facultyEntity.getFacultyId();
		Optional<AssignFacultyEntity> facultyEntity1 = facultyDao.findById(facultyId);
		
		when(facultyDao.findById(facultyId)).thenReturn(facultyEntity1);
		when(facultyDao.save(facultyEntity)).thenReturn(facultyEntity);
		
		facultyEntity.setCourseId((long) 180);;
		
		facultyController.update(facultyEntity);
		
		assertEquals(180, facultyEntity.getCourseId());
	}
	@Test
	public void viewFacultyByIdTest() throws RecordNotFoundException {

		AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
		facultyEntity.setUserId((long) 165612);
		facultyEntity.setUserName("gopi");
		facultyEntity.setCourseId((long) 1780);
		facultyEntity.setCourseName("EEE");
		facultyEntity.setSubjectId((long) 775);
		facultyEntity.setSubjectName("vlsi");
		facultyEntity.setTotalClass("79");
		Long facultyId = facultyEntity.getFacultyId();
		when(facultyController.getFacultyById(facultyId).getBody()).thenReturn(facultyEntity);
		ResponseEntity<AssignFacultyEntity> viewFaculty = facultyController.getFacultyById(facultyId);
		assertEquals("EEE", viewFaculty.getBody().getCourseName());

	}



@Test
public void viewFacultyListTest() throws RecordNotFoundException {
	List<AssignFacultyEntity> facultyList = new ArrayList<AssignFacultyEntity>();
	AssignFacultyEntity facultyEntity = new AssignFacultyEntity();
	facultyEntity.setUserId((long) 161112);
	facultyEntity.setUserName("pranay");
	facultyEntity.setCourseId((long) 180);
	facultyEntity.setCourseName("EEE");
	facultyEntity.setSubjectId((long) 785);
	facultyEntity.setSubjectName("electronics");
	facultyEntity.setTotalClass("66");
	
	AssignFacultyEntity facultyEntity1 = new AssignFacultyEntity();
	facultyEntity1.setUserId((long) 161902);
	facultyEntity1.setUserName("jittu");
	facultyEntity1.setCourseId((long) 181);
	facultyEntity1.setCourseName("ECE");
	facultyEntity1.setSubjectId((long) 785);
	facultyEntity1.setSubjectName("electronics");
	facultyEntity1.setTotalClass("67");
	
	facultyList.add(facultyEntity);
	facultyList.add(facultyEntity1);

	when(facultyController.getAllFaculty()).thenReturn(facultyList);
	List<AssignFacultyEntity> facultyList2 = facultyController.getAllFaculty();
	assertThat(facultyList2).contains(facultyEntity);

}

}
