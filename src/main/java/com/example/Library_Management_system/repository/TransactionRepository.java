package com.example.Library_Management_system.repository;

import com.example.Library_Management_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TransactionRepository extends JpaRepository<Transaction,Integer> {
}
