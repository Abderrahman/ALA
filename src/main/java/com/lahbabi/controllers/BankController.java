package com.lahbabi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lahbabi.models.Transaction;
import com.lahbabi.services.BanqueService;

@RestController
public class BankController {

	@Autowired
	BanqueService banqueService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/account/depositMoney")
	public void depositMoney(@RequestParam String compteId, @RequestParam Long sum){
		
		
		banqueService.depositMoney(compteId, sum);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/account/withdrawMoney")
	public void withdrawMoney(@RequestParam String compteId, @RequestParam Long sum){
		
		banqueService.withdrawMoney(compteId, sum);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/account/{accountId}/balance")
	@ResponseBody
	public Long getAccountBalance(@PathVariable final String accountId){
		
		return banqueService.accountBalance(accountId);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/account/{accountId}/transactions")
	@ResponseBody
	public List<Transaction> getListTransactions(@PathVariable final String accountId){
		
		return banqueService.listTransactions(accountId);
	}
	
	
}
