package com.webspringmvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.webspringmvc.auth.dto.model.RoleDTO;
import com.webspringmvc.auth.dto.model.UserDTO;




public class UserMapper implements IRowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet resultSet) {
		try {
			UserDTO user = new UserDTO();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("name"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setStatus(resultSet.getInt("status"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			user.setCreatedBy(resultSet.getString("createdby"));
			user.setModifiedBy(resultSet.getString("modifiedby"));
			
			
			
			try {
				RoleDTO roleDTO = new RoleDTO();
				roleDTO.setCode(resultSet.getString("code"));
				roleDTO.setName(resultSet.getString(12));
				roleDTO.setId(resultSet.getLong("id"));
				user.setRoleModel(roleDTO);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
