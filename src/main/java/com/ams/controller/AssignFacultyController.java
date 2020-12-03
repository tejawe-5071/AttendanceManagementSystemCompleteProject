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

import com.ams.service.AssignFacultyService;
import com.ams.entity.AssignFacultyEntity;
import com.ams.exception.RecordNotFoundException;

@RestController
//@RequestMapping("/api/faculties")
public class AssignFacultyController {
	@Autowired
	private AssignFacultyService facultyService;

	@GetMapping("/hello-world_faculty")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/listFaculty")
	public List<AssignFacultyEntity> getAllFaculty() throws RecordNotFoundException {
		return facultyService.findAllFaculty();// response entity
	}

	// creating post mapping that post the faculty detail in the database
	@PostMapping("/insertFaculty")
	public Long create(@RequestBody AssignFacultyEntity faculty) {
		facultyService.add(faculty);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return faculty.getFacultyId();
	}

	// creating put mapping that updates the faculty detail
	@PutMapping("/updateFaculty")
	public ResponseEntity<Boolean> update(@RequestBody AssignFacultyEntity faculty) throws RecordNotFoundException {
		facultyService.update(faculty);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified faculty
	@RequestMapping(value = "/deleteFaculty/{facultyId}", method = RequestMethod.DELETE)
	public String deleteFaculty(@PathVariable("facultyId") Long facultyId) throws RecordNotFoundException {
		facultyService.deleteByFacultyId(facultyId);
		return "faculty has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific faculty
	@GetMapping("/findFaculty/{subjectId}")
	public ResponseEntity<List<AssignFacultyEntity>> getFacultyBySubjectId(@PathVariable("subjectId") Long subjectId)
			throws RecordNotFoundException {
		List<AssignFacultyEntity> faculty = facultyService.findBySubjectId(subjectId);
		return new ResponseEntity<List<AssignFacultyEntity>>(faculty, HttpStatus.OK);
	}

	// creating a get mapping that retrieves the detail of a specific faculty
	@GetMapping("/findFacultyId/{facultyId}")
	public ResponseEntity<AssignFacultyEntity> getFacultyById(@PathVariable("facultyId") Long facultyId)
			throws RecordNotFoundException {
		AssignFacultyEntity faculty = facultyService.getFacultyById(facultyId);
		return new ResponseEntity<AssignFacultyEntity>(faculty, new HttpHeaders(), HttpStatus.OK);
	}
}
