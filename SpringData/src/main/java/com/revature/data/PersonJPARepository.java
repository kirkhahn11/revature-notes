package com.revature.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Person;



@Repository
@Transactional 
public class PersonJPARepository {

	//connect to the database
	@PersistenceContext
	EntityManager entityManager;
	
	//capture the session/connection and perform CRUD operations
	
	public Person findById(int id) {
		
		// we don't need to write a custom query because it's already generated by Hibernate
		return entityManager.find(Person.class, id);
		
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteByid(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_people", Person.class);
		return namedQuery.getResultList();
	}
}
