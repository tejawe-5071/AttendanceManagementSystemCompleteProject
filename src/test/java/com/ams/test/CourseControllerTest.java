package com.ams.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.ams.controller.CourseController;
import com.ams.entity.CourseEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.CourseDao;
import com.ams.service.CourseServiceImpl;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseControllerTest {
	@InjectMocks
	private CourseController courseController;
	@Mock
	private CourseServiceImpl courseService;
	@Mock
	private CourseDao courseDao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void addCourseTest() {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseDescription("Intermediate");
		courseEntity.setCourseName("IT");
		
		
		when(courseDao.save(courseEntity)).thenReturn(courseEntity);
		
		Long courseId = courseController.create(courseEntity);
		
		assertEquals("IT", courseEntity.getCourseName());
	}
	
	@Test
	public void updateCourseTest() throws RecordNotFoundException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseDescription("Intermediate");
		courseEntity.setCourseName("IT");
		Long courseId = courseEntity.getCourseId();
		Optional<CourseEntity> courseEntity1 = courseDao.findById(courseId);
		
		when(courseDao.findById(courseId)).thenReturn(courseEntity1);
		when(courseDao.save(courseEntity)).thenReturn(courseEntity);
		
		courseEntity.setCourseId((long) 112);;
		
		courseController.update(courseEntity);
		
		assertEquals(112, courseEntity.getCourseId());
	}
	@Test
	public void viewCourseByIdTest() throws RecordNotFoundException {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseDescription("Intermediate");
		courseEntity.setCourseName("IT");
		Long courseId = courseEntity.getCourseId();
		when(courseController.getCourseById(courseId).getBody()).thenReturn(courseEntity);	
		ResponseEntity<CourseEntity> viewCourse= courseController.getCourseById(courseId);
		assertEquals("IT", viewCourse.getBody().getCourseName());
	}
	@Test
	public void viewCourseListTest() throws RecordNotFoundException {
		List<CourseEntity> courseList = new ArrayList<CourseEntity>();
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setCourseDescription("Intermediate");
		courseEntity.setCourseName("IT");
		
		CourseEntity courseEntity1 = new CourseEntity();
		courseEntity1.setCourseDescription("Intermediate");
		courseEntity1.setCourseName("IT");
		
		courseList.add(courseEntity);
		courseList.add(courseEntity1);
		when(courseController.getAllCourse()).thenReturn(courseList);
		List<CourseEntity> courseList2 = courseController.getAllCourse();
		assertThat(courseList2).contains(courseEntity);

	}

}
