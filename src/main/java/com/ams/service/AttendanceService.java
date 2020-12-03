package com.ams.service;

import java.util.List;

import com.ams.entity.AttendanceEntity;
import com.ams.exception.RecordNotFoundException;

/*
 * @author SaiDurga
 */
public interface AttendanceService {

	public Long add(AttendanceEntity entity);

	public void update(AttendanceEntity entity) throws RecordNotFoundException;

	public void deleteByAttendanceId(Long attendanceId) throws RecordNotFoundException;

	public List<AttendanceEntity> findByStudentId(Long studentId) throws RecordNotFoundException;

	public AttendanceEntity getAttendanceById(Long attendanceId) throws RecordNotFoundException;

	public List<AttendanceEntity> findAllAttendance() throws RecordNotFoundException;

}
