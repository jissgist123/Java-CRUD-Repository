package com.build.java.learn.repository;

import org.springframework.stereotype.Repository;

import com.build.java.learn.entity.EmployeeEntity;
import com.build.java.learn.projection.EmployeeProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long> {
	
	@Query(value="select e.id as id, e.first_name as firstName, e.middle_name as middleName, e.last_name as lastName, "
			+ "e.age as age, e.gender as gender, e.company_id as companyId, ad.address_line1 as addressLine1, ad.address_line2 as addressLine2, ad.state_id as stateId from java.employee as e join java.address ad on e.address_id=ad.address_id", nativeQuery=true)
	List<EmployeeProjection> findAllEmployeeList();

	@Query(value="select e.id as id, e.first_name as firstName, e.middle_name as middleName, e.last_name as lastName, "
			+ "e.age as age, e.gender as gender, ad.address_line1 as addressLine1, ad.address_line2 as addressLine2, ad.state_id as stateId "
			+ "from java.employee as e join java.address ad on e.address_id=ad.address_id where e.first_name like %:searchParam% "
			+ "or e.middle_name like %:searchParam% or e.last_name like %:searchParam% or ad.address_line1 like %:searchParam% "
			+ "or ad.address_line2 like %:searchParam%",nativeQuery=true)
	List<EmployeeProjection> findBasicSearch(@Param("searchParam") String searchParam);
}
