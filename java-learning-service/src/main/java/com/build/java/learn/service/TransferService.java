package com.build.java.learn.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.build.java.learn.dto.TransferDto;
import com.build.java.learn.entity.CompanyEntity;
import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.entity.TransferEntity;
import com.build.java.learn.mapper.TransferSaveMapper;
import com.build.java.learn.repository.CompanyRepository;
import com.build.java.learn.repository.EmployeeRepository;
import com.build.java.learn.repository.TransferRepository;

@Transactional
@Service
public class TransferService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private TransferRepository transferRepository;
	
	public Boolean employeeTransfer(TransferDto transferDto) {
		try {
			if(transferDto.getId()!=null) {
				Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(transferDto.getId());
				TransferEntity transferEntity=TransferSaveMapper.saveTransfer(transferDto);
				Optional<CompanyEntity> companyEntity=companyRepository.findById(transferDto.getDestinationId());
				if(employeeEntity.get().getId()!=null && companyEntity.get().getId()!=null)
				{
					employeeEntity.get().setCompany(companyEntity.get());
					transferEntity.setEmployeeEntity(employeeEntity.get());
					transferRepository.save(transferEntity);
					return true;
				}
				return false;
			}
			return false;
		}
		catch(Exception ex){
			return false;
		}
	}
	
}
