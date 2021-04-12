package com.build.java.learn.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "employeeSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters = {
        @Parameter(name = "sequence_name", value = "employee_id_seq"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="employee")
@NamedQuery(name="EmployeeEntity.findAll",query="SELECT n FROM EmployeeEntity n")
public class EmployeeEntity implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(generator="employeeSequence")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private String age;
	
	@Column(name="gender")
	private String gender;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private AddressEntity address;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
	
	 @OneToMany(mappedBy = "employeeEntity")
	 private Set<TransferEntity> transferEntity;

	
	@Column(name="is_working")
	private Boolean isWorking;

	public Boolean getIsWorking() {
		return isWorking;
	}

	public Set<TransferEntity> getTransferEntity() {
		return transferEntity;
	}

	public void setTransferEntity(Set<TransferEntity> transferEntity) {
		this.transferEntity = transferEntity;
	}

	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	
}
