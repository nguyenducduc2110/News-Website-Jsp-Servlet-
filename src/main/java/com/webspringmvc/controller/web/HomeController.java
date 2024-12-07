package com.webspringmvc.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = {"/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView andView = new ModelAndView("web/home");
		return andView;
	}
	
	@RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView andView = new ModelAndView("login");		
		return andView;
	}
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.GET)
	public ModelAndView registerPage() {
		ModelAndView andView = new ModelAndView("register");		
		return andView;
	}
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("mày vừa ấn thoát");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	
	
	@RequestMapping(value = "/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNews() {
		ModelAndView andView = new ModelAndView("admin/news/edit");
		return andView;
	}
	

}
