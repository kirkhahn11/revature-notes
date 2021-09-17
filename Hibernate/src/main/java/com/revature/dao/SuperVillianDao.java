package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.SuperVillian;
import com.revature.util.HibernateUtil;

public class SuperVillianDao {

	public int insert(SuperVillian sv) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(sv); 
		
		tx.commit();
		
		return pk;
	}
	
	public List<SuperVillian> selectAll() {
		
		Session ses = HibernateUtil.getSession();
		
		// Hibernate supports a language called HQL... 
		List<SuperVillian> vills = ses.createQuery("from SuperVillian", SuperVillian.class).list();
		
		return vills;
	}
}
