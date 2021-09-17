package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {

	public int insert(Crime c) {
		
		// capture a Session
		Session ses = HibernateUtil.getSession();
		
		//import from hibernate not JPA
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(c); //the save() session method perfomrs an insert on the database
		
		tx.commit();
		
		return pk;
	}
}
