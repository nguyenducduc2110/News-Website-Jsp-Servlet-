package com.webspringmvc.core.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webspringmvc.core.dto.CategoryDTO;
import com.webspringmvc.core.service.ICategoryService;
import com.webspringmvc.dao.ICategoryDAO;


@Service
public class CategoryService  implements ICategoryService{






	@Autowired 
	private ICategoryDAO iCategoryDAO;

	@Override
	public ArrayList<CategoryDTO> findAll() {
		return iCategoryDAO.findAll();
	}
	
	@Override
	public CategoryDTO findById(Long id) {
		return iCategoryDAO.findById(id);
	}
	
}
