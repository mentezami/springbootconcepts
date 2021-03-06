package com.jpaexample;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpaexample.entities.Employee;
import com.jpaexample.repositories.EmployeeRepo;

/*
Mentioned link can be used for creating queries in the repository as per our requirements.

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
*/
@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(JpaexampleApplication.class, args);

		EmployeeRepo employeeRepo = applicationContext.getBean(EmployeeRepo.class);

		Employee employee01 = new Employee();
		employee01.setName("Demo Singh Chouhan");
		employee01.setAddress("Sudama Nagar");

		// saving single object

		Employee singleEmployee = employeeRepo.save(employee01);

		System.out.println("-----------------------------------------------------");

		// fetching single object from the database.
		System.out.println(employeeRepo.findById(1));

		Employee employee = new Employee();
		employee.setName("Hemendra Singh Chouhan");
		employee.setAddress("Sudama Nagar");

		Employee employee1 = new Employee();
		employee1.setName("Subhash Singh Chouhan");
		employee1.setAddress("Sudama Nagar");

		Employee employee2 = new Employee();
		employee2.setName("Nisha Singh Chouhan");
		employee2.setAddress("Sudama Nagar");

		Employee employee3 = new Employee();
		employee3.setName("Aditi Singh Chouhan");
		employee3.setAddress("Sudama Nagar");

		System.out.println("-----------------------------------------------------");

		// saving multiple users.

		employeeRepo.saveAll(List.of(employee, employee1, employee2, employee3));

		// fetching multiple objects from the database.
		List<Employee> employees = (List<Employee>) employeeRepo.findAll();
		employees.stream().forEach(e -> System.out.println(e));

		System.out.println("-----------------------------------------------------");

		// update object

		Optional<Employee> optional = employeeRepo.findById(1);
		Employee employee4 = optional.get();
		employee4.setName("Sunny Singh Chouhan");
		employee4.setAddress("Indore Madhya Pradesh");
		employeeRepo.save(employee4);

		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");

		System.out.println(employeeRepo.findById(1));

		// delete object from database.
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		employeeRepo.deleteById(1);

		Iterable<Employee> employees2 = employeeRepo.findAll();
		employees2.forEach(e -> System.out.println(e));

		// deleting multiple records from database.

		employeeRepo.deleteAll(List.of(employee4, employee3, employee2));
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");

		// getting records from database.
		Iterable<Employee> employees3 = employeeRepo.findAll();
		employees3.forEach(e -> System.out.println(e));

	}

}
