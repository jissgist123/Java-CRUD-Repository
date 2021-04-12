package com.build.java.learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.build.java.learn.dto.EmployeeDto;
import com.build.java.learn.dto.TransferDto;
import com.build.java.learn.service.EmployeeService;
import com.build.java.learn.service.TransferService;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="*",allowedHeaders="*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TransferService transferService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping("/list")
	public List<EmployeeDto> EmployeeListFetch() {
		return(employeeService.getAllEmployeeList());
	}
	
	@RequestMapping("/save")
	public Boolean SaveEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto) {
		Boolean status=employeeService.saveEmployeeDetails(employeeDto);
		return status;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean DeleteEmployeeDetails(@PathVariable Long id) {
		Boolean status=employeeService.deleteEmployeeDetails(id);
		return status;
		
	}
	
	@GetMapping("/detailsById/{id}")
	public List<EmployeeDto> EmployeeByIdFetch(@PathVariable Long id) {
		return(employeeService.getEmployeeById(id));
	}
	
	@GetMapping("/search")
	public List<EmployeeDto> EmployeeBasicSearch(@RequestParam(required=false) String searchParam) {
		return(employeeService.basicSearchEmployee(searchParam));
	}
	
	@RequestMapping("/transfer")
	public Boolean TransferEmployee(@Valid @RequestBody TransferDto transferDto) {
		return(transferService.employeeTransfer(transferDto));
	}
	
}
