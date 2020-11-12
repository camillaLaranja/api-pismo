package com.testepismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperationType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long operationType_id; 
	
	@Column
	public String description;
	
	
    public OperationType() {

    }

    public OperationType(Long operationType_id, String description) {
        this.operationType_id = operationType_id;
        this.description = description;
    }

	public Long getOperationType_id() {
		return operationType_id;
	}

	public void setOperationType_id(Long operationType_id) {
		this.operationType_id = operationType_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	
	
}
