package com.testepismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testepismo.dto.AccountDto;
import com.testepismo.model.Account;
import com.testepismo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account create(AccountDto request) {
		
		Account account = new Account(request.getDocument_number());
		
		return accountRepository.save(account);
	}
	
	public List<Account> getAll(){
		return accountRepository.findAll();
	}
	
	public Account getById(Long account_id) {
		return accountRepository.findById(account_id).get();
	}

}
