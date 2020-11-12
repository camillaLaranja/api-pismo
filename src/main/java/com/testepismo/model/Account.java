package com.testepismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long account_id;
	
	@Column
	public Long document_number;
	
	public Account() {}
	
	public Account(Long document_number) {
		this.document_number = document_number;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public Long getDocument_number() {
		return document_number;
	}

	public void setDocument_number(Long document_number) {
		this.document_number = document_number;
	}
	
	
	
}
