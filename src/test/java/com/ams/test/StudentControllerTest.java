package com.ams.test;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.http.ResponseEntity;

import com.ams.controller.StudentController;
import com.ams.entity.AssignFacultyEntity;
import com.ams.entity.StudentEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.StudentDao;
import com.ams.service.StudentServiceImpl;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentControllerTest {
	@InjectMocks
	private StudentController studentController;
	@Mock
	private StudentServiceImpl studentService;
	@Mock
	private StudentDao studentDao;
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	public void AddStudentTest() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setRollNo((long) 12);
		studentEntity.setFirstName("lohi");
		studentEntity.setLastName("anke");
		studentEntity.setGender("female");
		studentEntity.setEmail("gmail");
		studentEntity.setMobileNo("9708654321");
		studentEntity.setCourseId((long) 20);
		studentEntity.setCourseName("cse");
		studentEntity.setSubjectId((long) 12);
		studentEntity.setSubjectName("dbms");
		studentEntity.setFatherMobile("7674815359");
		when(studentDao.save(studentEntity)).thenReturn(studentEntity);
		Long StudentId = studentController.create(studentEntity);
		assertEquals("lohi", studentEntity.getFirstName());
		verify(studentDao, times(1)).save(studentEntity);
	
	}
	@Test

	public void updateDoctorTest() {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setRollNo((long) 12);
		studentEntity.setFirstName("lohi");
		studentEntity.setLastName("anke");
		studentEntity.setGender("female");
		studentEntity.setEmail("gmail");
		studentEntity.setMobileNo("9708654321");
		studentEntity.setCourseId((long) 20);
		studentEntity.setCourseName("cse");
		studentEntity.setSubjectId((long) 12);
		studentEntity.setSubjectName("dbms");
		studentEntity.setFatherMobile("7674815359");
		Long studentId = studentEntity.getStudentId();
		Optional<StudentEntity> studentEntity1 = studentDao.findById(studentId);
		when(studentDao.findById(studentId)).thenReturn(studentEntity1);
		when(studentDao.save(studentEntity)).thenReturn(studentEntity);
		studentEntity.setCourseId((long) 21);
		studentController.update(studentEntity);
		assertEquals(21, studentEntity.getCourseId());
	}
	public void ViewStudentByIdTest() throws RecordNotFoundException {
		StudentEntity student = new StudentEntity();
		student.setRollNo((long) 12);
		student.setFirstName("pushpa");
		student.setLastName("anke");
		student.setGender("female");
		student.setEmail("gmail");
		student.setMobileNo("9708654321");
		student.setCourseId((long) 20);
		student.setCourseName("cse");
		student.setSubjectId((long) 12);
		student.setSubjectName("dbms");
		student.setFatherMobile("7674815359");
		Long studentId = student.getStudentId();
		when(studentController.getStudentBystudentId(studentId).getBody()).thenReturn(student);
		ResponseEntity<StudentEntity> viewStudent = studentController.getStudentBystudentId(studentId);
		assertEquals("cse", viewStudent.getBody().getCourseName());
	}
	@Test

	public void viewAttendanceListTest() throws RecordNotFoundException {

		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setRollNo((long) 12);
		studentEntity.setFirstName("pushpa");
		studentEntity.setLastName("anke");
		studentEntity.setGender("female");
		studentEntity.setEmail("gmail");
		studentEntity.setMobileNo("9708654321");
		studentEntity.setCourseId((long) 20);
		studentEntity.setCourseName("cse");
		studentEntity.setSubjectId((long) 12);
		studentEntity.setSubjectName("dbms");
		studentEntity.setFatherMobile("7674815359");
		
		StudentEntity studentEntity1 = new StudentEntity();
		studentEntity1.setRollNo((long) 13);
		studentEntity1.setFirstName("chinna");
		studentEntity1.setLastName("somak");
		studentEntity1.setGender("male");
		studentEntity1.setEmail("gmail");
		studentEntity1.setMobileNo("9708654322");
		studentEntity1.setCourseId((long) 20);
		studentEntity1.setCourseName("cse");
		studentEntity1.setSubjectId((long) 13);
		studentEntity1.setSubjectName("dbms");
		studentEntity1.setFatherMobile("7674815358");
		studentList.add(studentEntity);
		studentList.add(studentEntity1);
		System.out.println(studentList);
		System.out.println(studentList.size());
        when(studentController.getAllStudents()).thenReturn(studentList);	
		List<StudentEntity> studentList2 = studentController.getAllStudents();
		assertThat(studentList2).contains(studentEntity);
	}

}
