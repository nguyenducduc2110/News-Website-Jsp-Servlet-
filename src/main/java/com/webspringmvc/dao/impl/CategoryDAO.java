package com.webspringmvc.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.webspringmvc.core.dto.CategoryDTO;
import com.webspringmvc.dao.ICategoryDAO;
import com.webspringmvc.mapper.CategoryMapper;


@Repository
public class CategoryDAO extends AbstractDAO<CategoryDTO> implements ICategoryDAO{
	@Override
	 public ArrayList<CategoryDTO> findAll(){
		 return super.queryList("select * from category", new CategoryMapper());
	 }
	@Override
	public CategoryDTO findById(Long id) {
		ArrayList<CategoryDTO>  arrayList = super.queryList("select * from category where id = ?", new CategoryMapper(), id);
		return arrayList.isEmpty() ? null : arrayList.get(0);
	}
	









































}
