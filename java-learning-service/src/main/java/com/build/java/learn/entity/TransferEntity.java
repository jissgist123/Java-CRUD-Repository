package com.build.java.learn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "transferSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters = {
        @Parameter(name = "sequence_name", value = "transfer_id_seq"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name="transfer")
@NamedQuery(name="TransferEntity.findAll", query="SELECT n from TransferEntity n")
public class TransferEntity implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(generator="transferSequence")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private EmployeeEntity employeeEntity;
	
	@Column(name="source_id")
	private Long sourceId;
	
	@Column(name="destination_id")
	private Long destinationId;
	
	@Column(name="modified_time")
	private LocalDateTime modifiedTime;
	
}
