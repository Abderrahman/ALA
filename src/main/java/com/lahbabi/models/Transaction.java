package com.lahbabi.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class Transaction {

	@Id
	String id;

	Long Sum;
	
	LocalDate date;
	
	String type;
	
	Compte compte;

	
	
	public Long getSum() {
		return Sum;
	}

	public void setSum(Long sum) {
		Sum = sum;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
