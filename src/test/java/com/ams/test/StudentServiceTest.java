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

import com.ams.entity.StudentEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.StudentDao;
import com.ams.service.StudentServiceImpl;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentServiceTest {
	@InjectMocks
	private StudentServiceImpl studentService;
	@Mock
	private StudentDao studentDao;
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test

	public void AddStudentTest() {
		StudentEntity student = new StudentEntity();
		student.setRollNo((long) 12);
		student.setFirstName("lohi");
		student.setLastName("anke");
		student.setGender("female");
		student.setEmail("gmail");
		student.setMobileNo("9708654321");
		student.setCourseId((long) 20);
		student.setCourseName("cse");
		student.setSubjectId((long) 12);
		student.setSubjectName("dbms");
		student.setFatherMobile("7674815359");
		when(studentDao.save(student)).thenReturn(student);
		Long StudentId = studentService.add(student);
		assertEquals("lohi", student.getFirstName());
		verify(studentDao, times(1)).save(student);

	}

	@Test

	public void updateDoctorTest() {
		StudentEntity student = new StudentEntity();
		student.setRollNo((long) 12);
		student.setFirstName("lohi");
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
		Optional<StudentEntity> student1 = studentDao.findById(studentId);
		when(studentDao.findById(studentId)).thenReturn(student1);
		when(studentDao.save(student)).thenReturn(student);
		student.setCourseId((long) 21);
		studentService.update(student);
		assertEquals(21, student.getCourseId());
		verify(studentDao, times(1)).save(student);
	}

	@Test
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
		Optional<StudentEntity> student1 = Optional.of(student);
		when(studentDao.findById(studentId)).thenReturn(student1);
		StudentEntity viewStudent = studentService.getByStudentId(studentId);
		assertEquals("cse", viewStudent.getCourseName());
		verify(studentDao, times(1)).findById(studentId);
	}
	@Test

	public void viewAttendanceListTest() throws RecordNotFoundException {

		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		StudentEntity student=new StudentEntity();
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
		
		StudentEntity student1 = new StudentEntity();
		student1.setRollNo((long) 13);
		student1.setFirstName("chinna");
		student1.setLastName("somak");
		student1.setGender("male");
		student1.setEmail("gmail");
		student1.setMobileNo("9708654322");
		student1.setCourseId((long) 20);
		student1.setCourseName("cse");
		student1.setSubjectId((long) 13);
		student1.setSubjectName("dbms");
		student1.setFatherMobile("7674815358");
		studentList.add(student);
		studentList.add(student1);
        when(studentDao.findAll()).thenReturn(studentList);	
		List<StudentEntity> studentList2 = studentService.findAllStudents();
		assertEquals(2, studentList2.size());
		verify(studentDao, times(1)).findAll();
		
	}

}
