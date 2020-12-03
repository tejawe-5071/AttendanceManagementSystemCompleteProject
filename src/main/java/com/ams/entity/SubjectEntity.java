package com.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

/**
 * 
 * @author NagaRaj
 *
 */

@Entity
@Table(name = "ASSIGN_SUBJECT1")
public class SubjectEntity {

	@Id
	@Column(name = "SUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long subjectId;
	@NotNull
	@Column(name = "COURSE_ID", length = 10)
	private Long courseId;
	@NotNull
	@Column(name = "COURSE_NAME", length = 10)
	private String courseName;
	@NotNull
	@Column(name = "NAME", length = 10)
	private String name;
	@NotNull
	@Column(name = "SUBJECTCODE", length = 10)
	private String subjectCode;
	@NotNull
	@Column(name = "SEMESTER", length = 20)
	private String semester;
	@NotNull
	@Column(name = "DESCRIPTION", length = 20)
	private String description;
	/*
	 * creating many to one relation with course
	 */

	@ManyToOne
	@JoinColumn(name = "SUBJECT_COURSE")
	private CourseEntity course;

	/*
	 * creating getters and setters
	 */
	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "SubjectEntity [subjectId=" + subjectId + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", name=" + name + ", subjectCode=" + subjectCode + ", semester=" + semester + ", description="
				+ description + "]";
	}

	/*
	 * constructor generation
	 */
	public SubjectEntity(Long courseId, String courseName, String name, String subjectCode, String semester,
			String description) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.name = name;
		this.subjectCode = subjectCode;
		this.semester = semester;
		this.description = description;
	}

	public SubjectEntity() {

	}

	public SubjectEntity(Long subjectId, Long courseId, String courseName, String name, String subjectCode,
			String semester, String description) {
		super();
		this.subjectId = subjectId;
		this.courseId = courseId;
		this.courseName = courseName;
		this.name = name;
		this.subjectCode = subjectCode;
		this.semester = semester;
		this.description = description;
	}

	public SubjectEntity(Long courseId, String courseName, String name, String subjectCode, String semester,
			String description, CourseEntity course) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.name = name;
		this.subjectCode = subjectCode;
		this.semester = semester;
		this.description = description;
		this.course = course;
	}

}
