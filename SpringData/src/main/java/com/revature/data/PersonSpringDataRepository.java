package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Person;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

	// SpringData automatically generates a DAO implementation class of this interface
}
