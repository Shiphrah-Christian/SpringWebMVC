package com.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.UserDao;
import com.model.UserModel;
import com.model.booktable;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;
	@RequestMapping("/")
	public String index(Model m) {
		return "index";
	}
	@RequestMapping("about")
	public String about(Model m) {
		return "about";
	}
	@RequestMapping("contact")
	public String contact(Model m) {
		return "contact";
	}
	@RequestMapping("register")
	public String register(Model m) {
		return "register";
	}
	@RequestMapping(value="registerUser",method= RequestMethod.POST)
	public RedirectView register(@ModelAttribute UserModel u,HttpServletRequest request) {
		this.dao.insertUser(u);
		RedirectView redirectView =  new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	@RequestMapping("login")
	public String login(Model m) {
		return "login";
	}
	@RequestMapping("welcome")
	public String welcome(Model m) {
		return "welcome";
	}
	@RequestMapping(value="loginUser",method= RequestMethod.POST)
	public RedirectView login(@ModelAttribute UserModel u,HttpServletRequest request)
	{
		RedirectView redirectView =  new RedirectView();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserModel u1 = this.dao.getDataById(u);
		System.out.println(u1);
		if(u1.getEmail().equals(email)) 
		{
			if(u1.getPassword().equals(password))
			{
				redirectView.setUrl(request.getContextPath()+"/welcome");
			}
			else
			{
				
			}
		}
		return redirectView;
	}
	@RequestMapping("bookatable")
	public String bookatable(Model m) {
		return "bookatable";
	}
	@RequestMapping(value="bookatable",method= RequestMethod.POST)
	public RedirectView bookatable(@ModelAttribute booktable u,HttpServletRequest request) 
	{
		RedirectView redirectView =  new RedirectView();
		this.dao.bookatable(u);
		redirectView.setUrl(request.getContextPath()+"/bookatable");
		return redirectView;
	}
	
}
	