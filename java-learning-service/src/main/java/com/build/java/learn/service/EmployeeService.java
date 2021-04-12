package com.build.java.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.build.java.learn.dto.EmployeeDto;
import com.build.java.learn.entity.AddressEntity;
import com.build.java.learn.entity.CompanyEntity;
import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.entity.StateEntity;
import com.build.java.learn.mapper.EmployeeDetailsMapper;
import com.build.java.learn.mapper.EmployeeEditMapper;
import com.build.java.learn.mapper.EmployeeSaveMapper;
import com.build.java.learn.projection.EmployeeProjection;
import com.build.java.learn.repository.AddressRepository;
import com.build.java.learn.repository.CompanyRepository;
import com.build.java.learn.repository.EmployeeRepository;
import com.build.java.learn.repository.StateRepository;

@Transactional
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<EmployeeDto> getAllEmployeeList(){
		
		List<EmployeeDto> employeeDto=new ArrayList<EmployeeDto>();
		List<EmployeeProjection> employeeProjection = employeeRepository.findAllEmployeeList();
		
		employeeProjection.forEach(ele->{
			EmployeeDto employee=new EmployeeDto();
			Optional<StateEntity> stateEntity=stateRepository.findById(ele.getStateId());
			Optional<CompanyEntity> companyEntity=companyRepository.findById(ele.getCompanyId());
			employee.setId(ele.getId());
			employee.setFirstName(ele.getFirstName());
			employee.setMiddleName(ele.getMiddleName());
			employee.setLastName(ele.getLastName());
			employee.setAge(ele.getAge());
			employee.setGender(ele.getGender());
			employee.setAddressLine1(ele.getAddressLine1());
			employee.setAddressLine2(ele.getAddressLine2());
			employee.setStateName(stateEntity.get().getName());
			employee.setCompanyName(companyEntity.get().getName());
			employeeDto.add(employee);
		});
		
		return employeeDto;
	}
public List<EmployeeDto> basicSearchEmployee(String searchParam){
		
		List<EmployeeDto> employeeDto=new ArrayList<EmployeeDto>();
		List<EmployeeProjection> employeeProjection = employeeRepository.findBasicSearch(searchParam);
		
		employeeProjection.forEach(ele->{
			EmployeeDto employee=new EmployeeDto();
			Optional<StateEntity> stateEntity=stateRepository.findById(ele.getStateId());
			Optional<CompanyEntity> companyEntity=companyRepository.findById(ele.getCompanyId());
			employee.setId(ele.getId());
			employee.setFirstName(ele.getFirstName());
			employee.setMiddleName(ele.getMiddleName());
			employee.setLastName(ele.getLastName());
			employee.setAge(ele.getAge());
			employee.setGender(ele.getGender());
			employee.setAddressLine1(ele.getAddressLine1());
			employee.setAddressLine2(ele.getAddressLine2());
			employee.setStateName(stateEntity.get().getName());
			employee.setCompanyName(companyEntity.get().getName());
			employeeDto.add(employee);
		});
		
		return employeeDto;
	}
	
	public Boolean saveEmployeeDetails(EmployeeDto employeeDto) {
		try {
			if(employeeDto.getId()!=null) {
				Optional<EmployeeEntity> optionalEntity=employeeRepository.findById(employeeDto.getId());
				EmployeeEntity entity=optionalEntity.get();
				Optional<StateEntity> optionalStateEntity=stateRepository.findById(employeeDto.getStateId());
				Optional<AddressEntity> optionalAddressEntity=addressRepository.findById(entity.getAddress().getAddressId());
				Optional<CompanyEntity> optionalCompanyEntity=companyRepository.findById(employeeDto.getCompanyId());
				AddressEntity addressEntity=optionalAddressEntity.get();
				if(optionalStateEntity.isPresent() && optionalAddressEntity.isPresent() && optionalCompanyEntity.isPresent()) {
					AddressEntity address=EmployeeEditMapper.mapToAddress(addressEntity,employeeDto);
					entity = EmployeeEditMapper.mapToEmployee(entity, employeeDto);
					entity.setAddress(address);
					employeeRepository.save(entity);
				}
				else
					return false;
			}
			else {
					Optional<StateEntity> optionalEntity=stateRepository.findById(employeeDto.getStateId());
					Optional<CompanyEntity> optionalCompanyEntity=companyRepository.findById(employeeDto.getCompanyId());
					if(optionalEntity.isPresent() && optionalCompanyEntity.isPresent()) {
						AddressEntity address=EmployeeSaveMapper.mapToAddress(employeeDto);
						EmployeeEntity employeeEntity = EmployeeSaveMapper.mapToEmployee(employeeDto);
						employeeEntity.setAddress(address);
						employeeRepository.save(employeeEntity);
					}
					else
						return false;
			}
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public Boolean deleteEmployeeDetails(Long id) {
		if(id!=null) {
			Optional<EmployeeEntity> optionalEntity=employeeRepository.findById(id);
			if(optionalEntity.isPresent()) {
				EmployeeEntity entity = optionalEntity.get();
				Optional<AddressEntity> optionalAddressEntity=addressRepository.findById(entity.getAddress().getAddressId());
				AddressEntity addr=optionalAddressEntity.get();
				
				employeeRepository.delete(entity);
				addressRepository.delete(addr);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public List<EmployeeDto> getEmployeeById(Long id){
		List<EmployeeDto> employeeDto=new ArrayList<EmployeeDto>();
		if(id!=null) {
			Optional<EmployeeEntity> optionalEntity=employeeRepository.findById(id);
			if(optionalEntity.isPresent()) {
				EmployeeEntity entity = optionalEntity.get();
				Optional<AddressEntity> optionalAddressEntity=addressRepository.findById(entity.getAddress().getAddressId());
				Optional<StateEntity> optionalStateEntity=stateRepository.findById(optionalAddressEntity.get().getState().getId());
				EmployeeDto dto=EmployeeDetailsMapper.mapToEmployeeDto(entity, optionalAddressEntity.get(), optionalStateEntity.get());
				employeeDto.add(dto);
			}
		}
		
		return employeeDto;
	}
}
