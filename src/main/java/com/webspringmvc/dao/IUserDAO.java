package com.webspringmvc.dao;

import com.webspringmvc.auth.dto.model.UserDTO;

public interface IUserDAO {
	public abstract UserDTO findByUserNamePasswordAndStatus(String userName, String password);
	UserDTO findOne(Long id);
}
