package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.UserModel;
import com.model.booktable;

@Component
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void insertUser(UserModel u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
	@Transactional
	public void delete(UserModel u) {
		System.out.println("delete called");
		this.hibernateTemplate.delete(u);
	}
	@Transactional
	public UserModel getDataById(UserModel u)
	{
		UserModel u1;
		org.hibernate.Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
		String q="from UserModel u where u.email=:email and u.password=:password";
		Query query=session.createQuery(q);
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPassword());
		u1=(UserModel)query.getSingleResult();
		return u1;
	}
	
	@Transactional
	public void bookatable(booktable u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
		
	
	public List<UserModel> getAllUser() {
		return this.hibernateTemplate.loadAll(UserModel.class);
	}

	
}

