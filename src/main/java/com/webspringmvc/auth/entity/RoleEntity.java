package com.webspringmvc.auth.entity;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.webspringmvc.entity.BaseEntity;

@Entity(name = "role")
@Table(name="role")
public class RoleEntity extends BaseEntity{
	@Column(name= "name", length = 255)
	private String name;
	@Column(name = "code")
	private String code;
	@ManyToMany(mappedBy = "roles")
	private java.util.List<UserEntity> users;
	public RoleEntity() {
		super();
	}
	public RoleEntity(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String name, String code, java.util.List<UserEntity> users) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.name = name;
		this.code = code;
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public java.util.List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(java.util.List<UserEntity> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "RoleEntity [name=" + name + ", code=" + code + ", users=" + users + ", toString()=" + super.toString()
				+ "]";
	}
	
}
