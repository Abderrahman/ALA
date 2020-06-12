package com.lahbabi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lahbabi.models.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{
	
}
