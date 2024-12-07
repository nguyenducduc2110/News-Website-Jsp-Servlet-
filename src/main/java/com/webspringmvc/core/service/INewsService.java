package com.webspringmvc.core.service;

import java.util.ArrayList;

import com.webspringmvc.core.dto.NewsDTO;
import com.webspringmvc.paging.Pageable;

public interface INewsService {
	public abstract NewsDTO findByCategoryId(Long id);
	
	NewsDTO save(NewsDTO newsDTO);
	NewsDTO update(NewsDTO newsDTO);
	void delete (Long[] id);
	 ArrayList<NewsDTO> findAll(Pageable pageable);
	 NewsDTO findOne(Long id);
}
