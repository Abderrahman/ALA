package com.lahbabi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lahbabi.models.Compte;

@Repository
public interface CompteRepository extends MongoRepository<Compte, String>{

}
