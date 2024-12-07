package com.webspringmvc.auth.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.webspringmvc.entity.BaseEntity;

@Entity(name = "user")
@Table(name="user")
public class UserEntity extends BaseEntity{
	@Column(name="username", length = 150, unique = true)
	private String userName;
	@Column(name= "password", length = 150)
	private String password;
	@Column(name="fullname", length = 150)
	private String fullName;
	@Column(name= "status")
	private Integer status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "user_role",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private java.util.List<RoleEntity>  roles;
	public UserEntity() {
		super();
	}
	public UserEntity(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String userName, String password, String fullName, Integer status, java.util.List<RoleEntity> roles) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public java.util.List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(java.util.List<RoleEntity> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", status="
				+ status + ", roles=" + roles + ", toString()=" + super.toString() + "]";
	}
	
}