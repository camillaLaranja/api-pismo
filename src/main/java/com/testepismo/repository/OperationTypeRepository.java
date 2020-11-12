package com.testepismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testepismo.model.OperationType;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {

}
