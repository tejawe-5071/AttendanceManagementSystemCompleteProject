package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.StudentEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.StudentService;

/**
 * @author puspha
 *
 */
//mark class as a Controller
@RestController
//@RequestMapping("/api/amsstudent")
public class StudentController {
	// autowire the attendanceService class
	@Autowired
	private StudentService studentService;

	@GetMapping("/helloworld_student")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating post mapping that post the student detail in the database
	@PostMapping("/insertStudent")
	public Long create(@RequestBody StudentEntity student) {
		studentService.add(student);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return student.getStudentId();

	}

	// creating put mapping that updates the attendance detail
	@PutMapping("/updateStudent")
	public ResponseEntity<Boolean> update(@RequestBody StudentEntity student) {
		studentService.update(student);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified student
	@RequestMapping(value = "/deleteStudent/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Long studentId) throws RecordNotFoundException {
		studentService.deleteByStudentId(studentId);
		return "student has been deleted successfully";
	}

	// creating get mapping that retrieves the detail of a specific Student
	@GetMapping("/findStudent/{studentId}")
	public ResponseEntity<StudentEntity> getStudentBystudentId(@PathVariable("studentId") Long studentId)
			throws RecordNotFoundException {
		StudentEntity student = studentService.getByStudentId(studentId);
		return new ResponseEntity<StudentEntity>(student, new HttpHeaders(), HttpStatus.OK);

	}

	// creating get mapping that retrieves the detail of a specific Student
	@GetMapping("/findcourseId/{courseId}")
	public ResponseEntity<List<StudentEntity>> getStudentByCourseId(@PathVariable("courseId") Long courseId)
			throws RecordNotFoundException {
		List<StudentEntity> student = studentService.findByCourseId(courseId);
		return new ResponseEntity<List<StudentEntity>>(student, HttpStatus.OK);
	}

	// getting all student records by using the method findaAll() of CrudRepository
	@GetMapping("/listStudent")
	public List<StudentEntity> getAllStudents() throws RecordNotFoundException {
		return studentService.findAllStudents();// response entity

	}

}
