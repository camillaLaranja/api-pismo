package com.testepismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testepismo.dto.AccountDto;
import com.testepismo.model.Account;
import com.testepismo.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public List<Account> getAll() {
		return accountService.getAll();
	}
	
	@GetMapping("/{account_id}")
	public Account getById(@PathVariable Long account_id) {
		return accountService.getById(account_id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Account save(@RequestBody AccountDto request) {
		return accountService.create(request);
	}
}


