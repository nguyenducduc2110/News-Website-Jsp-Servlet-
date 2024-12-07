package com.webspringmvc.dao;

import java.util.ArrayList;

import com.webspringmvc.core.dto.CategoryDTO;




public interface ICategoryDAO {
	public abstract ArrayList<CategoryDTO> findAll();
	public abstract CategoryDTO findById(Long id);
}
