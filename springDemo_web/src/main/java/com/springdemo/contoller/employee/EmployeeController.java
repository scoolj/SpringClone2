package com.springdemo.contoller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.employee.service.EmployeeService;
import com.springdemo.entities.Employee;

@RestController
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee tempEmployee ) {
		
		
//		System.out.println(tempEmployee.getEmail());
		
		employeeServiceImpl.addEmployee(tempEmployee);
		
		return tempEmployee;
		
	}
	
	
//	@GetMapping("/showForm")
//	public String showFormForAdd(Model theModel) {
//		
//		// create model attribute to bind form data
//		Employee theEmployee = new Employee();
//		
//		theModel.addAttribute("employee", theEmployee);
//		
//		return "employee-form";
//	}
//	
	@GetMapping("/getEmployees")
	public List<Employee>getEmployees(){
		
		return employeeServiceImpl.getEmployees();
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public Employee getEmployeeById (@PathVariable int  employeeId){
		
		return employeeServiceImpl.getEmployeeById(employeeId);
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public  Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee ){
	
//		Employee saveEmployee = employeeServiceImpl.getEmployeeById(employeeId);
		employee.setId(employeeId);
		employeeServiceImpl.updateEmployee(employee);
		return employee;
	}
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId){
		
		employeeServiceImpl.deleteEmployee(employeeId);
	}
}
