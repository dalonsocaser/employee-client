package es.caser.archit.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.caser.archit.spring.dto.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	private RestTemplate restTemplate=new RestTemplate();
	@Override
	public Employee findByAlias(String alias) {		
		ResponseEntity<Employee> employee=restTemplate.getForEntity("http://localhost:8080/employees/hola", Employee.class);
		return employee.getBody();
	}

}
