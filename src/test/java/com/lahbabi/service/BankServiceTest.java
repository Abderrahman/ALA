package com.lahbabi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lahbabi.dao.BanqueRepository;
import com.lahbabi.dao.CompteRepository;
import com.lahbabi.dao.TransactionRepository;
import com.lahbabi.models.Compte;
import com.lahbabi.models.Transaction;
import com.lahbabi.services.BanqueServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {


	@InjectMocks
	private BanqueServiceImpl banqueService;
	
	@Mock
	private BanqueRepository banqueRepo;

	@Mock
	private CompteRepository compteRepo;

	@Mock
	private TransactionRepository transactionRepo;
	

	@Test
	public void testDepositMoney() {
		Optional<Compte> compteMock = Optional.of(new Compte());
		compteMock.get().setSolde(50L);		
		when(compteRepo.findById("MyId")).thenReturn(compteMock);
		
		Compte compte = banqueService.depositMoney("MyId", 10L);
		assertThat(compte.getSolde()).isEqualTo(compteMock.get().getSolde());
	}
	
	
	@Test
	public void testWithdrawMoney() {
		
		Optional<Compte> compteMock = Optional.of(new Compte());
		compteMock.get().setSolde(100L);		
		when(compteRepo.findById("MyId")).thenReturn(compteMock);
		
		Compte compte = banqueService.withdrawMoney("MyId", 50L);
		assertThat(compte.getSolde()).isEqualTo(compteMock.get().getSolde());
	}
	
	@Test
	public void testAccountBalance() {
		
		Optional<Compte> compteMock = Optional.of(new Compte());
		compteMock.get().setSolde(10L);		
		when(compteRepo.findById("MyId")).thenReturn(compteMock);
		
		Long accountBalance = banqueService.accountBalance("MyId");
		assertThat(accountBalance).isEqualTo(compteMock.get().getSolde());
	}
	
	@Test
	public void testListTransactions() {
		
		Optional<Compte> compteMock = Optional.of(new Compte());
		compteMock.get().setSolde(0L);		
		when(compteRepo.findById("MyId")).thenReturn(compteMock);

		List<Transaction> listTransactions = new LinkedList<Transaction>();
		Transaction firstTransaction  = new Transaction();
		firstTransaction.setSum(20L);
		
		Transaction secondTransaction  = new Transaction();
		secondTransaction.setSum(100L);
		listTransactions.add(firstTransaction);
		listTransactions.add(secondTransaction);
		
		when(transactionRepo.findByCompteId("MyId")).thenReturn(listTransactions);
		
		banqueService.depositMoney("MyId", 20L);
		banqueService.depositMoney("MyId", 100L);

		assertThat(banqueService.listTransactions("MyId").size()).isEqualTo(2);		
		assertThat(banqueService.listTransactions("MyId").get(1).getSum()).isEqualTo(100L);

		
	}

}
