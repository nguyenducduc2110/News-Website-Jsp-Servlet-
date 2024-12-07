package com.webspringmvc.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@CreatedDate
	@Column(name = "createddate")
	protected Timestamp createdDate;
	@LastModifiedDate
	@Column(name = "modifieddate")
	protected Timestamp modifiedDate;
	@CreatedBy
	@Column(name = "createdby")	
	protected String createdBy;
	@LastModifiedBy
	@Column(name = "modifiedby")
	protected String modifiedBy;
	
	public BaseEntity() {
		
	}
	public BaseEntity(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}




	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public Long getId() {
		return id;
	}
	
	
}
