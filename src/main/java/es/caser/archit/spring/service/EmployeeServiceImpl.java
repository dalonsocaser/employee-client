package es.caser.archit.spring.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import es.caser.archit.spring.dto.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	private static final String ID_PATH = "/{id}";

	private static final String HTTP_LOCALHOST_3000_EMPLOYEES = "http://localhost:3000/employees";
	
	private RestTemplate restTemplate=new RestTemplate();
	@Override
	public List<Employee> findByAlias(String alias) {		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HTTP_LOCALHOST_3000_EMPLOYEES)
		        .queryParam("alias", alias);		        
		Employee[] employee=restTemplate.getForObject(builder.build().encode().toUri(), Employee[].class);
		return Arrays.asList(employee);
	}
	@Override
	public void add(String alias) {
		
		restTemplate.postForObject(HTTP_LOCALHOST_3000_EMPLOYEES, generateEmployee(alias), Employee.class);
	}
	
	@Override
	public void delete(String alias) {
		List<Employee>list=findByAlias(alias);
		Long id=list.get(0).getId();
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		restTemplate.delete(HTTP_LOCALHOST_3000_EMPLOYEES+ID_PATH,params);
	}
	private Employee generateEmployee(String alias) {
		Employee[] employee=restTemplate.getForObject(HTTP_LOCALHOST_3000_EMPLOYEES, Employee[].class);
		Employee newOne=new Employee();
		newOne.setId(new Long(employee.length+1));
		newOne.setAlias(alias);
		return newOne;
	}

}
