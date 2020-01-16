/**
 * 
 */
package com.springdemo.employee.service;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdemo.entities.Employee;
import com.springdemo.entities.dao.EmployeeDao;


/**
 * @author user
 *
 */
@ContextConfiguration("classpath:/springDemo-service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		
		employeeService = mock(EmployeeService.class);
	}

	@Test
	public void employeeExistsTest() {
		assertNotNull(EmployeeService.class);
	}
	
	@Test
	public void addEmployeeTest() {
		
		
		Employee employee = new Employee("Peter","Brand","peter@gmail.com");
		
		doNothing().when(employeeService).addEmployee(isA(Employee.class));
		employeeService.addEmployee(employee);
		
		verify(employeeService, times(1)).addEmployee(employee);
	}
	
	@Test 
	public void getEmployeeTest() {
		
		Employee tempEmployee = new Employee("John", "Paulina", "john@gmail.com");
		Employee tempEmployee2 = new Employee("James", "Brown", "james@gmail.com");
		Employee tempEmployee3 = new Employee("Micheal", "Blake", "micheal@gmail.com");
		
//		List<Employee> theEmployees = new ArrayList<Employee>();
		
//		theEmployees.add(tempEmployee);
//		theEmployees.add(tempEmployee2);
//		theEmployees.add(tempEmployee3);
//		
		when(employeeService.getEmployees()).thenReturn(new ArrayList<Employee>());
		employeeService.getEmployees();
		verify(employeeService, times(1)).getEmployees();
	}
	
	@Test
	public void getEmployByIdTest() {
		when(employeeService.getEmployeeById(1)).thenReturn(isA(new Employee().getClass()));
		employeeService.getEmployeeById(1);
		
		verify(employeeService, times(1)).getEmployeeById(1);
	}
	
	@Test
	public void updateEmployeeTest() {
		
		Employee employee = new Employee("John", "Paulina", "john@gmail.com");
		
		doNothing().when(employeeService).updateEmployee(isA(Employee.class));
		
		employeeService.updateEmployee(employee);
		
		verify(employeeService, times(1)).updateEmployee(employee);
		
	}
	
	@Test
	public void deleteEmployeeTest() {
		
//		Employee employee = new Employee("Peter", "Brader", "peter@gmail.com");
		
		doNothing().when(employeeService).deleteEmployee(isA(int.class));
		
		employeeService.deleteEmployee(1);
		
		verify(employeeService, times(1)).deleteEmployee(1);
		
	}

}
