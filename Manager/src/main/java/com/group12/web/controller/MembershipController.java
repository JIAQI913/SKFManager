package com.group12.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.entity.Membership;
import com.group12.domain.entity.User;
import com.group12.domain.service.MembershipService;

@Controller
public class MembershipController {
	@Autowired
	MembershipService membershipService;
	
	@RequestMapping("/getMembership")
	public ModelAndView getMUpdateMembership(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("USER");
		int invNum=(Integer) session.getAttribute("INVNUM");
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null&&invNum>0){
			modelAndView.setViewName("MUpdateMembership");
			Membership membership=membershipService.searchByInv(invNum);
			modelAndView.addObject("MEMBERSHIP", membership);
			return modelAndView;
		}
		else{
			modelAndView.setViewName("Membership");
			Membership membership=membershipService.searchByInv(invNum);
			modelAndView.addObject("MEMBERSHIP", membership);
			return modelAndView;
		}
	}
}
