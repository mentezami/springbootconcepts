package com.jpaexample.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import com.jpaexample.entities.Person;

/*
 * Customer QueryFinders (Query Creation)
 * Reference Link: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
*/
public interface PersonRepo extends CrudRepository<Person, Integer> {

	public List<Person> findByFirstNameIgnoreCase(String firstName);

	public List<Person> findByMiddleNameIgnoreCase(String middleName);
	
	public List<Person> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);

}
