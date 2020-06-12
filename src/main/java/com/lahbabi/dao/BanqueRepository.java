package com.lahbabi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lahbabi.models.Banque;

@Repository
public interface BanqueRepository extends MongoRepository<Banque, String> {
	
}