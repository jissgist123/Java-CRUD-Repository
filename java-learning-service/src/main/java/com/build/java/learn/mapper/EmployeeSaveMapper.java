package com.build.java.learn.mapper;

import com.build.java.learn.dto.EmployeeDto;
import com.build.java.learn.entity.AddressEntity;
import com.build.java.learn.entity.CompanyEntity;
import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.entity.StateEntity;

public class EmployeeSaveMapper {
	
	public static EmployeeEntity mapToEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setMiddleName(employeeDto.getMiddleName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setAge(employeeDto.getAge());
		employeeEntity.setGender(employeeDto.getGender());
		CompanyEntity com = new CompanyEntity();
		com.setId(employeeDto.getCompanyId());
		employeeEntity.setCompany(com);
		employeeEntity.setIsWorking(true);
		return employeeEntity;
	}
	
	public static AddressEntity mapToAddress(EmployeeDto employeeDto) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressLine1(employeeDto.getAddressLine1());
		addressEntity.setAddressLine2(employeeDto.getAddressLine2());
		StateEntity stateEntity= new StateEntity();
		stateEntity.setId(employeeDto.getStateId());	
		addressEntity.setState(stateEntity);
		return addressEntity;
		
	}

}
