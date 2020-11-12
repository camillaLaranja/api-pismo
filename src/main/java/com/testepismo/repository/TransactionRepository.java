package com.testepismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testepismo.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}