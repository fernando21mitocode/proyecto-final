package com.erojas.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationController {

	@RequestMapping(path = {"/"},method = RequestMethod.GET)
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(path = "/admin",method = RequestMethod.GET)
	public String admin(Model model) {
		return "admin";
	}
	
	@RequestMapping(path ="/user",method = RequestMethod.GET)
	public String user(Model model) {
		return "user";
	}
	@RequestMapping(path ="/home",method = RequestMethod.GET)
	public String menu(Model model) {
		return "home";
	}
	
	@RequestMapping(path ="/loginForm",method = RequestMethod.GET)
	public String login(Model model,@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",required = false) String logout) {
		if(error !=null) {
			model.addAttribute("error"," Invalid username and password." );
		}
		if(logout !=null) {
			model.addAttribute("logout", "You have been logged out.");
		}
		return "index";
	}
	
	@RequestMapping(path="/403",method=RequestMethod.GET)
	public String accesoDenegado(Model model ) {

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("usuario", userDetail.getUsername());
		}
		return "403";
	}
}
