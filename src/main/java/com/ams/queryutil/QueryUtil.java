package com.ams.queryutil;

public class QueryUtil {
	private QueryUtil() {
	}

	public static final String VIEW_STUD_BY_ID = "SELECT a FROM AttendanceEntity a WHERE a.studentId like ?1";

	public static final String DEL_STUD_BY_ID = "DELETE from AttendanceEntity a where a.studentId like ?1";
	public static final String VIEW_STUD_BY_ROLLNO = "SELECT s FROM StudentEntity s WHERE s.rollNo like ?1";
	public static final String VIEW_STUD_BY_COURSEID = "SELECT s FROM StudentEntity s WHERE s.courseId like ?1";
	public static final String DEL_STD_BY_ID = "DELETE from StudentEntity s where s.studentId like ?1";
	public static final String VIEW_SUB_BY_ID = "SELECT  s FROM SubjectEntity s where  s.subjectId like ?1";
	public static final String DEL_SUB_BY_ID = "DELETE from SubjectEntity a where a.subjectId like ?1";
	public static final String VIEW_FACU_BY_ID = "SELECT a FROM AssignFacultyEntity a WHERE a.subjectId like ?1";

	public static final String DEL_FACU_BY_ID = "DELETE from AssignFacultyEntity a where a.facultyId like ?1";
			
}
