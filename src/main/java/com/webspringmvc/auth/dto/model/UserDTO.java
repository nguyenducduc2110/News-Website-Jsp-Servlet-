package com.webspringmvc.auth.dto.model;

import java.sql.Timestamp;

import com.webspringmvc.core.dto.AbstractDTO;

public class UserDTO extends AbstractDTO{	
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleId;

	private RoleDTO roleDTO;
	public UserDTO(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
		String userName, String fullName, String password, int status, Long roleId, RoleDTO roleDTO) {
	super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	this.userName = userName;
	this.fullName = fullName;
	this.password = password;
	this.status = status;
	this.roleId = roleId;
	this.roleDTO = roleDTO;
}

	public UserDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleDTO getRoleModel() {
		return roleDTO;
	}

	public void setRoleModel(RoleDTO roleDTO) {
		this.roleDTO =  roleDTO;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", status="
				+ status + ", roleId=" + roleId + ", roleModel=" + this.roleDTO + ", getId()=" + getId()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getModifiedDate()=" + getModifiedDate()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getModifiedBy()=" + getModifiedBy() + ", getPage()="
				+ getPage() + ", getMaxPageItem()=" + getMaxPageItem() + ", getTotalPage()=" + getTotalPage()
				+ ", getTotalItem()=" + getTotalItem() + ", getSortName()=" + getSortName() + ", getSortBy()="
				+ getSortBy() + ", toString()=" + super.toString() + "]";
	}

	

	
	
}
