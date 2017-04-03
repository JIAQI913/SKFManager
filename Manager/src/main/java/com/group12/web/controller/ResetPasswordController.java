package com.group12.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group12.domain.entity.User;
import com.group12.domain.service.UserService;

@Controller
public class ResetPasswordController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/getResetPassword")
	public String getResetPassword(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		return "ResetPassword";
	}
	
	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(HttpServletRequest req, HttpServletResponse resp){
		String newPassword=req.getParameter("password");
		String oldPassword=req.getParameter("oldPassword");
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
//		System.out.println(user.getUserPassword());
//		System.out.println(oldPassword);
//		System.out.println(newPassword);
		if(user.getUserPassword().equals(oldPassword)){
			user.setUserPassword(newPassword);
			userService.changePassword(user);
			if(user.getStuNum()==null){
				return "MCheckStudentInfo";
			}
			else{
				return "StudentInfo";
			}
		}
		else{
			return "ResetPassword";
		}
	}
}
