package com.ams.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @author SaiDurga
 */
@Entity
@Table(name = "COURSE1")
public class CourseEntity {
	@Id
	@Column(name = "Course_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long courseId;
	private String courseName;
	private String courseDescription;

	/*
	 * Creating one to many relation with subjects
	 */
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<SubjectEntity> subjects = new HashSet<>(); // Initialization required to avoid NullPointerException
	/*
	 * creating getters and setters
	 */

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long id) {
		this.courseId = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/*
	 * creating to string method
	 */

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", subjects=" + subjects + "]";
	}

	public Set<SubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<SubjectEntity> subjects) {
		this.subjects = subjects;
	}

	public CourseEntity(String courseName, String courseDescription) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public CourseEntity() {
	}

	public CourseEntity(String courseName, String courseDescription, Set<SubjectEntity> subjects) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.subjects = subjects;
	}

}
