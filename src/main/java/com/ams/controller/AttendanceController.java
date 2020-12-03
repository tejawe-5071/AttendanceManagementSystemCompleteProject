package com.ams.controller;

/*
Create string objects in java
Git
Validations
maam pom.xml
Test cases
application.prop
 */
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
import com.ams.entity.AttendanceEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.service.AttendanceService;

/*
 * @author SaiDurga
 */
//mark class as Controller  
@RestController
//@RequestMapping("/api/amsattendance")

public class AttendanceController {
	// autowire the AttendanceService class
	@Autowired
	private AttendanceService attendanceService;

	@GetMapping("/hello-world_attendance")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the books detail from the database
	@GetMapping("/listAttendance")
	public List<AttendanceEntity> getAllAttendance() throws RecordNotFoundException {
		@SuppressWarnings("unused")
		ResponseEntity<Boolean> responseEntity;
		return attendanceService.findAllAttendance();
	}

	// creating post mapping that post the attendance detail in the database
	@PostMapping("/insertAttendance")
	public Long create(@RequestBody AttendanceEntity attendance) {
		attendanceService.add(attendance);
		@SuppressWarnings({ "unused" })
		ResponseEntity<Boolean> responseEntity;
		return attendance.getAttendanceId();
	}

	// creating put mapping that updates the attendance detail
	@PutMapping("/updateAttendance")
	public ResponseEntity<Boolean> update(@RequestBody AttendanceEntity attendance) throws RecordNotFoundException {
		attendanceService.update(attendance);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified student
	@DeleteMapping(value = "/deleteAttendance/{attendanceId}")
	public String deleteAttendance(@PathVariable("attendanceId") Long attendanceId) throws RecordNotFoundException {
		attendanceService.deleteByAttendanceId(attendanceId);
		return "student has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/findStudentAttendance/{studentId}")
	public ResponseEntity<List<AttendanceEntity>> getAttendanceBystudentId(@PathVariable("studentId") Long studentId)
			throws RecordNotFoundException {
		List<AttendanceEntity> attendance = attendanceService.findByStudentId(studentId);
		return new ResponseEntity<List<AttendanceEntity>>(attendance, HttpStatus.OK);
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/findAttendance/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable("attendanceId") Long attendanceId)
			throws RecordNotFoundException {
		AttendanceEntity attendance = attendanceService.getAttendanceById(attendanceId);
		return new ResponseEntity<AttendanceEntity>(attendance, new HttpHeaders(), HttpStatus.OK);
	}

}
