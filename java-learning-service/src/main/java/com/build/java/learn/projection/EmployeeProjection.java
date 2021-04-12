package com.build.java.learn.projection;

public interface EmployeeProjection {

	public Long getId();
	
	public String getFirstName();
	public void setFirstName(String firstName);
	
	public String getMiddleName();
	public void setMiddleName(String middleName);
	
	public String getLastName();
	public void setLastName(String lastName);
	
	public String getAge();
	public void setAge(String age);
	
	public String getGender();
	public void setGender(String gender);
	
	public String getAddressLine1();
	public void setAddressLine1(String addressLine1);
	
	public String getAddressLine2();
	public void setAddressLine2(String addressLine2);
	
	public Long getCompanyId();
	public void setCompanyId(Long companyId);
	
	public Long getStateId();
	public void setStateId(Long stateId);
	
}
