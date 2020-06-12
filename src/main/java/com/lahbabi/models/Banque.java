package com.lahbabi.models;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;


public class Banque {
	
	@Id
	String id;
	
	String nom;
	

	List<Client> listClient;
	
	public Banque() {
		listClient = new LinkedList<Client>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public void ajouterClient(Client client) {

		listClient.add(client);
		
	}
	
	
}
