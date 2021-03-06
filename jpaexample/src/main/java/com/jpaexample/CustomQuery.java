package com.jpaexample;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jpaexample.entities.Person;
import com.jpaexample.repositories.PersonRepo;

@SpringBootApplication
public class CustomQuery {

	public static void main(String[] args) {

		/*
		 * In this example we will creating custom finder methods for which refer the
		 * repository.
		 */

		ApplicationContext applicationContext = SpringApplication.run(CustomQuery.class, args);
		PersonRepo personRepo = applicationContext.getBean(PersonRepo.class);
		System.out.println("Welcome");

		Person person1 = new Person();
		person1.setAadhar(991020006627l);
		person1.setPan("BFHPC6065G");
		person1.setFirstName("Hemendra");
		person1.setMiddleName("Singh");
		person1.setLastName("Chouhan");
		person1.setMobile(7999996891l);

		Person person2 = new Person();
		person2.setAadhar(991020006628l);
		person2.setPan("BFHPC6066G");
		person2.setFirstName("Subhash");
		person2.setMiddleName("Singh");
		person2.setLastName("Chouhan");
		person2.setMobile(9826507240l);

		Person person3 = new Person();
		person3.setAadhar(991020006629l);
		person3.setPan("BFHPC6067G");
		person3.setFirstName("Nisha");
		person3.setMiddleName("Singh");
		person3.setLastName("Chouhan");
		person3.setMobile(9926072373l);

		Person person4 = new Person();
		person4.setAadhar(991020006626l);
		person4.setPan("BFHPC6068G");
		person4.setFirstName("Sunny");
		person4.setMiddleName("Singh");
		person4.setLastName("Chouhan");
		person4.setMobile(9229170965l);

		Person person5 = new Person();
		person5.setAadhar(991020006625l);
		person5.setPan("BFHPC6069G");
		person5.setFirstName("Aditi");
		person5.setMiddleName("Gupta");
		person5.setLastName("Chouhan");
		person5.setMobile(9179075876l);

		personRepo.saveAll(List.of(person1, person2, person3, person4, person5));

		Iterable<Person> persons = personRepo.findAll();
		persons.forEach(p -> System.out.println(p));

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println(personRepo.findByFirstNameIgnoreCase("hemendra"));

		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		personRepo.findByMiddleNameIgnoreCase("Singh").forEach(p -> System.out.println(p));

		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");

		personRepo.findByFirstNameOrLastNameIgnoreCase("hemendra", "hemendra").forEach(p -> System.out.println(p));

		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		
		List<Person> person = personRepo.getPersons();
		person.forEach(p->System.out.println(p));
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		
		List<Person> personS1 = personRepo.getPersonByPan("BFHPC6065G");
		personS1.forEach(p->System.out.println(p));

	}

}
