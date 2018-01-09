package es.caser.archit.spring.service;

import es.caser.archit.spring.dto.Employee;

public interface IEmployeeService {
	Employee findByAlias(String alias);
}
