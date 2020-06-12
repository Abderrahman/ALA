package com.lahbabi.services;

import com.lahbabi.models.Client;

public interface ClientService {

	public Client creerClient(Client client);
	
	public Client findClientAvecId(String idClient);
	
	
}
