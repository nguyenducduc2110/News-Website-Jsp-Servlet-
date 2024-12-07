package com.webspringmvc.controller.admin;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webspringmvc.core.dto.NewsDTO;
import com.webspringmvc.core.service.INewsService;
import com.webspringmvc.paging.PageRequest;
import com.webspringmvc.paging.Pageable;
import com.webspringmvc.sort.Sorter;

@Controller("newsControllerOfAdmin")
public class NewsController {
	@Autowired
	private INewsService newsService;
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showListNews(@ModelAttribute("newsModel") NewsDTO newsDTO) {
		ModelAndView modelAndView = new ModelAndView("admin/news/list");
		Pageable pageable = new PageRequest(newsDTO.getPage(), newsDTO.getMaxPageItem(),
				new Sorter(newsDTO.getSortName(), newsDTO.getSortBy()));
		ArrayList<NewsDTO> offsetBeganOfListNews = newsService.findAll(pageable);
		ArrayList<NewsDTO> allNews = newsService.findAll(new PageRequest(null, null, null));
		newsDTO.setTotalPage((int)Math.ceil((allNews.size()+1)/newsDTO.getMaxPageItem()));
		modelAndView.addObject("newsModel", newsDTO);
		modelAndView.addObject("list", offsetBeganOfListNews);

		return modelAndView;
	}
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNews() {
		ModelAndView andView = new ModelAndView("admin/news/edit");
		return andView;
	}
}
