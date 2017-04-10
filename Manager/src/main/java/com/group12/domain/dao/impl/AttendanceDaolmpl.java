package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.AttendanceDao;
import com.group12.domain.entity.Attain;
import com.group12.domain.entity.Attendance;
import com.group12.domain.entity.Parent;

@Repository
public class AttendanceDaolmpl implements AttendanceDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Serializable save(Attendance attain) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.save(attain);
	}

	public List<Attendance> getAllAttendance() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Attendance");
		List<Attendance> list=query.list();
		return list;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(Attendance.class, id));
		session.flush();
	}

}
