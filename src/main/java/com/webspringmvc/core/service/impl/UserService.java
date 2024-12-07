package com.webspringmvc.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webspringmvc.auth.dto.model.UserDTO;
import com.webspringmvc.core.service.IUserService;
import com.webspringmvc.dao.IUserDAO;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDAO userDAO;
	@Override
	public UserDTO findByUserNamePasswordAndStatus(String userName, String password) {
		return userDAO.findByUserNamePasswordAndStatus(userName, password);
	}
	@Override
	public UserDTO findOne(Long id) {
		return userDAO.findOne(id);
	}
	
	
}
