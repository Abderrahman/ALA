package com.lahbabi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lahbabi.dao.BanqueRepository;
import com.lahbabi.dao.CompteRepository;
import com.lahbabi.dao.TransactionRepository;
import com.lahbabi.models.Banque;
import com.lahbabi.models.Compte;
import com.lahbabi.models.Transaction;

@Service
@Transactional
public class BanqueServiceImpl implements BanqueService {

	final static String TYPE_WITHDRAW = "Withdraw";
	final static String TYPE_DEPOSIT = "Deposit";

	@Autowired
	BanqueRepository banqueRepo;

	@Autowired
	CompteRepository compteRepo;

	@Autowired
	TransactionRepository TransactionRepo;

	/**
	 * US 1: Deposit money from a customer to his account, is allowed when superior
	 * to €0.01
	 * 
	 * @param compte
	 * @param sum
	 * @return
	 */

	public Compte depositMoney(String compteId, Long sum) {

		Compte compte = compteRepo.findById(compteId).get();

		if (compte != null && sum > 0.01) {
			Transaction transaction = new Transaction();
			transaction.setSum(sum);
			transaction.setType(TYPE_DEPOSIT);
			transaction.setDate(LocalDate.now());
			transaction.setCompte(compte);
			TransactionRepo.save(transaction);

			compte.setSolde(compte.getSolde() + sum);
			compteRepo.save(compte);
			return compte;
		}else
			return null;
	}

	/**
	 * 
	 * As a bank, withdraw money from a customer account, is allowed when no
	 * overdraft used
	 * 
	 * @param compte
	 * @param sum
	 * @return
	 */

	public Compte withdrawMoney(String compteId, Long sum) {

		Compte compte = compteRepo.findById(compteId).get();

		if (compte != null && compte.getSolde() - sum > 0) {

			Transaction transaction = new Transaction();
			transaction.setSum(sum);
			transaction.setType(TYPE_WITHDRAW);
			transaction.setDate(LocalDate.now());
			transaction.setCompte(compte);
			TransactionRepo.save(transaction);

			compte.setSolde(compte.getSolde() - sum);
			compteRepo.save(compte);
			return compte;
		}else
			return null;
	}

	/**
	 * As a bank, a customer can display its account balance
	 *
	 * @param compte
	 */

	public Long accountBalance(String compteId) {

		Compte compte = compteRepo.findById(compteId).get();
		return compte.getSolde();

	}

	/**
	 * As a bank, a customer can display its account transactions history
	 */
	@Override
	public List<Transaction> listTransactions(String compteId) {

		return TransactionRepo.findByCompteId(compteId);

	}

	@Override
	public Banque creerBanque(Banque banque) {

		return banqueRepo.save(banque);
	}

}
