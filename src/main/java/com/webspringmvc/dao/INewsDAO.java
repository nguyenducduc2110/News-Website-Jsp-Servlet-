package com.webspringmvc.dao;

import java.util.ArrayList;

import com.webspringmvc.core.dto.NewsDTO;
import com.webspringmvc.paging.Pageable;

public interface INewsDAO {
	public abstract NewsDTO findByCategoryId(Long id);
	
	Long save(NewsDTO newsDTO);
	void update(NewsDTO newsDTO);
	NewsDTO findOne(Long id);
	void delete(Long id);
	ArrayList<NewsDTO> findAll(Pageable pageable);
	
}
