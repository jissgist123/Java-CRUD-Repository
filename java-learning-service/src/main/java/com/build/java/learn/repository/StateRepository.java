package com.build.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.build.java.learn.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository <StateEntity, Long>{

}
