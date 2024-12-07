package com.webspringmvc.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webspringmvc.core.dto.NewsDTO;
import com.webspringmvc.core.service.INewsService;
import com.webspringmvc.dao.INewsDAO;
import com.webspringmvc.paging.Pageable;

@Service
public class NewsService implements INewsService{

	@Autowired
	private INewsDAO newsDAO;
	
	@Override
	public NewsDTO findByCategoryId(Long id) {
		return newsDAO.findByCategoryId(id);
	}
	
	
	@Override
	public NewsDTO save(NewsDTO newsDTO) {
		newsDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = newsDAO.save(newsDTO);
		return newsDAO.findOne(id);
		
	}

	@Override
	public NewsDTO update(NewsDTO newsDTO) {
	    Long id = newsDTO.getId();
	    NewsDTO newsModelOld = newsDAO.findOne(id);
	    newsModelOld.setModifiedDate(new Timestamp(System.currentTimeMillis()));

	    if (newsDTO.getTitle() != null) {
	        newsModelOld.setTitle(newsDTO.getTitle());
	    }
	    if (newsDTO.getThumbnail() != null) {
	        newsModelOld.setThumbnail(newsDTO.getThumbnail());
	    }
	    if (newsDTO.getShortDescription() != null) {
	        newsModelOld.setShortDescription(newsDTO.getShortDescription());
	    }
	    if (newsDTO.getCategoryId() != null) {
	        newsModelOld.setCategoryId(newsDTO.getCategoryId());
	    }
	    if (newsDTO.getModifiedDate() != null) {
	        newsModelOld.setModifiedDate(newsDTO.getModifiedDate());
	    }
	    if (newsDTO.getModifiedBy() != null) {
	        newsModelOld.setModifiedBy(newsDTO.getModifiedBy());
	    }

	    
	    newsDAO.update(newsModelOld);
	    return newsDAO.findOne(id);
	}


	@Override
	public void delete(Long[] id) {
		for (Long idNews : id) {
			
			
			
			newsDAO.delete(idNews);
		}
	}

	@Override
	public ArrayList<NewsDTO> findAll(Pageable pageable) {
		return newsDAO.findAll(pageable);
	}

	@Override
	public NewsDTO findOne(Long id) {
		return newsDAO.findOne(id);
	}
	
}
