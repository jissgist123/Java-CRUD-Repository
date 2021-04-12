package com.build.java.learn.mapper;

import com.build.java.learn.dto.EmployeeDto;
import com.build.java.learn.entity.AddressEntity;
import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.entity.StateEntity;

public class EmployeeDetailsMapper {

	public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity, AddressEntity addr, StateEntity stateEn) {
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employeeEntity.getId());
		employeeDto.setFirstName(employeeEntity.getFirstName());
		employeeDto.setMiddleName(employeeEntity.getMiddleName());
		employeeDto.setLastName(employeeEntity.getLastName());
		employeeDto.setAge(employeeEntity.getAge());
		employeeDto.setGender(employeeEntity.getGender());
		employeeDto.setAddressLine1(addr.getAddressLine1());
		employeeDto.setAddressLine2(addr.getAddressLine2());
		employeeDto.setStateId(stateEn.getId());
		return employeeDto;
	}
}
