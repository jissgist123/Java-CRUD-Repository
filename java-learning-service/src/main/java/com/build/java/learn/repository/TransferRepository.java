package com.build.java.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.build.java.learn.entity.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity,Long>{

}
