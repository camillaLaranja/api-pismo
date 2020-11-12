package com.testepismo.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transaction_id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Account account;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "operationType_id")
    public OperationType operationType;

	@Column
	private Double amount;

	@Column
	private Calendar eventDate;
	
    public Transaction() {}
    
    public Transaction(Account account, OperationType operationType, Double amount) {
        this.account = account;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = Calendar.getInstance();
    }

	public Long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}

}
