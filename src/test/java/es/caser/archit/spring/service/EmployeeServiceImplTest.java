package es.caser.archit.spring.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import es.caser.archit.spring.EmployeeClientApplication;
import es.caser.archit.spring.dto.Employee;





@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=EmployeeClientApplication.class)

public class EmployeeServiceImplTest {

	@Autowired
	private IEmployeeService employeeService;
	@Test
	public void testFindByAlias() {
		Employee empleado=employeeService.findByAlias("hola");
		assertNotNull(empleado);
	}

}
