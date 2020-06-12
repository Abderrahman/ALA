package com.lahbabi.models;

import org.springframework.data.annotation.Id;


public class Compte {

	@Id
	String id;
	
	Long solde;
	
	Client client;

	

	public String getId() {
		return id;
	}

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
