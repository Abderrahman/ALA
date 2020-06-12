package com.lahbabi.services;

import java.util.List;

import com.lahbabi.models.Banque;
import com.lahbabi.models.Compte;
import com.lahbabi.models.Transaction;


public interface BanqueService {

	public Compte depositMoney(String compteId, Long sum);
	
	public Compte withdrawMoney(String compteId, Long sum);
	
	public Long accountBalance(String compteId);
	
	public List<Transaction> listTransactions(String compteId);

	public Banque creerBanque(Banque banque);
	
}
