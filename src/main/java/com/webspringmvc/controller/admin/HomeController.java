package com.webspringmvc.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller("homeControllerOfAdmin")
public class HomeController {
	@RequestMapping(value = {"/quan-tri/trang-chu"}, method = RequestMethod.GET )
	public ModelAndView listProducts() {
		ModelAndView andView = new ModelAndView("admin/home");
		
		return andView;
	}
}
