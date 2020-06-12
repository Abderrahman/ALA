package com.lahbabi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lahbabi.dao.TransactionRepository;
import com.lahbabi.models.Client;
import com.lahbabi.models.Compte;
import com.lahbabi.services.BanqueService;
import com.lahbabi.services.ClientService;
import com.lahbabi.services.CompteService;

@SpringBootTest
class BankAccountApplicationTests {

	@Autowired
	BanqueService banqueService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	Client creerNewClient(String nom, String prenom) {

		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client = clientService.creerClient(client);
		return client;
	}
	
	
	Compte creerNewCompteAvecSolde(Long solde){
		
		/**
		 * We use an already created client for the sake of simplicity
		 */
		Client client = clientService.findClientAvecId("5ee22e73ac567c7c33959111");
		
		Compte compte = new Compte();
		compte.setSolde(solde);
		compte.setClient(client);
		compteService.creerCompte(compte);

		return compte;
	}
	
	
	@Test
	void testDepositMoneyInAccount() {
		
		Compte compte = creerNewCompteAvecSolde(100L);
		
		compte = banqueService.depositMoney(compte.getId(), 20L);
		
		assertThat(compte.getSolde()).isEqualTo(120L);
		
	}
	
	@Test
	void testWithdrawMoneyFromAccount() {
		
		Compte compte = creerNewCompteAvecSolde(200L);
		
		compte = banqueService.withdrawMoney(compte.getId(), 20L);
		
		assertThat(compte.getSolde()).isEqualTo(180L);
		
	}
	
	
	@Test
	void testDisplayAccountBalance() {
		
		Compte compte = creerNewCompteAvecSolde(150L);
		
		Long accountBalance = banqueService.accountBalance(compte.getId());
		
		assertThat(accountBalance).isEqualTo(150L);
	}
	
	
	@Test
	void testDisplayAccountTransactionHistory() {
		
		Compte compte = creerNewCompteAvecSolde(0L);
		banqueService.depositMoney(compte.getId(), 20L);
		banqueService.depositMoney(compte.getId(), 100L);
		banqueService.withdrawMoney(compte.getId(), 40L);

		assertThat(banqueService.listTransactions(compte.getId()).size()).isEqualTo(3);
		
		assertThat(banqueService.listTransactions(compte.getId()).get(0).getSum()).isEqualTo(20L);
		
	}
	
}
