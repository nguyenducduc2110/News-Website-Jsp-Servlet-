package com.webspringmvc.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.webspringmvc.auth.dto.model.UserDTO;
import com.webspringmvc.dao.IUserDAO;
import com.webspringmvc.mapper.UserMapper;
@Repository
public class UserDAO extends AbstractDAO<UserDTO> implements IUserDAO{
	
	@Override
	public UserDTO findByUserNamePasswordAndStatus(String userName, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE u.name = ? AND u.password = ?");
		ArrayList<UserDTO> users = queryList(sql.toString(), new UserMapper(), userName, password);
		return users.isEmpty() ? null : users.get(0);
	}
	@Override
	public UserDTO findOne(Long id) {
		ArrayList<UserDTO	> arrayList = super.queryList("select * from user where id = ?;", new UserMapper(), id);
		return arrayList.isEmpty() ? null: arrayList.get(0);
	}
}
