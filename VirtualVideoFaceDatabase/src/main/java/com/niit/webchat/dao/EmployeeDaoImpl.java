package com.niit.webchat.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.webchat.model.Authorization;
import com.niit.webchat.model.Employee;

@Repository(value = "employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger log = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean addUser(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		log.debug("user data is going to end");
		try {
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
 		employee.setConfrimPassword(passwordEncoder.encode(employee.getConfrimPassword()));
			sessionFactory.getCurrentSession().save(employee);
			Authorization auth = new Authorization();

			auth.setUserName(employee.getUserEmail());

			session.save(auth);

			log.debug("user data added successfully");

			return true;

		} catch (HibernateException exception) {
			log.error(exception.getMessage());
			return false;
		}
	}

	public boolean deleteUser(Employee employee) {
		log.debug("user data is going to update");
		try {
			Session session = sessionFactory.getCurrentSession();

			session.delete(employee);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateUser(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		log.debug("user data is going to update");
		try {
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));

			session.update(employee);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Employee getUserById(int userId) {
		log.debug("user by Id is going to run");
		try {
			Employee user = (Employee) sessionFactory.getCurrentSession().createQuery("from Employee where userId=?")
					.setParameter(0, userId).uniqueResult();

			System.out.println("dao user by id" + user.getUserId());
			return user;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getAllUser() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Employee where userName!='admin'").list();
		}

		catch (HibernateException e) {

			e.printStackTrace();
			throw e;
		}
	}

	public Employee getUserEmail(String emailId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Employee where userEmail=:emailId");
			Employee user = (Employee) query.setParameter("emailId", emailId).getSingleResult();
			return user;
		} catch (HibernateException e) {

			e.printStackTrace();
			return null;
		}

	}

	public boolean updatePassword(Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		log.debug("user data is going to update");
		try 
		{
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			employee.setConfrimPassword(passwordEncoder.encode(employee.getConfrimPassword()));
			
			session.update(employee);
			
			return true;
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	}

