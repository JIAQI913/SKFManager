package com.group12.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.entity.User;

@Controller
public class MCreatePaymentController {
	
	
	@RequestMapping("/getMCreatePayment")
	public String getMCreatePayment(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		if(user!=null&&user.getStuNum()==null){
			return "MCreatePayment";
		}
		else{
			return "Index";
		}
	}
}
