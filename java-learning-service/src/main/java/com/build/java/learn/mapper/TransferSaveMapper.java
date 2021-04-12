package com.build.java.learn.mapper;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.build.java.learn.dto.TransferDto;
import com.build.java.learn.entity.CompanyEntity;
import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.entity.TransferEntity;
import com.build.java.learn.repository.CompanyRepository;

public class TransferSaveMapper {

	
	public static TransferEntity saveTransfer(TransferDto transferDto) {
		TransferEntity transferEntity=new TransferEntity();
		transferEntity.setSourceId(transferDto.getSourceId());
		transferEntity.setDestinationId(transferDto.getDestinationId());
		transferEntity.setModifiedTime(LocalDateTime.now());
		
		return transferEntity;
	}
}
