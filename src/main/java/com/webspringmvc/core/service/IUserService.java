package com.webspringmvc.core.service;

import com.webspringmvc.auth.dto.model.UserDTO;

public interface IUserService {
	public abstract UserDTO findByUserNamePasswordAndStatus(String userName, String password);
	UserDTO findOne(Long id);
}
