package com.lahbabi.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Client {

	
	@Id
	String id;
	
	String nom;
	
	String prenom;
	
	List<Compte> listComptes;

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Compte> getListComptes() {
		return listComptes;
	}

	public void setListComptes(List<Compte> listComptes) {
		this.listComptes = listComptes;
	}
	
	
	
	
}
