package com.lahbabi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lahbabi.dao.ClientRepository;
import com.lahbabi.models.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepo;
	
	public Client creerClient(Client client) {
		
		return clientRepo.save(client);
		
	}

	@Override
	public Client findClientAvecId(String idClient) {

		return clientRepo.findById(idClient).get();
		
	}
}
