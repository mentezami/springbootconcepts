package com.jpaexample.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpaexample.entities.Person;

/*
 * Customer QueryFinders (Query Creation)
 * Reference Link: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
*/
public interface PersonRepo extends CrudRepository<Person, Integer> {

	public List<Person> findByFirstNameIgnoreCase(String firstName);

	public List<Person> findByMiddleNameIgnoreCase(String middleName);

	public List<Person> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);

	/*
	 * We can create custom queries by passing our queries as well which could be
	 * native sql or hql.
	 */

	@Query("select p from Person p")
	public List<Person> getPersons();

	@Query("select p from Person p where p.pan=:n")
	public List<Person> getPersonByPan(@Param("n") String pan);

}
