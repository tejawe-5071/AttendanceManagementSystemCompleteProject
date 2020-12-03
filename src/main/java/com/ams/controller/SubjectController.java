package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.SubjectEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.SubjectService;

/*
 * @author NagaRaj
 */
//mark class as Controller  
@RestController
//@RequestMapping("/api/amssubject")
public class SubjectController {
	// autowire the SubjectService class
	@Autowired
	private SubjectService subjectService;

	@GetMapping("/hello-world_subject")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the subjects detail from the
	// database
	@GetMapping("/list")
	public List<SubjectEntity> getAllSubject() throws RecordNotFoundException {
		new ResponseEntity<Boolean>(true, HttpStatus.OK);
		return subjectService.findAllSubjects();

	}

	// creating post mapping that post the subject detail in the database
	@PostMapping("/insertSubject")
	public Long create(@RequestBody SubjectEntity subject) {
		subjectService.add(subject);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return subject.getCourseId();
	}

	// creating put mapping that updates the subject detail
	@PutMapping("/updateSubject")
	public ResponseEntity<Boolean> update(@RequestBody SubjectEntity subject) {
		subjectService.update(subject);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified subject
	@DeleteMapping(value = "/deleteSubject/{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") Long subjectId) throws RecordNotFoundException {
		subjectService.deleteBySubjectId(subjectId);
		return "subject has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific subject
	@GetMapping("/findSubject/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable("subjectId") Long subjectId)
			throws RecordNotFoundException {
		SubjectEntity subject = subjectService.getSubjectById(subjectId);
		return new ResponseEntity<SubjectEntity>(subject, new HttpHeaders(), HttpStatus.OK);
	}

}
