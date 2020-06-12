package com.lahbabi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lahbabi.dao.CompteRepository;
import com.lahbabi.models.Compte;

@Service
public class CompteServiceImpl implements CompteService{

	@Autowired
	CompteRepository compteRepo;
	
	@Override
	public Compte creerCompte(Compte compte) {

		return compteRepo.save(compte);
	}

}
