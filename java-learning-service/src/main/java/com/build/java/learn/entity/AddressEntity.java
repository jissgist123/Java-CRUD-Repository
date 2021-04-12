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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.build.java.learn.entity.StateEntity;


@GenericGenerator(name = "addressSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters = {
        @Parameter(name = "sequence_name", value = "address_id_seq"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name="address")
@NamedQuery(name="AddressEntity.findAll",query="SELECT n from AddressEntity n")
public class AddressEntity implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(generator="addressSequence")
	@Column(unique = true, nullable = false)
	private Long addressId;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private StateEntity state;

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	@OneToMany(mappedBy = "address")
	private Set<EmployeeEntity> employeeEntity;
	
	public Set<EmployeeEntity> getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(Set<EmployeeEntity> employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	
}
