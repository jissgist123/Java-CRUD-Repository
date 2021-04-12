package com.build.java.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="master_company")
@NamedQuery(name="CompanyEntity.findAll",query="SELECT n from CompanyEntity n")
public class CompanyEntity {

	@Id
	private Long Id;
	
	@Column(name="name")
	private String name;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
