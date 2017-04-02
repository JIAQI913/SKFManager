package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.entity.Student;
import com.group12.domain.dao.StudentDao;

	@Repository
	public class StudentDaoImpl implements StudentDao{

		@Autowired
		SessionFactory sessionFactory;
		
		public Serializable save(Student student) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			return session.save(student);
		}

		public Student search(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			Student student=(Student)session.get(Student.class, id);
			return student;
		}

		public List<Student> getAllStudent() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Student");
			List<Student> list=query.list();
			return list;
		}

		public void update(Student student) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			session.update(student);
			session.flush();
		}
		
}
