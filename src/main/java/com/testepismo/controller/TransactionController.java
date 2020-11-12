package com.testepismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testepismo.dto.TransactionDto;
import com.testepismo.model.Transaction;
import com.testepismo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction save(@RequestBody TransactionDto request) throws Exception {
		return transactionService.create(request);
	}
	
	@GetMapping
	public List<Transaction> getAll() {
		return transactionService.getAll();
	}
}
