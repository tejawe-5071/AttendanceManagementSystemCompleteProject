package com.ams.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

/*https://www.javatpoint.com/spring-boot-crud-operations*/

/*
 * @author SaiDurga
 */
@Entity
@Table(name = "attendancetable1")

public class AttendanceEntity {
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 5, allocationSize = 100)
	@GeneratedValue(generator = "mySeqGen")
	private Long attendanceId;
	@NotNull
	@Column(name = "SUBJ_ID", length = 10)
	private Long subjectId;
	@NotNull
	@Column(name = "SUBJ_NAME", length = 10)
	private String subjectName;
	@NotNull
	@Column(name = "STUD_ID", length = 10)
	private Long studentId;
	@NotNull
	@Column(name = "STUD_NAME", length = 20)
	private String studentName;
	@NotNull
	@Column(name = "STATUS", length = 20)
	private String status;
	@NotNull
	@Column(name = "SEMESTER", length = 10)
	private String semester;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull
	@Column(name = "T_DATE")
	private LocalDate date;
	@NotNull
	@Column(name = "TOTAL_PERCENTAGE", length = 3)
	private Long totalClassPercentage;
	@NotNull
	@Column(name = "PERCENTAGE")
	private String totalPercentage;
	@NotNull
	@Column(name = "COURSE_ID", length = 6)
	private Long courseId;
	@NotNull
	@Column(name = "COURSE_NAME", length = 30)
	private String courseName;

	/*
	 * Getters and Setters
	 */
	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getTotalClassPercentage() {
		return totalClassPercentage;
	}

	public void setTotalClassPercentage(Long totalClassPercentage) {
		this.totalClassPercentage = totalClassPercentage;
	}

	public String getTotalPercentage() {
		return totalPercentage;
	}

	public void setTotalPercentage(String totalPercentage) {
		this.totalPercentage = totalPercentage;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * Creating getters and setters for above properties
	 */
	@Override
	public String toString() {
		return "AttendanceEntity [attendanceId=" + attendanceId + ", subjectId=" + subjectId + ", subjectName="
				+ ", status=" + status + subjectName + ", studentId=" + studentId + ", studentName=" + studentName
				+ ",date=" + date + ", semester=" + semester + ", totalClassPercentage=" + totalClassPercentage
				+ ", totalPercentage=" + totalPercentage + ", courseId=" + courseId + ", courseName=" + courseName
				+ "]";
	}

	/*
	 * Constructor generation
	 */
	public AttendanceEntity(Long subjectId, String subjectName, String status, Long studentId, String studentName,
			String semester, LocalDate date, Long totalClassPercentage, String totalPercentage, Long courseId,
			String courseName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.studentId = studentId;
		this.status = status;
		this.studentName = studentName;
		this.date = date;
		this.semester = semester;
		this.totalClassPercentage = totalClassPercentage;
		this.totalPercentage = totalPercentage;
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public AttendanceEntity() {

	}

	// create constructor
	public AttendanceEntity(Long subjectId, String subjectName, String status, Long studentId, String studentName,
			String semester, Long totalClassPercentage, String totalPercentage, Long courseId, String courseName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.studentId = studentId;
		this.status = status;
		this.studentName = studentName;
		this.semester = semester;
		this.totalClassPercentage = totalClassPercentage;
		this.totalPercentage = totalPercentage;
		this.courseId = courseId;
		this.courseName = courseName;
	}

}
