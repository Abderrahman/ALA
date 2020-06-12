package com.lahbabi.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lahbabi.models.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

	public List<Transaction> findByCompteId(String compteId);
	
	
}
