package com.webspringmvc.core.service;

import java.util.ArrayList;

import com.webspringmvc.core.dto.CategoryDTO;


public interface ICategoryService  {
	public abstract ArrayList<CategoryDTO> findAll();
	public abstract CategoryDTO findById(Long id);

}
