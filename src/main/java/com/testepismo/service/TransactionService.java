package com.testepismo.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testepismo.dto.TransactionDto;
import com.testepismo.model.Account;
import com.testepismo.model.OperationType;
import com.testepismo.model.Transaction;
import com.testepismo.repository.AccountRepository;
import com.testepismo.repository.OperationTypeRepository;
import com.testepismo.repository.TransactionRepository;

import javassist.NotFoundException;

@Service
public class TransactionService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OperationTypeRepository operationTypeRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction create(TransactionDto request) throws Exception {

		if (request == null) throw new Exception("Favor informar os dados necessários para uma nova Transação");
		
		Boolean findAccount = accountRepository.existsById(request.getAccount_id());
		
		if(!findAccount) {
			throw new Exception("Favor informar os dados necessários para uma nova Transação");
		}
		
		Account account = accountRepository.findById(request.getAccount_id()).get();
		
		if (account == null) throw new NotFoundException("A conta informado não existe");
		
		if (request.getOperation_type_id() <= 0) throw new InvalidParameterException("O valor informado para operação é invalido");

		OperationType operationType = operationTypeRepository.findById(request.getOperation_type_id()).get();
		
		if (operationType == null) throw new NotFoundException("A operação informada não existe");
		
        if (request.getAmount() <= 0) throw new InvalidParameterException("Informe um valor maior do que zero");
		
		Transaction transaction = new Transaction(account, operationType, request.getAmount());
		
		return transactionRepository.save(transaction);

	}
	
    public List<Transaction> getAll() {
        return transactionRepository.findAll(); 
    }
}
