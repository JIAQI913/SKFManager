package com.group12.domain.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.AttendanceDao;
import com.group12.domain.entity.Attendance;
import com.group12.domain.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	@Autowired
	AttendanceDao attendanceDao;
	
	@Transactional
	public List<Attendance> getAllAttendance() {
		// TODO Auto-generated method stub
		return attendanceDao.getAllAttendance();
	}
	@Transactional
	public void deleteAttendance(int id) {
		// TODO Auto-generated method stub
		attendanceDao.delete(id);
	}
	@Transactional
	public Serializable insertAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceDao.save(attendance);
	}

}
