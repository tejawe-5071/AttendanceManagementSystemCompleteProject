package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.entity.CourseEntity;

/*
 * @author SaiDurga
 */
public interface CourseDao extends JpaRepository<CourseEntity, Long> {

}
