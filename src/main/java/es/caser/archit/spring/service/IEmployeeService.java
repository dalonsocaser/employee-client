package es.caser.archit.spring.service;

import java.util.List;

import es.caser.archit.spring.dto.Employee;

public interface IEmployeeService {
	List<Employee> findByAlias(String alias);

	void add(String alias);

	void delete(String alias);
}
